package com.ha.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ha.entity.token.AuthAccessTokenScopeModel;
import com.ha.repository.AuthAccessTokenScopeRepository;

@Service
public class AuthAccessTokenScopeService {

	@Autowired
	private AuthAccessTokenScopeRepository repository;
	
	@Transactional
	public Long addAuthAccessTokenScopeModel(AuthAccessTokenScopeModel model) {
		return repository.save(model).getId();
	}
}
