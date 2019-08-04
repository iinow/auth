package com.ha.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ha.entity.UserModel;
import com.ha.service.UserService;

@Service
public class AuthUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserService service;

	/**
	 * redis ĳ���� ������Ѵ�.
	 * */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel u = Optional.ofNullable(service.findOneUserModel(username))
				.orElseThrow(() -> new UsernameNotFoundException(username));
		return new UserDetailsDecorator(u);
	}
}
