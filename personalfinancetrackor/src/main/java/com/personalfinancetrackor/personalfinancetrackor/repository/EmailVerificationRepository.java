package com.personalfinancetrackor.personalfinancetrackor.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmailVerificationRepository extends CrudRepository<EmailVerification, BigDecimal> {
	
	@Query(value="select * from email_id_authentication where email=:email", nativeQuery = true)
	Optional<EmailVerification> findByEmail(@Param("email") String email);
	

}
