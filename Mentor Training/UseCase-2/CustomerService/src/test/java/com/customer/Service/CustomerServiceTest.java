package com.customer.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.customer.entity.Customer;
import com.customer.repository.CustomerRepo;
import com.customer.service.CustomerService;
import com.customer.service.CustomerServiceImpl;


@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
	@InjectMocks
	CustomerServiceImpl customerService;
	@Mock
	CustomerRepo custRepo;
	
	@Test
	void saveCustomerTest() {
				
		when(custRepo.findByUsername(Mockito.any()))
		.thenReturn(Collections.emptyList());
		when(custRepo.findByEmail(Mockito.any()))
		.thenReturn(Collections.emptyList());
		
		Customer customer = new Customer();
		customer.setAccType("SavingsAccount");
		customer.setAccountId(10L);
		
		when(custRepo.save(Mockito.any()))
		.thenReturn(customer);
		
		Long actual= customerService.saveCustomer(customer);
		assertEquals(10L,actual);
		//custRepo.findByEmail(customer.getEmail()).isEmpty() 
	}
	
}
