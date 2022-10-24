package com.book.service;

import java.util.List;

import com.book.entity.Book;

public interface IBookService {
	
	public Integer saveBook(Book book);
	public List<Book> getAllBooks();
	public Book getBookByID(Integer id);
	public Integer deleteBook(Integer id);
	public Book updateBook(Integer id,Book book);
	public Book changeStatus(Integer id,Boolean status);
}
