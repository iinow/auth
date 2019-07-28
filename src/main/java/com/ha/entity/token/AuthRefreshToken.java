package com.ha.entity.token;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "auth_refresh_token")
public class AuthRefreshToken implements Serializable, OAuth2RefreshToken {
	private static final long serialVersionUID = 3544976076097408884L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String refreshToken;
	
	@Override
	public String getValue() {
		return getRefreshToken();
	}
}
