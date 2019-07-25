package com.ha.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.token.AccessTokenProvider;
import org.springframework.security.oauth2.client.token.AccessTokenProviderChain;
import org.springframework.stereotype.Service;

import com.ha.entity.UserModel;
import com.ha.repository.UserRepository;

@Service
public class AuthUserDetailService implements UserDetailsService {
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel u = repository.findById((long) 1)
				.orElseThrow(()->new UsernameNotFoundException(username));
		return new UserDetailsDecorator(u);
	}
}
