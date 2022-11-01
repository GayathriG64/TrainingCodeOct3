package com.digitalbooks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reader {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ReaderId;
	private String emailId;
	private String readerName;
	private String readerPassword;
	
}
