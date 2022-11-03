package com.digitalbooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.digitalbooks.entity.Author;
import com.digitalbooks.entity.Book;
import com.digitalbooks.service.IAuthorService;

@RequestMapping("/userservice")
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
	
	@GetMapping("/author/login")
	public Boolean authorLogin(@RequestBody Author author) {
		Author realAuthor = userService.getAuthorByemailID(author.getAuthoremailId());
		if(realAuthor.getAuthorPassword().equals(author.getAuthorPassword()))
			return true;
		return false;
	}
	
}
