package com.ha.auth;

import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.stereotype.Service;

@Service
public class AuthCodeService implements AuthorizationCodeServices {

	@Override
	public String createAuthorizationCode(OAuth2Authentication authentication) {
		authentication.getOAuth2Request();
		return null;
	}

	@Override
	public OAuth2Authentication consumeAuthorizationCode(String code) throws InvalidGrantException {
		return null;
	}
}
