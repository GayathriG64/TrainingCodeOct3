package com.digitalbooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.digitalbooks.service.IUserService;

@RestController
@RequestMapping("/reader")
public class ReaderController {
	@Autowired
	IUserService userService;
	
	@Autowired
	RestTemplate restTemplate;
	
//	@PostMapping("/register")
//	public Long()
}
