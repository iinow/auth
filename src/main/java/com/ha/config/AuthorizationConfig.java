package com.ha.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import com.ha.auth.AuthClientDetailService;

@Configuration
@EnableAuthorizationServer
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

//	@Autowired
//	private ClientDetailsService service;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private AuthClientDetailService authClientDetailService;
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		super.configure(security);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//		clients.jdbc(dataSource);
		clients.withClientDetails(authClientDetailService);
//		clients.inMemory()
//	        .withClient("some_client_id")
//	        .secret("{noop}some_client_secret")
//	        .scopes("read:current_user", "read:users")
//	        .authorizedGrantTypes("client_credentials");
		/**
		 * GrantType 
		 * 1. password
		 * 2. authorization code
		 * 3. client_credentials
		 * 4. resource owner password crendentials
		 * 5. implicit
		 * */
//		clients.withClientDetails(clientDetailsService());
	}

//	@Bean
//	public ClientDetailsService clientDetailsService() throws Exception {
//		return new InMemoryClientDetailsServiceBuilder()
//				.withClient("clientid")
//				.secret("secret")
//				.authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
//				.scopes("all")
//				.accessTokenValiditySeconds(600)
//				.redirectUris("https://anywhere")
//				.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
//				.and().build();
//	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//		endpoints.tokenEnhancer(tokenEnhancer)
//		endpoints.tokenGranter(tokenGranter)
//		endpoints.tokenServices(tokenServices) --token 발급?
//		endpoints.tokenStore(tokenStore) -- token 저장 공간
		super.configure(endpoints);
//		endpoints.getTokenStore();
	}
}
