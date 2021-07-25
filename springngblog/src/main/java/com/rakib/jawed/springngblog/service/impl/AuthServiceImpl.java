package com.rakib.jawed.springngblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rakib.jawed.springngblog.dto.LoginRequest;
import com.rakib.jawed.springngblog.dto.RegisterRequest;
import com.rakib.jawed.springngblog.model.User;
import com.rakib.jawed.springngblog.repository.UserRepository;
import com.rakib.jawed.springngblog.security.JwtProvider;
import com.rakib.jawed.springngblog.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
    private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtProvider jwtProvider;
	
	
	@Override
	public void signup(RegisterRequest request) {
		User user = new User();
		user.setUserName(request.getUsername());
		user.setPassword(encodePassword(request.getPassword()));
		user.setEmail(request.getEmail());
		userRepository.save(user);
	}


	private String encodePassword(String password) {
		return passwordEncoder.encode(password);
	}


	@Override
	public String login(LoginRequest request) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return jwtProvider.generateToken(authentication);
	}

	
	
}
