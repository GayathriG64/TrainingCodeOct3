package com.digitalbooks.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long authorID;
	private String authorName;
	@Column(unique = true)
	private String authoremailId;
	public Author() {
		super();
	}
	private String authorPassword;
	
	public Author(String authorName, String authoremailId, String authorPassword) {
		super();
		this.authorName = authorName;
		this.authoremailId = authoremailId;
		this.authorPassword = authorPassword;
	}
	public Author(Long authorID, String authorName, String authoremailId, String authorPassword) {
		super();
		this.authorID = authorID;
		this.authorName = authorName;
		this.authoremailId = authoremailId;
		this.authorPassword = authorPassword;
	}
	public Long getAuthorID() {
		return authorID;
	}
	public void setAuthorID(Long authorID) {
		this.authorID = authorID;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthoremailId() {
		return authoremailId;
	}
	public void setAuthoremailId(String authoremailId) {
		this.authoremailId = authoremailId;
	}
	public String getAuthorPassword() {
		return authorPassword;
	}
	public void setAuthorPassword(String authorPassword) {
		this.authorPassword = authorPassword;
	}
	
}
