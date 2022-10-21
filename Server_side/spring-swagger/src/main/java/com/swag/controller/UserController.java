package com.swag.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swag.entity.User;

@RestController
@RequestMapping("/user/api")
public class UserController {
	
	@GetMapping("/list")
	public List<User> getUsers(){
		return Arrays.asList(new User("David",1000L),new User("John", 5000L));
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") final String username) {
		return new  User(username,1000L);
	}
	
}
