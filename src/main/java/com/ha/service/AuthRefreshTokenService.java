package com.ha.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ha.entity.token.AuthRefreshToken;
import com.ha.repository.AuthRefreshTokenRepository;

@Service
public class AuthRefreshTokenService {

	@Autowired
	private AuthRefreshTokenRepository repository;
	
	@Transactional
	public Long addAuthRefreshToken(AuthRefreshToken model) {
		return repository.save(model).getId();
	}
}
