package com.rakib.jawed.springngblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakib.jawed.springngblog.dto.RegisterRequest;
import com.rakib.jawed.springngblog.model.User;
import com.rakib.jawed.springngblog.repository.UserRepository;
import com.rakib.jawed.springngblog.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
    private UserRepository userRepository;
	
	@Override
	public void signup(RegisterRequest request) {
		User user = new User();
		user.setUserName(request.getUsername());
		user.setPassword(request.getPassword());
		user.setEmail(request.getEmail());
		userRepository.save(user);
	}

	
}
