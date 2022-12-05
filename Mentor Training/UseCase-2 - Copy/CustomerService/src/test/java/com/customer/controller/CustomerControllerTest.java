package com.customer.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import com.customer.entity.Customer;
import com.customer.entity.Transaction;
import com.customer.model.LoginRequest;
import com.customer.model.UpdateRequest;
import com.customer.service.CustomerService;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
	
	@InjectMocks
	CustomerController customerController;
	
	@Mock
	RestTemplate restTemplate;
	
	@Mock
	CustomerService customerService;
	
	@Test
	void registerCustomer() {
		when(customerService.saveCustomer(Mockito.any()))
		.thenReturn(1L);
		Customer customer = new Customer();
		Long actual = customerController.registerCustomer(customer);
		assertEquals(1L, actual);
	}
	@Test
	void loginCustomer() {
		when(customerService.validateLoginRequest(Mockito.any()))
		.thenReturn(null);
		LoginRequest request = new LoginRequest("abc","abc");
		Customer actual = customerController.loginCustomer(request);
		assertEquals(null, actual);
	}
	
	 @Test
	 void updateAccountTest() {
		 when(customerService.updateCustomerRequest(Mockito.any(), Mockito.any()))
		 .thenReturn("abc");
		 UpdateRequest request = new UpdateRequest();
		 String actual = customerController.updateCustomer(request, "");
		 assertNotNull(actual);
	 }
	 
}
