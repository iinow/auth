package com.ha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ha.entity.client.ClientScopeModel;

public interface ClientScopeRepository extends JpaRepository<ClientScopeModel, Long>{

}
