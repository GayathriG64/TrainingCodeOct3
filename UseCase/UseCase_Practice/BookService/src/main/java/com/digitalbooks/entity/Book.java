package com.digitalbooks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	Long subscriptionID;
	Long authorID;
	Long readerID;
	String subscribed;
	String blocked;
	
	String logo;
	
	public Book(String title, String category, Double price,Long AuthorID, String author, String publisher, String publishedDate,
			String content, Boolean active, String logo) {
		this.title = title;
		this.category = category;
		this.price = price;
		this.authorID=AuthorID;
		this.author = author;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.content = content;
		this.active = active;
		this.logo = logo;
	}
	
	public Book(String title, String category, Double price,Long AuthorID, String author, String publisher, String publishedDate,
			String content, String logo) {
		this.title = title;
		this.category = category;
		this.price = price;
		this.authorID=AuthorID;
		this.author = author;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.content = content;
		this.active = true;
		this.logo = logo;
	}
	public Book() {
		super();
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Long getSubscriptionID() {
		return subscriptionID;
	}
	public Long getAuthorID() {
		return authorID;
	}
	public Long getReaderID() {
		return readerID;
	}
	public String getBlocked() {
		return blocked;
	}
	public void setSubscriptionID(Long subscriptionID) {
		this.subscriptionID = subscriptionID;
	}
	public void setAuthorID(Long authorID) {
		this.authorID = authorID;
	}
	public void setReaderID(Long readerID) {
		this.readerID = readerID;
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
				+ content + ", active=" + active + ", SubscriptionID=" + subscriptionID + ", AuthorID=" + authorID
				+ ", ReaderID=" + readerID + ", subscribed=" + subscribed + ", blocked=" + blocked + "]";
	}

	public Book(String title, String category, Double price, String author, String publisher, String publishedDate,
			String content, Boolean active, Long subscriptionID, Long authorID, Long readerID, String subscribed,
			String blocked, String logo) {
		super();
		this.title = title;
		this.category = category;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.content = content;
		this.active = active;
		this.subscriptionID = subscriptionID;
		this.authorID = authorID;
		this.subscribed = subscribed;
		this.logo = logo;
	}
	

	
}
