package com.customer.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.customer.controller.CustomerController;
import com.customer.entity.Customer;
import com.customer.entity.Transaction;
import com.customer.model.LoginRequest;
import com.customer.model.UpdateRequest;
import com.customer.repository.CustomerRepo;
import com.customer.repository.ITransactionRepo;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepo custRepo;
	@Autowired
	ITransactionRepo tranRepo;
	
	@Autowired
	private PasswordEncoder bCryptEnc;
	
	@Override
	public Long saveCustomer(Customer customer) {
		
		
		if(custRepo.findByUsername(customer.getUsername()).isEmpty()
			&& custRepo.findByEmail(customer.getEmail()).isEmpty() 
			&& Objects.nonNull(customer.getAccType()))
		{
			
			customer.setPassword(bCryptEnc.encode(customer.getPassword()));
			System.out.println(customer.getPassword());
			return custRepo.save(customer).getAccountId();
		}
		else {
			return 1L;	
		}
				
	}
	@Override
	public Customer validateLoginRequest(LoginRequest request) {
		
		if(request.getUsername()==null) {
			return new Customer("Can't take null values");
		}
		List<Customer> custList= custRepo.findByUsername(request.getUsername());
		if(custList.isEmpty()) {
			return new Customer("User Not found!");
		}
		else if (custList.get(0).getPassword().equals(request.getPassword())) {
			return custList.get(0);
		}
		else 
			return new Customer("Please enter correct password.");
	}
	
	@Override
	public String updateCustomerRequest(UpdateRequest request, String username)
	{	
		if(request.getEmail()==null) {
			return "Can't take nulls";
		}
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
		
	
		return custRepo.findByUsername(username).isEmpty()? CustomerController.BOOLEAN_FALSE:  CustomerController.BOOLEAN_TRUE;
	}
	@Override
	public Long getAccountId(String username) {
		List<Customer> loanList = custRepo.findByUsername(username);
		if(loanList.isEmpty())
			return 0L;
		else
			return loanList.get(0).getAccountId();

	}
	@Override
	public Transaction saveTransaction(Long accountId, Long vendorAccountId,Long amount) {
		Customer customer = custRepo.findById(accountId).orElse(null);
		Customer vendor = custRepo.findById(vendorAccountId).orElse(null);
		if(vendor==null) {
			return new Transaction("Vendor not found");
		}
		Date date = Date.valueOf(LocalDate.now());
		//if customer is null do session management
		if(customer.getAmount()<amount) {
			return new Transaction("No sufficient balance");
		}
		Transaction debitTransaction = new Transaction(accountId, vendorAccountId, "debit", amount, date, customer.getAmount()-amount); 
		Transaction creditTransaction = new Transaction(vendorAccountId, accountId, "credit", amount, date, vendor.getAmount()+amount); 
		Transaction debit=tranRepo.save(debitTransaction);
		tranRepo.save(creditTransaction);
		updateCustomerAmount(vendorAccountId, vendor.getAmount()+amount);
		updateCustomerAmount(accountId, customer.getAmount()-amount);
		return debit;
	}
	@Override
	public void updateCustomerAmount(Long accountId,Long amount) {
		Customer customer= custRepo.findById(accountId).orElse(new Customer());
		customer.setAmount(amount);
		custRepo.save(customer);
	}
	@Override
	public List<Transaction> getAllTransactions(String username) {
		Long accountId = getAccountId(username);
		return tranRepo.findByAccountId(accountId);
	}
	@Override
	public Customer getCustomer(String username) {
		
		return custRepo.findByUsername(username).get(0);
	}
	
	
}
