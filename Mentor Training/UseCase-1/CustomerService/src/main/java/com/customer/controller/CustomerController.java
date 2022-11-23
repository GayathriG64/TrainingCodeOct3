package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entity.Customer;
import com.customer.model.LoginRequest;
import com.customer.model.UpdateRequest;
import com.customer.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/customer/register")
	public Long registerCustomer(@RequestBody Customer customer){
		Long accountID=0L;
		try {
		accountID= customerService.saveCustomer(customer);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return accountID;
	}
	@PostMapping("/customer/login")
	public String loginCustomer(@RequestBody LoginRequest request){
		String name="";
		try {
		name= customerService.validateLoginRequest(request);
		}
		catch(Exception e) {
			System.out.println("Oops!"+e.getMessage());
			return e.getMessage();
		}
		return name;
	}
	@PutMapping("/customer/update")
	public String updateCustomer(@RequestBody UpdateRequest request){
		String name="";
		try {
		name= customerService.updateCustomerRequest(request);
		}
		catch(Exception e) {
			System.out.println("Oops!"+e.getMessage());
			return e.getMessage();
		}
		return name;
	}
}
