package com.ha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ha.entity.ClientGrantTypeModel;
import com.ha.repository.ClientGrantTypeRepository;

@Service
public class ClientGrantTypeService {

	@Autowired
	private ClientGrantTypeRepository repository;
	
	public void add(ClientGrantTypeModel model) {
		repository.save(model);
	}
}
