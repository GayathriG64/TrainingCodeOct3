package com.digitalbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.digitalbooks.entity.Book;
import java.util.List;

@Repository
public interface IBookRepo extends JpaRepository<Book, Long> {
	List<Book> findByAuthorID(Long authorID);
	@Query("SELECT b from Book b WHERE b.title=:title AND b.category=:category AND b.category=:category "
			+ "AND b.price=:price AND b.author=:author AND b.publisher=:publisher"  )
	List<Book> searchBook(@Param("title") String title,
			@Param("category") String category,
			@Param("price") Double price,
			@Param("author") String author,
			@Param("publisher")String publisher);
}
