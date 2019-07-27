package com.ha.service;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ha.entity.UserModel;
import com.ha.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public Long addUserModel(UserModel user) {
		return repository.save(user).getId();
	}
	
	public UserModel findOneUserModel(Long id) {
		return repository.findById(id).get();
	}
	
	@Transactional
	public UserModel findOneUserModel(String name) {
		UserModel user = repository.findByName(name);
		Hibernate.initialize(user);
		return user;
	}
}
