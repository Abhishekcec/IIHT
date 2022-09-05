package com.estockmarket.authentication.model;

public class LoginDTO {

	private String status;
	private String token;
	
	public LoginDTO() {
		super();
	}
	public LoginDTO(String status, String token) {
		super();
		this.status = status;
		this.token = token;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
