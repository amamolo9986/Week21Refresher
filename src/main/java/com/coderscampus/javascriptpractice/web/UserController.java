package com.coderscampus.javascriptpractice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.javascriptpractice.domain.User;
import com.coderscampus.javascriptpractice.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/validation")
	public boolean getExists(String username, String password) {
		System.out.println("Username = " + username + ", Password = " + password);
		return true;
	}

	@PostMapping("/validation")
	public Boolean postValidated(@RequestBody User user) {
		user = userService.checkIfUserExists(user.getUsername());
			
		return (user != null);
	}

}
