package com.synchrony.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.synchrony.assessment.service.MyUserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class AssessmentConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsServiceImpl userDetailsService;

	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return daoAuthenticationProvider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("image/**").authenticated().and().formLogin().and()
				.logout();
	}
}
