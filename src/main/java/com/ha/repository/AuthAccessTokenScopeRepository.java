package com.ha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ha.entity.token.AuthAccessTokenScopeModel;

public interface AuthAccessTokenScopeRepository extends JpaRepository<AuthAccessTokenScopeModel, Long>{

}
