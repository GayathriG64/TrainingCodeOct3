package com.digitalbooks.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SubscribedBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer subscriptionID;
	String bookTitle;
	String bootAuthor;
	String readerName;
	LocalDateTime subscribedTime;
	
}
