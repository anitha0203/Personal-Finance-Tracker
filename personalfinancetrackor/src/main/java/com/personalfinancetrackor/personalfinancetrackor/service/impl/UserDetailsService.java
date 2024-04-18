package com.personalfinancetrackor.personalfinancetrackor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalfinancetrackor.personalfinancetrackor.repository.EmailVerificationRepository;
import com.personalfinancetrackor.personalfinancetrackor.repository.PhoneNumberVerificationRepository;

@Service
public class UserDetailsService
		implements com.personalfinancetrackor.personalfinancetrackor.service.UserDetailsService {
	@Autowired
	EmailVerificationRepository emailVerificationRepository;

	@Autowired
	PhoneNumberVerificationRepository phoneNumberVerificationRepository;

	@Override
	public String emailVerification(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String phoneNumberVerification(String phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
