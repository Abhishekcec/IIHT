package com.iiht.user.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.user.login.model.RegisterUser;
import com.iiht.user.login.model.User;
import com.iiht.user.login.service.impl.LoginServiceImpl;
import com.iiht.user.login.service.impl.RegistrationServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/api/v1.0/market/user")
public class LoginController {
	
	@Autowired
	private LoginServiceImpl loginServiceImpl;
	
	@Autowired
	private RegistrationServiceImpl registrationServiceImpl;
	
	@RequestMapping("/register")
    public String addUser(@RequestBody RegisterUser registerUser) {
		return registrationServiceImpl.registerNewUser(registerUser);
	}
	
	@RequestMapping("/login")
	public String addUser(@RequestBody User user) {
		return loginServiceImpl.verifyUserLogin(user.getEmail(), user.getPassword());
	}
	
	@PostMapping("/logout/{email}")
	public String logout(@PathVariable String  email) {
		return loginServiceImpl.logout(email);

	}
	

}
