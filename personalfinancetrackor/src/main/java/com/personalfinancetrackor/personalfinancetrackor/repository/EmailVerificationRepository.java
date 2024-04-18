package com.personalfinancetrackor.personalfinancetrackor.repository;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

public interface EmailVerificationRepository extends CrudRepository<EmailVerification, BigDecimal> {

}
