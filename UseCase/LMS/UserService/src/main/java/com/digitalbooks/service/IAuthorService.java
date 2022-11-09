package com.digitalbooks.service;

import java.util.List;

import com.digitalbooks.entity.Author;
import com.digitalbooks.entity.Book;

public interface IAuthorService {
	public Long addAuthor(Author author);
	public List<Author> getAuthorByemailID(String emaild);
	
}
