package com.digitalbooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbooks.entity.Book;
import com.digitalbooks.service.IBookService;

@RestController
@RequestMapping("/BookService")
public class BookController {

		@Autowired
		private IBookService bookService;
		
		@PostMapping("/saveBook")
		public Book saveBook(@RequestBody Book book) {
			Book savedBook =bookService.saveBook(book);
			return savedBook;
		}
}
