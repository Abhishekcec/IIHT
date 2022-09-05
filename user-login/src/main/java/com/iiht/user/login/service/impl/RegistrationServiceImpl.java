package com.iiht.user.login.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.user.login.RegistrationDAO.RegistrationDAO;
import com.iiht.user.login.model.RegisterUser;
import com.iiht.user.login.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	RegistrationDAO registrationDAO;

	@Override
	public String registerNewUser(RegisterUser user) {
		List<String> emails = registrationDAO.findAll().stream().map(RegisterUser::getEmail)
				.collect(Collectors.toList());
		if (emails.contains(user.getEmail())) {
			return "User already exist";
		} else {
			registrationDAO.save(user);
			return "User registered successfully";
		}
	}
}