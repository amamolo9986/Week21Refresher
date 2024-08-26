package com.coderscampus.javascriptpractice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.javascriptpractice.domain.User;

@Controller
@RequestMapping("users")
public class UserController {

	@PostMapping("/validation")
	@ResponseBody
	public Boolean postValidated(@RequestBody User user) {
		System.out.println("Username = " + user.getUsername() + ", Password = " + user.getPassword());
		return true;
	}
	
	@GetMapping("/register")
	public String getRegistration(ModelMap model) {
		User user = new User();
		model.put("user", user);
		return "register";
	}
	
	//@PostMapping("/register")
	

}
