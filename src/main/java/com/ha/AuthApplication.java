package com.ha;

import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.websocket.ClientEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ha.entity.ClientGrantTypeModel;
import com.ha.entity.ClientModel;
import com.ha.entity.ClientScopeModel;
import com.ha.entity.UserModel;
import com.ha.repository.ClientGrantTypeRepository;
import com.ha.repository.ClientRepository;
import com.ha.repository.ClientScopeRepository;
import com.ha.repository.UserRepository;
import com.ha.service.ClientService;

@SpringBootApplication
//@EnableResourceServer
@RestController
public class AuthApplication {
	@Autowired
	UserRepository repository;
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	ClientGrantTypeRepository granttypeRepository;
	
	@Autowired
	ClientScopeRepository clientScopeRepository;

	@Autowired
	ClientRepository clientRepository;
	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
//		UserModel user = new UserModel();
//		user.setName("joon");
//		user.setPassword("password");
//		user.setAuthority("ADMIN");
//		repository.save(user);
//		
//		ClientModel client = new ClientModel();
//		client.setClientid("clientid");
//		client.setSecret("secret");
//		clientService.add(client);
//		
//		ClientGrantTypeModel granttype1 = new ClientGrantTypeModel();
//		granttype1.setClient(client);
//		granttype1.setGranttype("password");
//		granttypeRepository.save(granttype1);
//		
//		ClientGrantTypeModel granttype2 = new ClientGrantTypeModel();
//		granttype2.setClient(client);
//		granttype2.setGranttype("authorization_code");
//		granttypeRepository.save(granttype2);
//		
//		client.setGranttypes(Arrays.asList(granttype1, granttype2));
//		
//		ClientScopeModel scope1 = new ClientScopeModel();
//		scope1.setClient(client);
//		scope1.setScope("all");
//		clientScopeRepository.save(scope1);
//	
//		client.setScopes(Arrays.asList(scope1));
//		
//		clientService.add(client);
//		
//		ClientModel client1 = clientRepository.findById((long) 1).get();
//		System.out.println(client1.getGranttypes().get(0).getGranttype());
//		System.out.println(client1.getGranttypes().get(0).getId());
	}
	
	@GetMapping("/t1/test")
	public String home() {
		return "Hello World";
	}
	
	@GetMapping("/t2/test")
	public String home2() {
		return "Hello World";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String create(@RequestBody MultiValueMap<String, String> map) {
		return "OK";
	}

	/*@Configuration
	@EnableAuthorizationServer
	protected static class OAuth2Config extends AuthorizationServerConfigurerAdapter {

		@Autowired
		private AuthenticationConfiguration configure;

		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
			endpoints.authenticationManager(configure.getAuthenticationManager());
		}
		
		@Override
		public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
			security.checkTokenAccess("isAuthenticated()");
		}

		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
			// @formatter:off
//			clients.jdbc(dataSource)
		 	clients.inMemory()
		        .withClient("my-trusted-client")
		            .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
		            .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
		            .scopes("read", "write", "trust")
		            .resourceIds("oauth2-resource")
		            .accessTokenValiditySeconds(600)
		            .redirectUris("https://anywhere")
 		    .and()
		        .withClient("my-client-with-registered-redirect")
		            .authorizedGrantTypes("authorization_code")
		            .authorities("ROLE_CLIENT")
		            .scopes("read", "trust")
		            .resourceIds("oauth2-resource")
		            .redirectUris("https://anywhere?key=value")
 		    .and()
		        .withClient("my-client-with-secret")
		            .authorizedGrantTypes("client_credentials", "password")
		            .authorities("ROLE_CLIENT")
		            .scopes("read")
		            .resourceIds("oauth2-resource")
		            .secret("secret");
		}
	}*/
}
