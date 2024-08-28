package com.coderscampus.javascriptpractice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.javascriptpractice.domain.User;
import com.coderscampus.javascriptpractice.service.UserService;

@Controller
@RequestMapping("users")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/validation")
	@ResponseBody
	public Boolean postValidated(@RequestBody User user) {
		user = userService.usernameCheck(user.getUsername());
		return (user != null);
	}
	
	@GetMapping("/register")
	public String getRegistration(ModelMap model) {
		User user = new User();
		model.put("user", user);
		return "register";
	}
	
	@PostMapping("/register")
	public String postRegister(User user) {
		userService.saveUser(user);
		return "redirect:/login";
	}
	

}
