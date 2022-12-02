package com.customer.service;

import java.util.List;

import com.customer.entity.Customer;
import com.customer.entity.Transaction;
import com.customer.model.LoginRequest;
import com.customer.model.UpdateRequest;

public interface CustomerService {
	public Long saveCustomer(Customer customer);

	public String validateLoginRequest(LoginRequest request);

	public String updateCustomerRequest(UpdateRequest request,String username);

	public boolean checkUsername(String username);
	
	public Long getAccountId(String username);
	
	public Transaction saveTransaction(Long accountId,Long vendorAccountId,Long amount);
	
	public void updateCustomerAmount(Long accountId,Long amount);
	
	public List<Transaction> getAllTransactions(String username);
	public Customer getCustomer(String username);
}
