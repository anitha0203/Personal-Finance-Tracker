package com.personalfinancetrackor.personalfinancetrackor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personalfinancetrackor.personalfinancetrackor.service.UserDetailsService;

@ControllerAdvice
@RestController
@RequestMapping("v1/pft")
public class UserDetailsController {
	@Autowired
	UserDetailsService userDetailsService;

	@CrossOrigin
	@PostMapping(value = "/emailVerification")
	public String emailVerification(@RequestParam String email) throws Throwable {
		return userDetailsService.emailVerification(email);
	}

	@CrossOrigin
	@PostMapping(value = "/phoneNumberVerification")
	public String phoneNumberVerification(@RequestParam String phoneNumber) throws Throwable {
		return userDetailsService.phoneNumberVerification(phoneNumber);
	}

}
