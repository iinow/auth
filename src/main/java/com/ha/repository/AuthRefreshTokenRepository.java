package com.ha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ha.entity.token.AuthRefreshToken;

public interface AuthRefreshTokenRepository extends JpaRepository<AuthRefreshToken, Long> {

}
