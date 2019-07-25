package com.ha.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ha.entity.ClientModel;
import com.ha.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	EntityManagerFactory factory;

	@Autowired
	private ClientRepository repository;
	
	@Transactional
	public ClientModel add(ClientModel model) {
//		EntityManager manager = factory.createEntityManager();
//		manager.persist(model);
		
		repository.save(model);
		return null;
	}
	
	@Transactional
	public void getClientModel(Long id) {
		ClientModel client = repository.findById(id).get();
		String type = client.getGranttypes().get(0).getGranttype();
		System.out.println(type);
		
		String scope = client.getScopes().get(0).getScope();
		System.out.println(scope);
	}
}
