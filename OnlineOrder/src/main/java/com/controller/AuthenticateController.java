package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rabbitmq/api/auth/")
public class AuthenticateController {

	@GetMapping(value="/test")
	public String Test() {
		return "Authenticate user";
	}
}
