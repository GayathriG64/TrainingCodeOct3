package com.digitalbooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.digitalbooks.entity.Book;
import com.digitalbooks.service.IUserService;

@RestController
public class AuthorController {
	
	@Autowired
	IUserService userService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/userservice/getBookById/{id}")
	public Book getBookByID(@PathVariable Long id) {
		Book book = restTemplate.getForObject("http://localhost:8090/api/v1/digitalbooks/getBook/"+id,Book.class);
		//Book dummy = new Book();
		System.out.println(book);
		return book;
	}
}
