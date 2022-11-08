package com.digitalbooks.service;

import java.util.List;
import java.util.Optional;

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
		List<Book> savedBookList= bookRepo.saveAll(bookList);
		return savedBookList;
	}

	@Override
	public Book blockBook(Long bookId, String block) {
		Optional<Book> updateBook = bookRepo.findById(bookId);
		if(block.equals("no")) {
			updateBook.orElse(null).setActive(true);
			updateBook.orElse(null).setBlocked("no");
		}
		else {
			updateBook.orElse(null).setActive(false);
			updateBook.orElse(null).setBlocked("yes");
		}
		Book updatedbook = bookRepo.save(updateBook.orElse(null));
		return updatedbook;
	}

	@Override
	public Book updateBook(Book book) {
		Optional<Book> updatedBook = bookRepo.findById(book.getBookID());
		Book updateBook= updatedBook.orElseThrow();
		updateBook.setActive(book.getActive());
		updateBook.setAuthor(book.getAuthor());
		updateBook.setCategory(book.getCategory());
		updateBook.setContent(book.getContent());
		updateBook.setPrice(book.getPrice());
		updateBook.setPublisher(book.getPublisher());
		updateBook.setPublishedDate(book.getPublishedDate());
		updateBook.setLogo(book.getLogo());
		updateBook.setTitle(book.getTitle());
		
		bookRepo.save(updateBook);
		return updateBook;
	}

	@Override
	public Book getBookByID(Long id) {

		Book book =bookRepo.findById(id).orElse(null);
		return book ;
	}

	@Override
	public List<Book> getBooksByAuhtorID(Long authorId) {
		return bookRepo.findByAuthorID(authorId);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	@Override
	public List<Book> searchBook(String title, String category, Double price, String author, String publisher) {
		// TODO Auto-generated method stub
		List<Book> books= bookRepo.searchBook(title,category,price,author,publisher);
		return books;
	}
	

	
}
