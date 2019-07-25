package com.ha.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 
 * @author BISHOP
 * /oauth/authorize ��û�� ó���Ϸ���
 * ����� ���� ���� DB ���� ��ȸ�ؾ��Ѵ�.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		super.configure(auth);
//		auth.jdbcAuthentication();
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select username, password from users where username=?")
			.authoritiesByUsernameQuery("select username, authority from users where username=?")
			.and();
//			.usersByUsernameQuery();
//		auth.inMemoryAuthentication()
//	        .withUser("user")
//	        .password("{noop}password")
//	        .roles("USER")
//	        .and()
//	        .withUser("admin")
//	        .password("{noop}password")
//	        .roles("USER", "ADMIN")
//	        .and();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		super.configure(http);
	}
}