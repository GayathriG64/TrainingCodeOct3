package com.digitalbooks.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long bookID;
	
	String title;
	String category;
	Double price;
	String author;
	String publisher;
	String publishedDate;
	String content;
	Boolean active;
	Long SubscriptionID;
	Long AuthorID;
	Long ReaderID;
	String subscribed;
	String blocked;
	
	String logo;
	
	public Book(String title, String category, Double price, String author, String publisher, String publishedDate,
			String content, Boolean active, String logo) {
		super();
		this.title = title;
		this.category = category;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.content = content;
		this.active = active;
		this.logo = logo;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Long getSubscriptionID() {
		return SubscriptionID;
	}
	public Long getAuthorID() {
		return AuthorID;
	}
	public Long getReaderID() {
		return ReaderID;
	}
	public String getBlocked() {
		return blocked;
	}
	public void setSubscriptionID(Long subscriptionID) {
		SubscriptionID = subscriptionID;
	}
	public void setAuthorID(Long authorID) {
		AuthorID = authorID;
	}
	public void setReaderID(Long readerID) {
		ReaderID = readerID;
	}
	public void setBlocked(String blocked) {
		this.blocked = blocked;
	}
	public String getSubscribed() {
		return subscribed;
	}
	public void setSubscribed(String subscribed) {
		this.subscribed = subscribed;
	}
	public Long getBookID() {
		return bookID;
	}
	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public Double getPrice() {
		return price;
	}
	public String getAuthor() {
		return author;
	}
	public String getPublisher() {
		return publisher;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public String getContent() {
		return content;
	}
	public Boolean getActive() {
		return active;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", title=" + title + ", category=" + category + ", price=" + price
				+ ", author=" + author + ", publisher=" + publisher + ", publishedDate=" + publishedDate + ", content="
				+ content + ", active=" + active + ", SubscriptionID=" + SubscriptionID + ", AuthorID=" + AuthorID
				+ ", ReaderID=" + ReaderID + ", subscribed=" + subscribed + ", blocked=" + blocked + "]";
	}
	

	
}
