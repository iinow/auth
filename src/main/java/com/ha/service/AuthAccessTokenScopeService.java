package com.ha.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ha.entity.token.AuthAccessTokenScopeModel;
import com.ha.repository.AuthAccessTokenScopeRepository;

@Service
public class AuthAccessTokenScopeService {

	@Autowired
	private AuthAccessTokenScopeRepository repository;
	
	@Transactional
//	@Cacheable(value = "accesstokenscope", key = "#model.scope")
	public Long addAuthAccessTokenScopeModel(AuthAccessTokenScopeModel model) {
		return repository.save(model).getId();
	}
}
