package com.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
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
		// TODO Auto-generated method stub
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
			return custList.get(0).getName();
		}
		else 
			return "Please enter correct password.";
	}
	@Override
	public String updateCustomerRequest(UpdateRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
