package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.Book;
import com.book.service.IBookService;

@RestController
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
	
	@PostMapping("/remove/{id}")
	public void deleteBook(@PathVariable Integer id) {
		bookService.deleteBook(id);
	}
	
	@PutMapping("/update/{id}")
	public Book updateBook(@PathVariable Integer id,@RequestBody Book book) {
		Book updatedBook = bookService.updateBook(id,book);
		return updatedBook;
	}
	
	@PutMapping("/borrow/{id}")
	public Book borrowBook(@PathVariable Integer id) {
		Book book = bookService.changeStatus(id,true);
		return book;
	}
}
