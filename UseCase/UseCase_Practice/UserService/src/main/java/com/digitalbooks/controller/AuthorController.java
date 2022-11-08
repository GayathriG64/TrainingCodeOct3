package com.digitalbooks.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.digitalbooks.entity.Author;
import com.digitalbooks.entity.Book;
import com.digitalbooks.service.IAuthorService;

@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/v1/digitalbooks/userservice")
@RestController
public class AuthorController {
	
	@Autowired
	IAuthorService userService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/getBookById/{id}")
	public Book getBookByID(@PathVariable Long id) {
		Book book = restTemplate.getForObject("http://localhost:8090/api/v1/digitalbooks/getBook/"+id,Book.class);
		//Book dummy = new Book();
		System.out.println(book);
		return book;
	}
	
	@PostMapping("/author/signin")
	public Long authorSignin(@RequestBody Author author) {
		Long id= userService.addAuthor(author);
		return id;
	}
	
	@PostMapping("/author/login")
	public Long authorLogin(@RequestBody Author author) {
		Author realAuthor = userService.getAuthorByemailID(author.getAuthoremailId());
		if(realAuthor.getAuthorPassword().equals(author.getAuthorPassword()))
			return realAuthor.getAuthorID();
		return 0L;
	}
	
	@GetMapping("/author/getbooks/{authorId}")
	public List<Book> getAllAuthorBooks(@PathVariable Long authorId){
		List book = restTemplate.getForObject
				("http://localhost:8090/api/v1/digitalbooks/getBooks/"+authorId,List.class);
		//http://localhost:8090/api/v1/digitalbooks/2/getBooks
		return book;
	}
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping("author/block/{authorId}/{bookId}")
	public Boolean blockBook(@PathVariable Long authorId,@PathVariable Long bookId) {
		Map<String,Long> params = new HashMap<String,Long>();
		params.put("authorID",authorId);
		params.put("bookID", bookId);
		restTemplate.postForEntity("http://localhost:8090/api/v1/digitalbooks/author/{authorID}/{bookID}?block=yes",
				null, Boolean.class, params);
		//restTemplate.post("http://localhost:8090/api/v1/digitalbooks/author/{authorID}/{bookID}?block=yes",null,params);
		Book book = restTemplate.getForObject("http://localhost:8090/api/v1/digitalbooks/getBook/"+bookId,Book.class);
		return book.getActive();
	}
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping("author/unblock/{authorId}/{bookId}")
	public Boolean unBlockBook(@PathVariable Long authorId,@PathVariable Long bookId) {
		Map<String,Long> params = new HashMap<String,Long>();
		params.put("authorID",authorId);
		params.put("bookID", bookId);
		restTemplate.postForEntity("http://localhost:8090/api/v1/digitalbooks/author/{authorID}/{bookID}?block=no",
				null, Boolean.class, params);
		//restTemplate.post("http://localhost:8090/api/v1/digitalbooks/author/{authorID}/{bookID}?block=yes",null,params);
		Book book = restTemplate.getForObject("http://localhost:8090/api/v1/digitalbooks/getBook/"+bookId,Book.class);
		return book.getActive();
	}
	
	@PostMapping("/author/createbook/{authorId}")
	public Book saveBookByAuthor(@PathVariable Long authorId,@RequestBody Book book){
		Map<String,Long> params = new HashMap<String,Long>();
		params.put("authorID",authorId);
		try {
		ResponseEntity<Book> re=restTemplate.postForEntity("http://localhost:8090/api/v1/digitalbooks/author/{authorID}/saveBook"
				, book, Book.class,params);
		return re.getBody();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
