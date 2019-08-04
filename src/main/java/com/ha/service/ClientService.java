package com.ha.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ha.entity.client.ClientModel;
import com.ha.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	EntityManagerFactory factory;

	@Autowired
	private ClientRepository repository;
	
	@Transactional
//	@Cacheable(value = "client", key = "#model.clientid")
	public ClientModel add(ClientModel model) {
//		EntityManager manager = factory.createEntityManager();
//		manager.persist(model);
		return repository.save(model);
	}
	
	@Transactional
//	@CacheEvict(value = "client", key = "#id")
	public void getClientModel(Long id) {
		ClientModel client = repository.findById(id).get();
		String type = client.getGranttypes().get(0).getGranttype();
		System.out.println(type);
		
		String scope = client.getScopes().get(0).getScope();
		System.out.println(scope);
	}
	
	@Transactional
//	@Cacheable(value = "client", key = "#clientId")
	public ClientModel findByClientId(String clientId) {
		ClientModel client = repository.findOneByClientid(clientId);
		client.getGranttypes().get(0);
		client.getScopes().get(0);
//		Hibernate.initialize(client);
		return client;
	}
}
