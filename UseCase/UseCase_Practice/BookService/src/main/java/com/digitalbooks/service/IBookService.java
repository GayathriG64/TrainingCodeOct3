package com.digitalbooks.service;

import java.util.List;

import com.digitalbooks.entity.Book;

public interface IBookService {
//	public Book getBookByTCAP(String title,String category,String author,Double price);
	public Book saveBook(Book book);
	public List<Book> saveAllBooks(List<Book> bookList);
	public Book blockBook(Long bookId,String block);
	public Book updateBook(Book book);
	public Book getBookByID(Long id);
}
