package com.digitalbooks.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subscription {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long subscriptionID;
	private Long readerId;
	private Long bookId;
	private LocalDateTime subscribedTime;
	public Subscription(Long subscriptionID, Long readerId, Long bookId, LocalDateTime subscribedTime) {
		super();
		this.subscriptionID = subscriptionID;
		this.readerId = readerId;
		this.bookId = bookId;
		this.subscribedTime = subscribedTime;
	}
	public Subscription(Long readerId, Long bookId, LocalDateTime subscribedTime) {
		super();
		this.readerId = readerId;
		this.bookId = bookId;
		this.subscribedTime = subscribedTime;
	}
	public Subscription() {
		super();
	}
	public Long getSubscriptionID() {
		return subscriptionID;
	}
	public void setSubscriptionID(Long subscriptionID) {
		this.subscriptionID = subscriptionID;
	}
	public Long getReaderId() {
		return readerId;
	}
	public void setReaderId(Long readerId) {
		this.readerId = readerId;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public LocalDateTime getSubscribedTime() {
		return subscribedTime;
	}
	public void setSubscribedTime(LocalDateTime subscribedTime) {
		this.subscribedTime = subscribedTime;
	}
	
}
