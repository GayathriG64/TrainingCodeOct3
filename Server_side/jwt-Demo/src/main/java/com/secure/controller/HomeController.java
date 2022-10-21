package com.secure.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/hello")
	public String home(Principal principal) {
		return "Hello! Welcome "+ principal.getName();
	}
}
