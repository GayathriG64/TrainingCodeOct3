package com.customer.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Transaction {
	@Id
	@SequenceGenerator(name ="transeq" , initialValue = 111110)
	@GeneratedValue( generator = "transeq")
	private Long tranactionId;
	private Long accountId;
	private long vendorAccountId;
	private String transactionType;
	private Long transactionAmount;
	//@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date transactionDate;
	private Long finalAmount;
	private String message;
	
	public String getStatus() {
		return message;
	}
	public void setStatus(String status) {
		this.message = status;
	}
	public Long getTranactionId() {
		return tranactionId;
	}
	public void setTranactionId(Long tranactionId) {
		this.tranactionId = tranactionId;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public long getVendorAccountId() {
		return vendorAccountId;
	}
	public void setVendorAccountId(long vendorAccountId) {
		this.vendorAccountId = vendorAccountId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Long getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Long getFinalAmount() {
		return finalAmount;
	}
	public void setFinalAmount(Long finalAmount) {
		this.finalAmount = finalAmount;
	}
	public Transaction(Long accountId, long vendorAccountId, String transactionType, Long transactionAmount,
			Date transactionDate, Long finalAmount) {
		super();
		this.accountId = accountId;
		this.vendorAccountId = vendorAccountId;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.finalAmount = finalAmount;
	}
	
	public Transaction(String status) {
		super();
		this.message = status;
	}
	public Transaction() {
		super();
	}
	
}
