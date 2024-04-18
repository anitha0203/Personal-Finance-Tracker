package com.personalfinancetrackor.personalfinancetrackor.service;

public interface UserDetailsService {
	
	public String emailVerification(String email);

	public String phoneNumberVerification(String phoneNumber);

}
