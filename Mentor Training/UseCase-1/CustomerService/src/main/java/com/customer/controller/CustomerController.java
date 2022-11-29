package com.customer.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.customer.entity.Customer;
import com.customer.entity.Loan;
import com.customer.model.LoginRequest;
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
	
	@PostMapping("/apply/loan/{username}")
	public Loan applyLoan(@PathVariable String username,@RequestBody Loan loan)
	{
		
		Long accountID = customerService.getAccountId(username) ;
		if(accountID==0)
			return null;
		Map<String,Long> params = new HashMap<>();
		params.put("accountID",accountID);
		return restTemplate.postForObject("http://localhost:8091/loan/apply/{accountID}",
					loan, Loan.class,params);

	}
	
	@GetMapping("/getAllLoans/{username}")
	public List<Loan> getAllLoans(@PathVariable String username){
		List<Loan> listLoan ;
		
		Long accountID = customerService.getAccountId(username) ;
		
		if(accountID==0)
			return Collections.emptyList();
		Map<String,Long> params = new HashMap<>();
		params.put("accountID",accountID);
		listLoan= restTemplate.getForObject("http://localhost:8091/loan/AllLoans/"+accountID, List.class);
		return listLoan;
	}
}
