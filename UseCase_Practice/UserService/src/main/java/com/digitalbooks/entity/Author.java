package com.digitalbooks.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

@Entity
public class Author {
	private String authorName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long authorID;
	
	@Column(unique = true)
	private String authorUserName;
	private String authorPassword;
}
