package com.digitalbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalbooks.entity.Author;

@Repository
public interface IAuthorRepo extends JpaRepository<Author,Long>{
	 Author findByAuthoremailId(String authoremailId);
	 
}
