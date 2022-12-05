package com.customer.model;

public class TransactionRequest {
	private Long accountId;
	private Long vendorAccountId;
	private Long amount;
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Long getVendorAccountId() {
		return vendorAccountId;
	}
	public void setVendorAccountId(Long vendorAccountId) {
		this.vendorAccountId = vendorAccountId;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public TransactionRequest(Long accountId, Long vendorAccountId, Long amount) {
		super();
		this.accountId = accountId;
		this.vendorAccountId = vendorAccountId;
		this.amount = amount;
	}
	
	
}
