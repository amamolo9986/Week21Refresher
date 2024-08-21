package com.coderscampus.javascriptpractice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
	
	@GetMapping("/validation")
	public boolean getExists(String username, String password) {
		System.out.println("Username = " + username + ", Password = " + password);
		return true;
	}

}
