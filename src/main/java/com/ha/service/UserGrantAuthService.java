package com.ha.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ha.entity.UserGrantAuthModel;
import com.ha.entity.UserModel;
import com.ha.repository.UserGrantAuthRepository;

@Service
public class UserGrantAuthService {

	@Autowired
	private UserGrantAuthRepository repository;
	
	@Autowired
	private UserService userService;
	
	@Transactional
//	@Cacheable(value = "usergrantauth", key = "#auth.grantType")
	public Long addUserGrantAuthModel(UserGrantAuthModel auth) {
		return repository.save(auth).getId();
	}
	
	@Transactional
	public Long addUserGrantAuthModel(UserGrantAuthModel auth, String username) {
		UserModel user = userService.findOneUserModel(username);
		auth.setUser(user);
		return repository.save(auth).getId();
	}
}
