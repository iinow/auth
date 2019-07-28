package com.ha.entity.token;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import com.ha.entity.UserModel;
import com.ha.entity.client.ClientModel;
import com.ha.util.SerializableObjectConverter;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "auth_access_token")
//@MappedSuperclass
public class AuthAccessToken implements Serializable, OAuth2AccessToken {
	private static final long serialVersionUID = -7814117106812701359L;

	public AuthAccessToken() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private UserModel user;
	
	@ManyToOne
	@JoinColumn(name = "clientId")
	private ClientModel client;
	
	@ManyToOne
	@JoinColumn(name = "refreshTokenId")
	private AuthRefreshToken authRefreshToken;
	
	@OneToMany(mappedBy = "token")
	private List<AuthAccessTokenScopeModel> authAccessTokenScopes = new ArrayList<>(); 
	
	@Lob
	@Column(length = 100000)
	private String authentication;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiration;
	                            
	private String token;
	
	private String tokenType;
	
	private int expiresIn;
	
	@Override
	public Map<String, Object> getAdditionalInformation() {
		return null;
	}

	@Override
	public Set<String> getScope() {
		return getAuthAccessTokenScopes()
				.stream()
				.map(AuthAccessTokenScopeModel::getScope)
				.collect(Collectors.toSet());
	}

	@Override
	public AuthRefreshToken getRefreshToken() {
		return getAuthRefreshToken();
	}

	@Override
	public String getTokenType() {
		return this.tokenType;
	}

	@Override
	public boolean isExpired() {
		return expiration != null && expiration.before(new Date());
	}

	@Override
	public Date getExpiration() {
		return this.expiration;
	}

	@Override
	public int getExpiresIn() {
		return this.expiresIn;
	}

	@Override
	public String getValue() {
		return getToken();
	}
	
	public void setAuthentication(OAuth2Authentication authentication) {
        this.authentication = SerializableObjectConverter.serialize(authentication);
    }
	
	public OAuth2Authentication getAuthentication() {
		return SerializableObjectConverter.deserialize(this.authentication);
	}
}