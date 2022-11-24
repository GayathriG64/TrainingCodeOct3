package com.customer.service;

import com.customer.entity.Customer;
import com.customer.model.LoginRequest;
import com.customer.model.UpdateRequest;

public interface CustomerService {
	public Long saveCustomer(Customer customer);

	public String validateLoginRequest(LoginRequest request);

	public String updateCustomerRequest(UpdateRequest request,String username);

	public boolean checkUsername(String username);
	
	public Long getAccountId(String username);
}
