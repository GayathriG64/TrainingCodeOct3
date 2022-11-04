package com.digitalbooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.digitalbooks.entity.Book;
import com.digitalbooks.entity.Reader;
import com.digitalbooks.entity.Subscription;
import com.digitalbooks.service.IReaderService;
import com.digitalbooks.service.ISubscribeService;

@RestController
@RequestMapping("/api/v1/digitalbooks")
public class ReaderController {
	@Autowired
	IReaderService readerService ;
	@Autowired
	ISubscribeService subscribedService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/{readerId}/{bookid}/subscribe")
	public Subscription subscribeBook(@PathVariable Long readerId,@PathVariable Long bookid) {
		Book getBook = restTemplate.getForObject("http://localhost:8090/api/v1/digitalbooks/getBook/"+bookid,Book.class);
	//	Subscription subscribed= subscribedService.getSubscriptionByReaderId(readerId);
	//	if(subscribed== null)
	//		return null;
		Subscription newSub = new Subscription();
		newSub.setReaderId(readerId);
		newSub.setBookId(bookid);
		java.time.LocalDateTime now =java.time.LocalDateTime.now();  
		newSub.setSubscribedTime(now);
		Subscription savedSub=subscribedService.saveSubscription(newSub);
		return savedSub;
	}
	@GetMapping("/readers/{emailid}/books/{subid}")
	public Book getBookBySubscription(@PathVariable String emailid,@PathVariable Long subid) {
		Subscription sub= subscribedService.getSubscriptionBySubscriptionId(subid);
		Long readerID= sub.getReaderId();
		Long bookId=sub.getBookId();
		Reader reader = readerService.getReaderByREaderId(readerID);
		
		if(reader.getEmailId().equals(emailid)) {
			Book book=restTemplate.getForObject("http://localhost:8090/api/v1/digitalbooks/getBook/"+bookId,Book.class);
			return book;
		}
	 
		return null;
	}
	@PostMapping("reader/register")
	public String registerReader(@RequestBody Reader reader) {
		Reader savedReader =readerService.saveReader(reader);
		return "saved reader with id :"+savedReader.getReaderId();
	}
	@GetMapping("reader/login")
	public Boolean loginReader(@RequestBody Reader reader) {
		Reader realReader = readerService.getReaderByEmailId(reader.getEmailId());
		if(realReader.getReaderPassword().equals(reader.getReaderPassword()))
			return true;
		return false;
	}
	
}
