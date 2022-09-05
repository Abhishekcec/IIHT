package com.estockmarket.authentication.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.estockmarket.authentication.model.User;
import com.estockmarket.authentication.repository.UserRepository;
import com.estockmarket.authentication.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public String registerUser(User user) {
		List<String> users = userRepository.findAll().stream().map(User::getEmail).collect(Collectors.toList());
		if(users.contains(user.getEmail()))
		{
			return "User Already exists";
		}
		else {
			if(userRepository.save(user)!=null) {
				return "User Registered Successfully";
			}
			else {
				return "Something went wrong";
			}
		}
		
	}
	
//	@Override
//    public UserDetails loadUserByUsername(String email){
//        User user = userRepository.findByEmail(email);
//        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
//    }

}
