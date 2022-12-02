package com.customer.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.customer.entity.Customer;
import com.customer.entity.Transaction;
import com.customer.model.LoginRequest;
import com.customer.model.TransactionRequest;
import com.customer.model.UpdateRequest;
import com.customer.service.CustomerService;

@CrossOrigin("*")
@RestController
public class CustomerController {
	public static final Boolean BOOLEAN_TRUE =true;
	public static final Boolean BOOLEAN_FALSE =false;
	@Autowired
	CustomerService customerService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/customer/register")
	public Long registerCustomer(@RequestBody Customer customer){
		Long accountID=0L;
		customer.setAmount(5000L);
		try {
		accountID= customerService.saveCustomer(customer);
		}
		catch(Exception e) {
			e.printStackTrace();
			return 1L;
		}
		return accountID;
	}
	@PostMapping("/customer/login")
	public String loginCustomer(@RequestBody LoginRequest request){
		
		return customerService.validateLoginRequest(request);
	}
	@CrossOrigin("*")
	@PutMapping("/customer/update/{username}")
	public String updateCustomer(@RequestBody UpdateRequest request,
			@PathVariable String username)
	{
		String name="";
		try {
		name= customerService.updateCustomerRequest(request,username);
		}
		catch(Exception e) {
			return "Oops!"+e.getMessage();
		}
		return name;
	}
	
	@GetMapping("/customer/check/{username}")
	public Boolean checkUsername(@PathVariable String username)
	{	
		return customerService.checkUsername(username)? BOOLEAN_TRUE : BOOLEAN_FALSE;
	}
	
	@PostMapping("/customer/sendMoney")
	public ResponseEntity<Transaction> sendMoney(@RequestBody TransactionRequest request)
	{	
		Long accountId= request.getAccountId();
		Long vendorAccountId= request.getVendorAccountId();
		Long amount= request.getAmount();
		Transaction transaction = customerService.saveTransaction(accountId, vendorAccountId, amount);
		if(transaction.getTranactionId()==null){
			return new ResponseEntity<Transaction>(transaction, HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<Transaction>(transaction, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/customer/getAllTransactions/{username}")
	public ResponseEntity<List<Transaction>> getAllTransactions(@PathVariable String username){
		List<Transaction> list= customerService.getAllTransactions(username);
		return new ResponseEntity<>(list, HttpStatus.OK);
		
	}
	
	@GetMapping("/customer/getCustomer/{username}")
	public Customer getCustomer(@PathVariable String username){
		return customerService.getCustomer(username);
	}
	
}
