package com.springsecurityjdbcjdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableWebSecurity
public class SecurtyConfigure extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource datasource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(auth);
	 
	auth.jdbcAuthentication()
    .dataSource(datasource);
//    .withDefaultSchema()
//    .withUser(User.withUsername("user")
//   		       .password("pass")
//   		       .roles("ADMIN")
//   		      );
	
	//you can also write Customise schema rather then schema and user and authority 
	}
	@Bean
	public PasswordEncoder getPasswordEncoder() 
	{
		return NoOpPasswordEncoder.getInstance();
		
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
		    .antMatchers("/admin").hasRole("ROLE_ADMIN")
		    .antMatchers("/user").hasAnyRole("USER","ROLE_ADMIN")
		    .antMatchers("/").permitAll()
		    .and().formLogin();
	}
	

}
