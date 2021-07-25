package com.rakib.jawed.springngblog.service;

import com.rakib.jawed.springngblog.dto.LoginRequest;
import com.rakib.jawed.springngblog.dto.RegisterRequest;

public interface AuthService {

	public void signup(RegisterRequest request);

	public String login(LoginRequest request);
}
