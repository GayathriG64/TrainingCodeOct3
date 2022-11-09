package com.digitalbooks.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.digitalbooks.entity.Book;
import com.digitalbooks.entity.Reader;
import com.digitalbooks.entity.Subscription;
import com.digitalbooks.service.IReaderService;
import com.digitalbooks.service.ISubscribeService;

@RestController

@CrossOrigin("*")
@RequestMapping("/api/v1/digitalbooks")
public class ReaderController {
	@Autowired
	IReaderService readerService ;
	@Autowired
	ISubscribeService subscribedService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@CrossOrigin("*")
	@PostMapping("/subscribe/{readerId}/{bookid}")
	public Long subscribeBook(@PathVariable Long readerId,@PathVariable Long bookid) {
		
		Book getBook = restTemplate.getForObject("http://localhost:8090/api/v1/digitalbooks/getBook/"+bookid,Book.class);
		List<Subscription> subscribed= subscribedService.getSubscriptionByReaderId(readerId);
		Subscription isSub= new Subscription();
		subscribed.stream().forEach((sub)->{
		if(sub.getBookId()==bookid) {
			isSub.setSubscriptionID(0L);
		}}
				);
	//	if(subscribed== null)
	//		return null;
		Subscription newSub = new Subscription();
		newSub.setReaderId(readerId);
		newSub.setBookId(bookid);
		java.time.LocalDateTime now =java.time.LocalDateTime.now();  
		newSub.setSubscribedTime(now);
		if(isSub.getSubscriptionID() != null) {
			return isSub.getSubscriptionID();
		}
		Subscription savedSub=subscribedService.saveSubscription(newSub);
		return savedSub.getSubscriptionID();
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
	
	@GetMapping("/readers/books/{emailid}")
	public List<Book> getAllSubscribedBooks(@PathVariable String emailid) {
		Reader reader = readerService.getReaderByEmailId(emailid);	
		Long readerId= reader.getReaderId();
		List<Subscription> subscriptionList= subscribedService.getSubscriptionByReaderId(readerId);
		List<Book>  book = new ArrayList<Book>();
		subscriptionList.stream().forEach(
		(sub)-> {book.add(
		restTemplate.getForObject("http://localhost:8090/api/v1/digitalbooks/getBook/"+sub.getBookId(),Book.class)
		);}
		);
/*	if(reader.getEmailId().equals(emailid)) {
			Book book=restTemplate.getForObject("http://localhost:8090/api/v1/digitalbooks/getBook/"+bookId,Book.class);
			return book;
		} 
*/
		return book;
	}
	
	@GetMapping("/readers/Allbooks/{emailid}")
	public List<Book> getAllBooks(@PathVariable String emailid) {
		Reader reader = readerService.getReaderByEmailId(emailid);	
		List<Book>  book = new ArrayList<Book>();
		
		if(reader!=null) {
			book= restTemplate.getForObject("http://localhost:8090/api/v1/digitalbooks/getAllBooks",
					List.class);
			
		//	List<Book> bookList =book.stream()
		//			 .filter(b-> b.getBlocked()=="no")
		//			 .collect(Collectors.toList());
			
		//	 book.addAll(bookList);
		}
		return book;
	}
	
	@PostMapping("reader/register")
	public Long registerReader(@RequestBody Reader reader) {
		Reader ifReader = readerService.getReaderByEmailId(reader.getEmailId());
		if(ifReader== null) {
			Reader savedReader =readerService.saveReader(reader);
			return savedReader.getReaderId();
		}
		return 0L;
	}
	@PostMapping("reader/login")
	public Long loginReader(@RequestBody Reader reader ) {
		Reader realReader = readerService.getReaderByEmailId(reader.getEmailId());
		if(realReader==null)
			return 0L;
		if(realReader.getReaderPassword().equals(reader.getReaderPassword()))
			return realReader.getReaderId();
		return 0L;
	}
	@PostMapping("/unsubscribe/{readerId}/{bookid}")
	public Long unsubscribe(@PathVariable Long readerId,@PathVariable Long bookid) {
		List<Subscription> subList= subscribedService.getSubscriptionByReaderId(readerId);
		List<Subscription> sub1=new ArrayList<Subscription>();
		subList.stream().filter(s-> s.getBookId()==bookid)
				.forEach(s-> {sub1.add(s);} );
		if(!sub1.isEmpty()) {
			Subscription sub =sub1.get(0);
			java.time.LocalDateTime now =java.time.LocalDateTime.now();  
			if(now.compareTo(sub.getSubscribedTime())<=1 && now.compareTo(sub.getSubscribedTime())>=-1 )
				subscribedService.delete(sub.getSubscriptionID());
			else
				return 2L;
			return 1L;
		}
		return 0L;
	}
	
	@GetMapping("/check/{readerId}/{bookid}")
	public Long checkBook(@PathVariable Long readerId,@PathVariable Long bookid) {
		List<Subscription> subList= subscribedService.getSubscriptionByReaderId(readerId);
		List<Subscription> sub1=new ArrayList<Subscription>();
		subList.stream().filter(s-> s.getBookId()==bookid)
				.forEach(s-> {sub1.add(s);} );
		if(!sub1.isEmpty()) {
			return 1L;
		}
		return 0L;
	}
	
/*	@GetMapping("/readers/{emailId}/books/{subscriptionId}")
	public Book getSubscribedBookByID(@PathVariable String emailId,@PathVariable Long subscriptionId) {
		Long bookId=0L;
		Subscription sub= subscribedService.getSubscriptionBySubscriptionId(subscriptionId);
		Reader reader = readerService.getReaderByEmailId(emailId);
		if(sub.getReaderId().equals(reader.getReaderId())){
			bookId= sub.getBookId();
		}
		Book book =restTemplate.getForObject("http://localhost:8090/api/v1/digitalbooks/getBook/"+bookId,Book.class);
		return book;
	}
*/
}
