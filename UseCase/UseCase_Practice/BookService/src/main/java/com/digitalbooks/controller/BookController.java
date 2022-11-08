package com.digitalbooks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.entity.Book;
import com.digitalbooks.service.IBookService;

@RestController

@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/digitalbooks")
public class BookController {

		@Autowired
		private IBookService bookService;
		
		@PostMapping("/author/{authorID}/saveBook")
		public Book saveBook(@PathVariable Long authorID,@RequestBody Book book) {
			book.setAuthorID(authorID);
			Book savedBook =bookService.saveBook(book);
			return savedBook;
		}
		
		@PostMapping("/saveAllBooks")
		public List<Book> saveBook(@RequestBody List<Book> bookList) {
			List<Book> savedBookList =bookService.saveAllBooks(bookList);
			return savedBookList;
		}
		
		@PostMapping("/author/{authorID}/{bookID}")
		public Book blockorunBlockABook(@PathVariable Long authorID,@PathVariable Long bookID,
				@RequestParam(value="block",required =true) String block  ) {
			System.out.println(bookID+block);
			Book updatedBook = bookService.blockBook(bookID, block);
			return updatedBook;
		}
		
		@PutMapping("/author/{authorID}/books/{bookID}/")
		public Book updateBook(@PathVariable Long authorID,@PathVariable Long bookID,@RequestBody Book book) {
			book.setAuthorID(authorID);
			book.setBookID(bookID);
			Book savedBook =bookService.updateBook(book);
			return savedBook;
		}
		
		@GetMapping("getBook/{id}")
		public Book getBookByID(@PathVariable Long id) {
			return bookService.getBookByID(id);	
		}
		@GetMapping("/getBooks/{authorId}")
		public List<Book> getBooksByAuthorID(@PathVariable Long authorId) {
			return bookService.getBooksByAuhtorID(authorId);	
		}
		
		@GetMapping("/getAllBooks")
		public List<Book> getAllBooks() {
			return bookService.getAllBooks();	
		}
		
		@GetMapping("/searchAllBooks/{title}/{category}/{author}/{publisher}/{price}")
		public List<Book> searchAllBooks(@PathVariable String title,
				@PathVariable String category,
				@PathVariable String author,
				@PathVariable String publisher,
				@PathVariable Double price
				) {
			List<Book> book=bookService.searchBook(title,category,price,author,publisher);
			return book;
		}
}
