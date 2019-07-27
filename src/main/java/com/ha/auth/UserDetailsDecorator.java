package com.ha.auth;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ha.entity.UserModel;

public class UserDetailsDecorator implements UserDetails {
	private static final long serialVersionUID = 1857136326492838320L;

	private UserModel user;
	
//	@PersistenceContext
	
	public UserDetailsDecorator(@NotNull(message = "must not be null de!") UserModel user) {
//		Hibernate.initialize(user);
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Optional.ofNullable(user.getGrants())
			.orElseGet(() -> Collections.emptyList())
			.stream()
			.map(grant -> grant.getGrantType())
			.map(grant -> (GrantedAuthority) () -> grant)
			.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
