package com.digitalbooks.service;

import com.digitalbooks.entity.Author;

public interface IAuthorService {
	public Long addAuthor(Author author);
	public Author getAuthorByemailID(String emaild);
}
