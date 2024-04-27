package com.personalfinancetrackor.personalfinancetrackor.service;

public interface UserDetailsService {
	
	public String emailVerification(String email);

	public String checkUser(String email, String pin);

	String verifyOtp(String phoneNumber, String otp);
	
}
