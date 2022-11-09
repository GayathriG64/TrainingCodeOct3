package com.digitalbooks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbooks.entity.Author;
import com.digitalbooks.entity.Book;
import com.digitalbooks.repository.IAuthorRepo;

@Service
public class AuthorServiceImpl implements IAuthorService {
	
	@Autowired
	IAuthorRepo authorRepo;
	@Override
	public Long addAuthor(Author author) {
		Author createdAuthor=authorRepo.save(author);
		return createdAuthor.getAuthorID();
	}
	@Override
	public List<Author> getAuthorByemailID(String emailId) {
		List<Author> author= authorRepo.findByAuthoremailId(emailId);
		return author;
	}
	
	
}
