package com.ha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ha.entity.client.ClientGrantTypeModel;

public interface ClientGrantTypeRepository extends JpaRepository<ClientGrantTypeModel, Long>{

}
