package com.coderscampus.javascriptpractice.service;

import org.springframework.stereotype.Service;

import com.coderscampus.javascriptpractice.domain.User;
import com.coderscampus.javascriptpractice.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepo;

	public UserService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	public User saveUser(User user) {
		return userRepo.save(user);
		
	}
	

}
