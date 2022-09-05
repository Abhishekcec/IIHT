package com.iiht.user.login.service;

public interface LoginService {
	public String verifyUserLogin(String email, String password); 
	public String logout(String email);

}
