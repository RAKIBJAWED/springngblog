package com.rakib.jawed.springngblog.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rakib.jawed.springngblog.model.User;
import com.rakib.jawed.springngblog.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username).orElseThrow(()->
			new UsernameNotFoundException("User "+username+" not found!!"));
		return new org.springframework.security.core.userdetails.User(
				user.getUserName(), user.getPassword(), true, true, true, true, 
				getAuthorities("ROLE_USER")
				);
	}
	private Collection<? extends GrantedAuthority> getAuthorities(String role_user) {
		return Collections.singletonList(new SimpleGrantedAuthority(role_user));
	}

}
