package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.Book;
import com.book.service.IBookService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class BookController {

	@Autowired
	IBookService bookService;
	
	@PostMapping("/add/book")
	public Integer saveBook(@RequestBody Book book) {
		Integer id = bookService.saveBook(book);
		return id;
	}
	
	@GetMapping("/allBooks")
	public List<Book> getAllBooks() {
		List<Book> books = bookService.getAllBooks();
		return books;
	}
	
	@GetMapping("/read/{id}")
	public Book getBook(@PathVariable Integer id) {
		Book book = bookService.getBookByID(id);
		return book;
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable Integer id) {
		ResponseEntity<Book> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			bookService.deleteBook(id);
		}
		catch(Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	@PutMapping("/update/{id}")
	public Book updateBook(@PathVariable Integer id,@RequestBody Book book) {
		Book updatedBook = bookService.updateBook(id,book);
		return updatedBook;
	}
	
	@PutMapping("/borrow/{id}")
	public Book borrowBook(@PathVariable Integer id, 
			@RequestParam(required = true) Boolean status) {
		System.out.println(status);
		Book book = bookService.changeStatus(id,status);
		return book;
	}
}
