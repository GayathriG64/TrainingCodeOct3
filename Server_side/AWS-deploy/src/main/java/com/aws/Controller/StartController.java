package com.aws.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController {
	@GetMapping("/hello")
	public String getHello()
	{
		return "Hello!! This is Gayathri.";
	}
}
