package com.coderscampus.javascriptpractice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.coderscampus.javascriptpractice.domain.User;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String getUser(ModelMap model) {
		User user = new User();
		model.put("user", user);
		return "login";
	}

}
