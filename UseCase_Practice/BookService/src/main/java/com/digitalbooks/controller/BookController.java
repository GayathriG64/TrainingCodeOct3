package com.digitalbooks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		
		@PutMapping("/author/{authorID}/books/{bookID}")
		public Book blockorunBlockABook(@PathVariable Long authorID,@PathVariable Long bookID,
				@RequestParam String block  ) {
			Book updatedBook = bookService.blockBook(bookID, block);
			return updatedBook;
		}
		
}
