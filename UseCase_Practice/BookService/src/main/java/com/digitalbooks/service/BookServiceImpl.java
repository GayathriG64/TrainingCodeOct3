package com.digitalbooks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.entity.Book;
import com.digitalbooks.repository.IBookRepo;

@Service
public class BookServiceImpl implements IBookService{
	
	@Autowired
	IBookRepo bookRepo;
/*	
	@Override
	public Book getBookByTCAP(String title, String category, String author, Double price) {
		// TODO Auto-generated method stub
		bookRepo.getBookbyTCAP(title,category,author,price);
		return null;
	}
*/

	@Override
	public Book saveBook(Book book) {
		Book savedBook= bookRepo.save(book);
		return savedBook;
	}

	@Override
	public List<Book> saveAllBooks(List<Book> bookList) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
