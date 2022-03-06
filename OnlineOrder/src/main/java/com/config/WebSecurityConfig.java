package com.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	   @Bean  
	    GrantedAuthorityDefaults grantedAuthorityDefaults() { 
	        return new GrantedAuthorityDefaults(""); // Remove the ROLE_ prefix  
	    }  
	   
	   @Autowired
	    private MyBasicAuthenticationEntryPoint authenticationEntryPoint;

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	          .withUser("TEST").password(passwordEncoder().encode("TEST333"))
	          .authorities("ROLE_USER");
	    }


	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	          .antMatchers("/rabbitmq/api/order/**").permitAll()
	          .anyRequest().authenticated()
	          .and()
	          .httpBasic()
	          .authenticationEntryPoint(authenticationEntryPoint).and().
	        cors().and().
	        csrf().disable();
	        
	        http.addFilterAfter(new CustomFilter(),BasicAuthenticationFilter.class);
	    }


}
