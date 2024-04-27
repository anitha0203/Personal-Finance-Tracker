package com.personalfinancetrackor.personalfinancetrackor.service;

import com.personalfinancetrackor.personalfinancetrackor.repository.UserDetails;

public interface UserDetailsService {
	
	public String emailVerification(String email);

	public String checkUser(String email, String pin);

	String verifyOtp(String phoneNumber, String otp);

	String processUserRegistration(UserDetails userDetails);
	
}
