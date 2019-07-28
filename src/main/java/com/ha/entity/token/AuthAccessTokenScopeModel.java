package com.ha.entity.token;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ha.entity.UserModel;
import com.ha.entity.client.ClientModel;

import lombok.Data;

@Data
@Entity
@Table(name = "auth_access_token_scope")
public class AuthAccessTokenScopeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String scope;
	
	@ManyToOne
	@JoinColumn(name = "auth_access_token_id")
	private AuthAccessToken token;
}
