package com.digitalbooks.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Book {
	
	String title;
	String category;
	Double price;
	String author;
	String publisher;
	Date publishedDate;
	String content;
	Boolean active;
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
	public Date getPublishedDate() {
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
	public void setPublishedDate(Date publishedDate) {
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
		return "Book [title=" + title + ", category=" + category + ", price=" + price + ", author=" + author
				+ ", publisher=" + publisher + ", publishedDate=" + publishedDate + ", content=" + content + ", active="
				+ active + "]";
	}
	
	
}
