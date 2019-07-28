package com.ha.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ha.entity.token.AuthAccessToken;
import com.ha.repository.AuthAccessTokenRepository;

@Service
public class AuthAccessTokenService {

	@Autowired
	private AuthAccessTokenRepository repository;
	
	@Transactional
	public AuthAccessToken getToken(String token) {
		return repository.findOneByToken(token);
	}
	
	@Transactional
	public void removeToken(String token) {
		repository.deleteByToken(token);
	}
	
	@Transactional
	public Long addAuthAccessToken(AuthAccessToken model) {
		return repository.save(model).getId();
	}
}
