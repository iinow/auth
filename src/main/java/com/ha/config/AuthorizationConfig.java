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
 * 2. authorization code (���� �ο� �ڵ� ���� Ÿ��)
 * 	-> ����� ��, ��й�ȣ�� ���� ������ ��û�ؼ� �޴� �ڵ� 
 * 	data = client_id, redirect_url, response_type=code ��û
 * 
 * 3. client_credentials (Ŭ���̾�Ʈ �ڰ� ���� Ÿ��)
 * 	-> Ŭ���̾�Ʈ�� ���ؽ�Ʈ �ܺο��� �׼��� ��ū�� ��� Ư�� ���ҽ��� ������ ��û�� �� ���
 * 
 * 4. resource owner password crendentials (���ҽ� ������ ��ȣ �ڰ� ���� Ÿ��)
 * 	-> Ŭ���̾�Ʈ�� ��ȣ�� ����Ͽ� ������ ��ū�� ���� ������� �ڰ� ������ ��ȯ ???
 * 
 * 5. implicit (�Ͻ��� ����)
 * 	-> ���� �ڵ� ��ȯ �ܰ� ���� ������ ��ū�� ��� ��ȯ�޾Ƽ� ����ϴ� ���
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
     * @param OAuth2 ���� ���� ��ü�� ���� ������ �����ϴ� �κ�
     */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//		security.checkTokenAccess("isAuthenticated()");
//		security.checkTokenAccess("permitAll()");
		//permitAll(), isAuthenticated() ���� https://stackoverflow.com/questions/26750999/spring-security-oauth2-check-token-endpoint
		//https://stackoverflow.com/questions/26250522/how-to-use-remotetokenservice ����
		security.tokenKeyAccess("permitAll()")
        	.checkTokenAccess("isAuthenticated()");
//		TODO: ������ ���� ��ū ��ȿ�� �˻� �غ�����
//		RemoteTokenServices remoteService = new RemoteTokenServices();
//		remoteService.
		//oauth ������ resource ������ �и� �Ǿ��� �� security.oauth2.resource
		super.configure(security);
	}

	/**
     *  @param client = Client �� ���� ������ �����ϴ� �κ� 
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
     * @param OAuth2 ������ �۵��ϱ� ���� Endpoint �� ���� ���� ����
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
//		endpoints.tokenServices(tokenServices) --token �߱�?
//		endpoints.tokenStore(tokenStore) -- token ���� ����
//		super.configure(endpoints);
//		endpoints.getTokenStore();
		
		endpoints.tokenStore(tokenStore);
	}
	
//	@Bean
//	public JdbcTokenStore jdbcTokenStore() {
//		return new JdbcTokenStore(dataSource);
//	}
}
