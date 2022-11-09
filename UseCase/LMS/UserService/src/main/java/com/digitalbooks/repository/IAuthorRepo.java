package com.digitalbooks.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.digitalbooks.entity.Author;

@Repository
public interface IAuthorRepo extends JpaRepository<Author,Long>{
	@Query("SELECT a from AUTHOR a where authoremailId=: authoremailId ") 
	List<Author> findByAuthoremailId(@Param("authoremailId") String authoremailId);
	 
}
