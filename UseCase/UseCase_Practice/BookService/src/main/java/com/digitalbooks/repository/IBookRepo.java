package com.digitalbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalbooks.entity.Book;
import java.util.List;

@Repository
public interface IBookRepo extends JpaRepository<Book, Long> {
	List<Book> findByAuthorID(Long authorID);
	
}
