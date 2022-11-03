package com.digitalbooks.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reader {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ReaderId;
	private String readerName;
	@Column(unique = true)
	private String emailId;
	private String readerPassword;
	public Long getReaderId() {
		return ReaderId;
	}
	public void setReaderId(Long readerId) {
		ReaderId = readerId;
	}
	public String getReaderName() {
		return readerName;
	}
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getReaderPassword() {
		return readerPassword;
	}
	public void setReaderPassword(String readerPassword) {
		this.readerPassword = readerPassword;
	}
	public Reader(Long readerId, String readerName, String emailId, String readerPassword) {
		super();
		ReaderId = readerId;
		this.readerName = readerName;
		this.emailId = emailId;
		this.readerPassword = readerPassword;
	}
	public Reader(String readerName, String emailId, String readerPassword) {
		super();
		this.readerName = readerName;
		this.emailId = emailId;
		this.readerPassword = readerPassword;
	}
	public Reader() {
		super();
	}
	
	
}
