package com.ha.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.ha.auth.AuthClientDetailService;
import com.ha.auth.AuthTokenApprovalStore;
import com.ha.auth.AuthTokenStore;

/**
 * @link https://cheese10yun.github.io/oauth2/
 * GrantType 
 * 1. password
 * 
 * 2. authorization code (권한 부여 코드 승인 타입)
 * 	-> 사용자 명, 비밀번호를 권한 서버에 요청해서 받는 코드 
 * 	data = client_id, redirect_url, response_type=code 요청
 * 
 * 3. client_credentials (클라이언트 자격 증명 타입)
 * 	-> 클라이언트가 컨텍스트 외부에서 액세스 토큰을 얻어 특정 리소스에 접근을 요청할 때 사용
 * 
 * 4. resource owner password crendentials (리소스 소유자 암호 자격 증명 타입)
 * 	-> 클라이언트가 암호를 사용하여 엑세스 토큰에 대한 사용자의 자격 증명을 교환 ???
 * 
 * 5. implicit (암시적 승인)
 * 	-> 권한 코드 교환 단계 없이 엑세스 토큰을 즉시 반환받아서 사용하는 방식
 * 
 * refresh token
 * */
@Configuration
@EnableAuthorizationServer
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private AuthClientDetailService authClientDetailService;
	
//	@Autowired
//	private AuthTokenStore tokenStore;
	
	@Autowired
	private AuthTokenApprovalStore authTokenApprovalStore;
	
//	@Autowired
//	private JdbcTokenStore jdbcTokenStore;
	
	@Autowired
	private AuthTokenStore tokenStore;
	
	/**
     * @param OAuth2 인증 서버 자체의 보안 정보를 설정하는 부분
     */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//		security.checkTokenAccess("isAuthenticated()");
//		security.checkTokenAccess("permitAll()");
		//permitAll(), isAuthenticated() 차이 https://stackoverflow.com/questions/26750999/spring-security-oauth2-check-token-endpoint
		//https://stackoverflow.com/questions/26250522/how-to-use-remotetokenservice 참조
		security.tokenKeyAccess("permitAll()")
        	.checkTokenAccess("isAuthenticated()");
//		TODO: 원격지 서버 토큰 유효성 검사 해봐야함
//		RemoteTokenServices remoteService = new RemoteTokenServices();
//		remoteService.
		//oauth 서버와 resource 서버가 분리 되었을 때 security.oauth2.resource
		super.configure(security);
	}

	/**
     *  @param client = Client 에 대한 정보를 설정하는 부분 
     */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.withClientDetails(authClientDetailService);
//		clients.inMemory()
//	        .withClient("some_client_id")
//	        .secret("{noop}some_client_secret")
//	        .scopes("read:current_user", "read:users")
//	        .authorizedGrantTypes("client_credentials");
		
//		clients.withClientDetails(clientDetailsService());
	}

	/**
     * @param OAuth2 서버가 작동하기 위한 Endpoint 에 대한 정보 설정
     */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//		endpoints
//			.tokenStore(this.tokenStore)
//			.approvalStore(this.authTokenApprovalStore);
		
//			.accessTokenConverter(accessTokenConverter) AccessTokenConverter
//		endpoints.userDetailsService(authClientDetailService);
//		endpoints.tokenEnhancer(tokenEnhancer)
//		endpoints.tokenGranter(tokenGranter)
//		endpoints.tokenServices(tokenServices) --token 발급?
//		endpoints.tokenStore(tokenStore) -- token 저장 공간
//		super.configure(endpoints);
//		endpoints.getTokenStore();
		
		endpoints.tokenStore(tokenStore);
	}
	
//	@Bean
//	public JdbcTokenStore jdbcTokenStore() {
//		return new JdbcTokenStore(dataSource);
//	}
}
