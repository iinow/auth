package com.ha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ha.entity.client.ClientModel;

public interface ClientRepository extends JpaRepository<ClientModel, Long>{

	ClientModel findOneByClientid(String clientId);
}
