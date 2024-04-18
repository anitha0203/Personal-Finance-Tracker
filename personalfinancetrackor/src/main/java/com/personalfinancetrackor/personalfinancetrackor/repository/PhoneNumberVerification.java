package com.personalfinancetrackor.personalfinancetrackor.repository;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "phone_number_authentication")
public class PhoneNumberVerification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private BigDecimal id;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "otp")
	private String otp;

	@Column(name = "validity")
	private Boolean validity;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Boolean getValidity() {
		return validity;
	}

	public void setValidity(Boolean validity) {
		this.validity = validity;
	}
}
