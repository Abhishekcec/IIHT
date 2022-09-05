package com.estockmarket.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estockmarket.authentication.model.AuthRequest;
import com.estockmarket.authentication.model.User;
import com.estockmarket.authentication.service.UserService;
import com.estockmarket.authentication.util.JwtUtil;
import com.estockmarket.authentication.model.AuthRequest;
import com.estockmarket.authentication.model.LoginDTO;


@CrossOrigin
@RestController
@RequestMapping("/api/v1.0/market/user")
public class UserController {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@PostMapping(value = "/register")
	public String registerUser(@RequestBody User user) {
		return userService.registerUser(user);

	}
	
	@PostMapping("/authenticate")
    public LoginDTO generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        String token = jwtUtil.generateToken(authRequest.getUserName());
        return new LoginDTO("Successfully logged in", token);
//        return jwtUtil.generateToken(authRequest.getUserName());
    }

}
