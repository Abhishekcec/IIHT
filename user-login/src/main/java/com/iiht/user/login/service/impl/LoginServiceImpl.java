package com.iiht.user.login.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.user.login.RegistrationDAO.RegistrationDAO;
import com.iiht.user.login.model.RegisterUser;
import com.iiht.user.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	RegistrationDAO registrationDAO;

	@Override
	public String verifyUserLogin(String email, String password) {
		List<String> emails = registrationDAO.findAll().stream().map(RegisterUser::getEmail)
				.collect(Collectors.toList());

		if (emails.contains(email)) {
			RegisterUser user = getUserByEmail(email);
			if (user.getPassword().equals(password)) {
				// handle if user already logged in either logout from previous device or not allow to login
				user.setStatus(true);
				registrationDAO.save(user);
				return "Successfully logged in";
			} else {
				return "Password mismatch";
			}
		} else {
			return "No such user";
		}
	}

	public RegisterUser getUserByEmail(String email) {
		return  registrationDAO.findByEmail(email);
	}

	@Override
	public String logout(String email) {
		RegisterUser user =getUserByEmail(email);
		user.setStatus(false);
		registrationDAO.save(user);
		return "Logged out  successfully";
	}

}