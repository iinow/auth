package com.ha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ha.entity.UserGrantAuthModel;

public interface UserGrantAuthRepository extends JpaRepository<UserGrantAuthModel, Long>{

}
