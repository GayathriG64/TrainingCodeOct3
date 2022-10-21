package com.swag.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/api")
public class DummyController {
	
	@GetMapping
	public String hello() {
		return "Hello";
	}
	
	@PostMapping("/add")
	public String addData(@RequestBody final String hello) {
		return hello;
	}
	
	@PutMapping("/edit")
	public String editData(@RequestBody final String hello) {
		return hello;
	}
}
