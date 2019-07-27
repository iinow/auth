package com.ha.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class UserModel implements Serializable {
	private static final long serialVersionUID = 1662747140544768957L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username", nullable = false, length = 20)
	private String name;
	
	@Column(name = "password", nullable = false, length = 20)
	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<UserGrantAuthModel> grants = new ArrayList<>();
}
