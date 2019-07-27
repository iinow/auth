package com.ha.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.ha.auth.AuthUserDetailService;

/**
 * 
 * @author BISHOP
 * /oauth/authorize 요청을 처리하려면
 * 사용자 계정 정보 DB 에서 조회해야한다.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthUserDetailService authUserDetailService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		super.configure(auth);
//		auth.jdbcAuthentication();
//		auth.jdbcAuthentication()
//			.dataSource(dataSource)
//			.usersByUsernameQuery("select username, password from users where username=?")
//			.authoritiesByUsernameQuery("select username, authority from users where username=?")
//			.and();
//			.usersByUsernameQuery();
		auth.userDetailsService(authUserDetailService);
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
		super.configure(web);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//			.antMatchers("")
//			.hasAnyRole("USER", "ADMIN")
//			.and()
//			.formLogin();
		http.authorizeRequests()
			.antMatchers("/t2/test")
			.authenticated();
	}
}
