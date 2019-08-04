package com.ha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ha.entity.client.ClientGrantTypeModel;
import com.ha.repository.ClientGrantTypeRepository;

@Service
public class ClientGrantTypeService {

	@Autowired
	private ClientGrantTypeRepository repository;
	
//	@Cacheable(value = "clientgranttype", key = "#model.granttype")
	public ClientGrantTypeModel add(ClientGrantTypeModel model) {
		return repository.save(model);
	}
}
