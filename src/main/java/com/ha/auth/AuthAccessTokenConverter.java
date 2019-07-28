package com.ha.auth;

import java.util.Map;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;

//OAuth2AccessToken 상수 값들 정의되어 있다.
public class AuthAccessTokenConverter implements AccessTokenConverter {

	@Override
	public Map<String, ?> convertAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
		//여기서 jwt 바꿀까?
		token.getValue();
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OAuth2AccessToken extractAccessToken(String value, Map<String, ?> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
