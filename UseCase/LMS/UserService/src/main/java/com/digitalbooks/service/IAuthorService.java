package com.digitalbooks.service;

import com.digitalbooks.entity.Author;
import com.digitalbooks.entity.Book;

public interface IAuthorService {
	public Long addAuthor(Author author);
	public Author getAuthorByemailID(String emaild);
	
}
