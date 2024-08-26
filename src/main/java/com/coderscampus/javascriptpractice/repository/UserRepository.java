package com.coderscampus.javascriptpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderscampus.javascriptpractice.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
