package com.paparadaminteractive.artic.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
		http
		.authorizeRequests()
		.antMatchers("/public/**","/resources/**")
		.permitAll()
		.and().csrf().disable();
		
		//http.addFilterAfter(new CheckStatus(authenticationManager()), BasicAuthenticationFilter.class);
		// @formatter:on
    }

}
