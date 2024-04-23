package com.personalfinancetrackor.personalfinancetrackor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalfinancetrackor.personalfinancetrackor.repository.EmailVerificationRepository;

@Service
public class UserDetailsService
		implements com.personalfinancetrackor.personalfinancetrackor.service.UserDetailsService {
	@Autowired
	EmailVerificationRepository emailVerificationRepository;

	@Override
	public String emailVerification(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String checkUser(String email, String pin) {
		// TODO Auto-generated method stub
		return null;
	}
}
