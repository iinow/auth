package com.ha.auth;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.DefaultAuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;

import com.ha.entity.UserModel;
import com.ha.entity.client.ClientModel;
import com.ha.entity.token.AuthAccessToken;
import com.ha.entity.token.AuthAccessTokenScopeModel;
import com.ha.entity.token.AuthRefreshToken;
import com.ha.service.AuthAccessTokenScopeService;
import com.ha.service.AuthAccessTokenService;
import com.ha.service.AuthRefreshTokenService;
import com.ha.service.ClientService;
import com.ha.service.UserService;

/**
 * {@link https://cheese10yun.github.io/spring-oauth2-jdbc/}
 * TokenStore 인터페이스는 Access Token, Refresh Token과 관련된 인증 데이터를 저장, 검색, 제거, 읽기에 대한 정의입니다.
 * */
@Service
public class AuthTokenStore implements TokenStore {

	private AuthenticationKeyGenerator authenticationKeyGenerator = new DefaultAuthenticationKeyGenerator();
	
	@Autowired
	private AuthAccessTokenService authAccessTokenService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private AuthAccessTokenScopeService authAccessTokenScopeService;
	
	@Autowired
	private AuthRefreshTokenService authRefreshTokenService;
	
	private Map<String, AuthAccessToken> map = new HashMap<>();
	
	@Override
	public OAuth2Authentication readAuthentication(OAuth2AccessToken token) {
		return readAuthentication(token.getValue());
	}

	@Override
	public OAuth2Authentication readAuthentication(String token) {
		if(map.get(token) == null) {
			AuthAccessToken accessToken = authAccessTokenService.getToken(token);
			map.put(token, accessToken);
		}
		return Optional.ofNullable(map.get(token))
			.map(AuthAccessToken::getAuthentication)
			.orElse(null);
	}

	@Override
	public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) { 
		//jwt 로 인코딩 갈까/...
		AuthRefreshToken refresh = null;
        if (token.getRefreshToken() != null) {
        	refresh = new AuthRefreshToken();
            refresh.setRefreshToken(token.getRefreshToken().getValue());
            authRefreshTokenService.addAuthRefreshToken(refresh);
        }

        if (readAccessToken(token.getValue()) != null) {
            this.removeAccessToken(token);
        }
//        authentication.getOAuth2Request().getRequestParameters().get("username");
        authentication.getUserAuthentication();
        UserModel user = userService.findOneUserModel(authentication.getName());	//-> authentication.getName() 이 ..clientId  로 오는데???
        ClientModel client = clientService.findByClientId(authentication.getOAuth2Request().getClientId());
        
        AuthAccessToken accessToken = new AuthAccessToken();
        accessToken.setToken(token.getValue());
        accessToken.setExpiration(token.getExpiration());
        accessToken.setExpiresIn(token.getExpiresIn());
        accessToken.setTokenType(token.getTokenType());
        accessToken.setUser(authentication.isClientOnly() ? null : user);
        accessToken.setClient(client);
        accessToken.setAuthentication(authentication);
        accessToken.setAuthRefreshToken(refresh);
        
        authAccessTokenService.addAuthAccessToken(accessToken);
        
        Iterator<String> scopeIter = token.getScope().iterator();
        while(scopeIter.hasNext()) {
        	AuthAccessTokenScopeModel scope = new AuthAccessTokenScopeModel();
        	scope.setScope(scopeIter.next());
        	scope.setToken(accessToken);
        	authAccessTokenScopeService.addAuthAccessTokenScopeModel(scope);
        }
	}

	@Override
	public AuthAccessToken readAccessToken(String tokenValue) {
		if(map.get(tokenValue) == null) {
			AuthAccessToken authToken = authAccessTokenService.getToken(tokenValue);
			map.put(tokenValue, authToken);
		}
		return map.get(tokenValue);
	}

	@Override
	public void removeAccessToken(OAuth2AccessToken token) {
		authAccessTokenService.removeToken(token.getValue());
	}

	@Override
	public void storeRefreshToken(OAuth2RefreshToken refreshToken, OAuth2Authentication authentication) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OAuth2RefreshToken readRefreshToken(String tokenValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OAuth2Authentication readAuthenticationForRefreshToken(OAuth2RefreshToken token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeRefreshToken(OAuth2RefreshToken token) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAccessTokenUsingRefreshToken(OAuth2RefreshToken refreshToken) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<OAuth2AccessToken> findTokensByClientIdAndUserName(String clientId, String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<OAuth2AccessToken> findTokensByClientId(String clientId) {
		// TODO Auto-generated method stub
		return null;
	}
}
