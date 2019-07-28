package com.ha.entity.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "clients")
public class ClientModel implements Serializable {
	private static final long serialVersionUID = 9068286159463881978L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "clientId")
	private String clientid;
	
	@Column(name = "secret")
	private String secret;
	
	@OneToMany(mappedBy = "client")
	private List<ClientScopeModel> scopes = new ArrayList<>();
	
	@OneToMany(mappedBy = "client")
	private List<ClientGrantTypeModel> granttypes = new ArrayList<>(); 
}
