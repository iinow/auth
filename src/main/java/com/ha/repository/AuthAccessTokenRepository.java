package com.ha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ha.entity.token.AuthAccessToken;

public interface AuthAccessTokenRepository extends JpaRepository<AuthAccessToken, Long> {
	AuthAccessToken findOneByToken(String token);
	void deleteByToken(String token); 
	List<AuthAccessToken> findByClient_Clientid(String clientId);
}
