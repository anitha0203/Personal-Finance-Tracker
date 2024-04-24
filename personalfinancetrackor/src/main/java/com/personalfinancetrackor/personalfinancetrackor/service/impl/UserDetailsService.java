package com.personalfinancetrackor.personalfinancetrackor.service.impl;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalfinancetrackor.personalfinancetrackor.repository.EmailVerification;
import com.personalfinancetrackor.personalfinancetrackor.repository.EmailVerificationRepository;
import com.personalfinancetrackor.personalfinancetrackor.repository.UserDetails;
import com.personalfinancetrackor.personalfinancetrackor.repository.UserDetailsRepository;
import com.personalfinancetrackor.personalfinancetrackor.utils.ValidateInputs;

@Service
public class UserDetailsService
		implements com.personalfinancetrackor.personalfinancetrackor.service.UserDetailsService {
	@Autowired
	EmailVerificationRepository emailVerificationRepository;

	@Autowired
	UserDetailsRepository userDetailsRepository;

	@Autowired
	EmailService emailService;

	@Autowired
	ValidateInputs validateInputs;

	@Override
	public String emailVerification(String email) {
		if (ValidateInputs.isValidEmail(email)) {
			Optional<UserDetails> checkEmail = userDetailsRepository.findByEmail(email);
			if (checkEmail == null) {
				String otp = String.valueOf(new Random().nextInt(900000) + 100000);
				String subject = "Your OTP for Verification";
				String body = "Your OTP is: " + otp;
				emailService.sendOtpEmail(email, subject, body);
				addOtp(email, otp);
				return otp;
			} else {
				return "E-mail already exist";
			}
		} else {
			return "Invalid E-mail address";
		}
	}
	
//	Storing the otp in db //storeOtpForVerification
	public void addOtp(String email, String otp) {
		Optional<EmailVerification> otpEntityOptional = emailVerificationRepository.findByEmail(email);
		if (otpEntityOptional.isPresent()) {
			EmailVerification existingOtpEntity = otpEntityOptional.get();
			existingOtpEntity.setOtp(otp);
			emailVerificationRepository.save(existingOtpEntity);
		} else {
			EmailVerification storeOtp = new EmailVerification();
			storeOtp.setEmail(email);
			storeOtp.setOtp(otp);
			storeOtp.setValidity(true);
			emailVerificationRepository.save(storeOtp);
		}
	}

	@Override
	public String checkUser(String email, String pin) {
		if (ValidateInputs.isValidEmail(email) && ValidateInputs.isValidPin(pin)) {
			Optional<UserDetails> checkEmail = userDetailsRepository.findByEmail(email);
			if (checkEmail != null) {
				Optional<UserDetails> checkPin = userDetailsRepository.findUser(email, pin);
				if (checkPin != null) {
					return "Valid User";
				} else {
					return "User exists and pin is correct";
				}
			} else {
				return "User does not exist";
			}
		} else {
			return "Invalid E-mail or pin format";
		}
	}
}
