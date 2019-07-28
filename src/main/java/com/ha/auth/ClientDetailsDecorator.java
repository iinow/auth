package com.ha.auth;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import com.ha.entity.UserModel;
import com.ha.entity.client.ClientModel;

public class ClientDetailsDecorator implements ClientDetails {
	private static final long serialVersionUID = -308715146948531116L;

	private ClientModel client;
	
	public ClientDetailsDecorator(@NotNull(message = "must not be null") ClientModel client) {
		this.client = client;
	}
	
	@Override
	public String getClientId() {
		return this.client.getClientid();
	}

	@Override
	public Set<String> getResourceIds() {
		return null;
	}

	@Override
	public boolean isSecretRequired() {
		return client.getSecret() != null && client.getSecret().isEmpty();
	}

	@Override
	public String getClientSecret() {
		return this.client.getSecret();
	}

	@Override
	public boolean isScoped() {
		return !client.getScopes().isEmpty();
	}

	@Override
	public Set<String> getScope() {
		return client.getScopes()
			.stream()
			.map(scope -> scope.getScope())
			.collect(Collectors.toSet());
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		return client.getGranttypes()
				.stream()
				.map(granttype -> granttype.getGranttype())
				.collect(Collectors.toSet());
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		return null;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return Arrays.asList(
				(GrantedAuthority) ()-> "ROLE_USER",
				(GrantedAuthority) ()-> "ROLE_ADMIN",
				(GrantedAuthority) ()-> "ROLE_ANONYMOUS");
//		return null;
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAutoApprove(String scope) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		// TODO Auto-generated method stub
		return null;
	}

}
