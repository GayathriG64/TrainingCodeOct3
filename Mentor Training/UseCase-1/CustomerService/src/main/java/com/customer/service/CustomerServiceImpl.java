package com.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
import com.customer.entity.Loan;
import com.customer.exception.ResourceExists;
import com.customer.exception.ResourceNotFoundException;
import com.customer.model.LoginRequest;
import com.customer.model.UpdateRequest;
import com.customer.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo custRepo;
	@Override
	public Long saveCustomer(Customer customer) {
		
		Customer savedCustomer = new Customer();
		if(custRepo.findByUsername(customer.getUsername()).isEmpty()
			&& custRepo.findByEmail(customer.getEmail()).isEmpty())
			savedCustomer= custRepo.save(customer);
		else
			throw new ResourceExists("Customer");		
		return savedCustomer.getAccountId();
	}
	@Override
	public String validateLoginRequest(LoginRequest request) {
		List<Customer> custList= custRepo.findByUsername(request.getUsername());
		if(custList.isEmpty()) {
			throw new ResourceNotFoundException("Customer","username" , request.getUsername());
		}
		else if (custList.get(0).getPassword().equals(request.getPassword())) {
			return "Welcome! "+custList.get(0).getName()+"!";
		}
		else 
			return "Please enter correct password.";
	}
	
	@Override
	public String updateCustomerRequest(UpdateRequest request, String username)
	{
		List<Customer> customer = custRepo.findByUsername(username);
		if(customer.isEmpty()) {
			return("Customer not found!");
		}
		Customer updateCustomer= customer.get(0);
		updateCustomer.setAddress(request.getAddress());
		updateCustomer.setCountry(request.getCountry());
		updateCustomer.setEmail(request.getEmail());
		updateCustomer.setState(request.getState());
		updateCustomer.setPhoneNo(request.getPhoneNo());
		updateCustomer.setName(request.getName());
		Customer savedCustomer= custRepo.save(updateCustomer);
		return savedCustomer.getName();
	}
	@Override
	public boolean checkUsername(String username) {
		
		if(custRepo.findByUsername(username).isEmpty())
			return false;		
		return true;
	}
	@Override
	public Long getAccountId(String username) {
		List<Customer> loanList = custRepo.findByUsername(username);
		if(loanList.isEmpty())
			return 0L;
		else
			return loanList.get(0).getAccountId();

	}
	

}
