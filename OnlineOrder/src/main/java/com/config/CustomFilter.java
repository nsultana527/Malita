package com.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.filter.GenericFilterBean;

 

 

public class CustomFilter extends GenericFilterBean {
	 private static final Logger log = LogManager.getLogger(CustomFilter.class);
    @Override
    public void doFilter(
      ServletRequest request, 
      ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    	log.info("Inside CustomFilter--" );
        chain.doFilter(request, response);
    }

}
