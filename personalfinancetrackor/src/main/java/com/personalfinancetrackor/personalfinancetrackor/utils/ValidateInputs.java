package com.personalfinancetrackor.personalfinancetrackor.utils;

import org.springframework.stereotype.Component;

@Component
public class ValidateInputs {
	public static boolean isValidEmail(String email) {
		// Basic email format validation
		return email != null && email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
	}

	public static boolean isValidPin(String pin) {
		// Basic pin validation (you may want to adjust this based on your requirements)
		return pin != null && pin.length() == 4 && pin.matches("[0-9]+");
	}
}
