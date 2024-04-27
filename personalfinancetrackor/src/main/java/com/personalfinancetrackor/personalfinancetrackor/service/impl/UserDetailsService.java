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
			System.out.println("email  " + checkEmail);
			if (!checkEmail.isPresent()) {
				System.out.println("email  df" + checkEmail);
				String otp = String.valueOf(new Random().nextInt(900000) + 100000);
				String subject = "Your OTP for Verification";
				String body = "Your OTP is: " + otp;
				emailService.sendOtpEmail(email, subject, body);
				addOtp(email, otp);
				return otp;
			} else {
				System.out.println("emaildfd  " + checkEmail);
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

//	Validating the otp
	@Override
	public String verifyOtp(String email, String otp) {
		Optional<EmailVerification> otpEntityOptional = emailVerificationRepository.findByEmail(email);
		if (otpEntityOptional.isPresent()) {
			EmailVerification storedOtpEntity = otpEntityOptional.get();
			String storedOtp = storedOtpEntity.getOtp();

			// Check if the provided OTP matches the stored OTP
			if (storedOtp.equals(otp)) {
				emailVerificationRepository.delete(storedOtpEntity);

				return "Successfully varified the Email";
			} else {
				throw new Error("Invalid OTP, Please enter the correct OTP");
			}
		} else {
			throw new Error("Invalid E-Mail, Please check E-Mail");
		}
	}

	@Override
	public String processUserRegistration(UserDetails userDetails) {
		UserDetails userRegistration = new UserDetails();

		// Set user details from the provided object
		userRegistration.setFirstName(userDetails.getFirstName());
		userRegistration.setLastName(userDetails.getLastName());
		userRegistration.setOccupation(userDetails.getOccupation());
		System.out.println("going" + userDetails.getAge());
		userRegistration.setAge(userDetails.getAge());
		userRegistration.setEmail(userDetails.getEmail());
		userRegistration.setCreatedBy("admin");
		userRegistration.setUpdatedBy("admin");

		// Check if the email already exists in the database
		Optional<UserDetails> existingUserByEmail = userDetailsRepository.findByEmail(userDetails.getEmail());
		if (!existingUserByEmail.isPresent()) {
				userDetailsRepository.save(userRegistration);
				return "User details have been successfully added to the database.";
		} else {
			throw new Error("E-Mail already exists.");
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
