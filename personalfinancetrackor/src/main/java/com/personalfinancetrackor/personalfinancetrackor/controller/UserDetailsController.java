package com.personalfinancetrackor.personalfinancetrackor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personalfinancetrackor.personalfinancetrackor.model.User;
import com.personalfinancetrackor.personalfinancetrackor.repository.UserDetails;
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
		System.out.println("email  " + email);
		return userDetailsService.emailVerification(email);
	}
	
	@CrossOrigin
	@PostMapping(value = "/verifyOTP")
	public String verifyOTP(@RequestParam String email, @RequestParam String otp) throws Throwable {
		return userDetailsService.verifyOtp(email, otp);
	}
	
	@CrossOrigin
	@PostMapping(value = "/register")
	public String userRegistration(@RequestBody User userDetails) throws Throwable {
		return userDetailsService.processUserRegistration(userDetails);
	}
	
	@CrossOrigin
	@PostMapping(value="/checkUser")
	public String checkUser(@RequestParam String email, @RequestParam String pin) {
		System.out.println("goinggggg");
		return userDetailsService.checkUser(email, pin);
	}

}
