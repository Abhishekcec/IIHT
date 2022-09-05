package com.estockmarket.authentication.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.estockmarket.authentication.model.User;

public interface UserService {
	
	String registerUser(User user);

//	UserDetails loadUserByUsername(String email);

}
