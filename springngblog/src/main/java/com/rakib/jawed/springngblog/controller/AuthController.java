package com.rakib.jawed.springngblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rakib.jawed.springngblog.dto.LoginRequest;
import com.rakib.jawed.springngblog.dto.RegisterRequest;
import com.rakib.jawed.springngblog.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<String> signUp(@RequestBody RegisterRequest request) {
		authService.signup(request);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest request) {
		return authService.login(request);
	}
}
