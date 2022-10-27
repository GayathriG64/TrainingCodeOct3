package com.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Book;
import com.book.exception.ResourceNotFoundException;
import com.book.repo.IBookRepo;

@Service
public class BookServiceImpl implements IBookService {
	
	@Autowired
	IBookRepo bookRepo;
	@Override
	public Integer saveBook(Book book) {
		Book savedBook = bookRepo.save(book);
		return savedBook.getBookID();
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = bookRepo.findAll();
		return books;
	}

	@Override
	public Book getBookByID(Integer id) {
		Book foundbook  = bookRepo.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Given book id :"+id+" doesn't exist")); 
		return foundbook;
	}

	@Override
	public Integer deleteBook(Integer id) {
		Book updatedBook = bookRepo.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Given book id :"+id+" doesn't exist"));
		bookRepo.deleteById(id);
		return id;
	}

	@Override
	public Book updateBook(Integer id,Book book) {
		Book updatedBook = bookRepo.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Given book id :"+id+" doesn't exist"));
		updatedBook.setBookAuthor(book.getBookAuthor());
		updatedBook.setBookGenre(book.getBookGenre());
		updatedBook.setBookName(book.getBookName());
		updatedBook.setBookPrice(book.getBookPrice());
		updatedBook.setBorrowedStatus(book.getBorrowedStatus());
		bookRepo.save(updatedBook);
		return updatedBook;
	}

	@Override
	public Book changeStatus(Integer id,Boolean status) {
		Book updatedBook = bookRepo.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Given id:"+id+" doesn't exist"));
		
		updatedBook.setBorrowedStatus(status);
		bookRepo.save(updatedBook);
		return updatedBook;
	}
	
	
}
