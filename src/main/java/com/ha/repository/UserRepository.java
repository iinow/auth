package com.ha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ha.entity.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{

	public UserModel findByName(String name);
}
