package com.ha.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import com.ha.entity.ClientModel;
import com.ha.service.ClientService;

@Service
public class AuthClientDetailService implements ClientDetailsService {
	
	private Map<String, ClientDetailsDecorator> map = new HashMap<>();
	
	@Autowired
	private ClientService clientService;
	
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		if(map.get(clientId) == null) {
			ClientModel client = clientService.findByClientId(clientId);
			if(client == null) {
				throw new ClientRegistrationException(clientId);
			}
			map.put(clientId, new ClientDetailsDecorator(client));
		}
		return map.get(clientId);
	}
}
