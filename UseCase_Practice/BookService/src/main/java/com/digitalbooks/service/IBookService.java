package com.digitalbooks.service;

import java.util.List;

import com.digitalbooks.entity.Book;

public interface IBookService {
//	public Book getBookByTCAP(String title,String category,String author,Double price);
	public Book saveBook(Book book);
	public List<Book> saveAllBooks(List<Book> bookList);
}
