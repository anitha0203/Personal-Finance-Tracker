package com.personalfinancetrackor.personalfinancetrackor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
	@GetMapping(value = "/Sample")
	public String Sample() throws Throwable {
		return "Working";
	}

	@CrossOrigin
	@PostMapping(value = "/emailVerification")
	public String emailVerification(@RequestParam String email) throws Throwable {
		return userDetailsService.emailVerification(email);
	}
	
	@CrossOrigin
	@PostMapping(value="/checkUser")
	public String checkUser(@RequestParam String email, @RequestParam String pin) {
		return userDetailsService.checkUser(email, pin);
	}

}
