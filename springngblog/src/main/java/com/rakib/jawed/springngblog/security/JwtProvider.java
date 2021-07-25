package com.rakib.jawed.springngblog.security;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtProvider {
	
	private SecretKey key;
	
	@PostConstruct
	public void init() {
		key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	}

	public String generateToken(Authentication authentication) {
		User user = (User) authentication.getPrincipal();
		return Jwts.builder()
				.setSubject(user.getUsername())
				.signWith(key)
				.compact();
	}

	
}
