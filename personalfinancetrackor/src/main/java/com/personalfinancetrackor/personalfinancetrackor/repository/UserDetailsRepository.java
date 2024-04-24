package com.personalfinancetrackor.personalfinancetrackor.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserDetailsRepository extends CrudRepository<UserDetails, BigDecimal> {
	
	@Query(value="select * from userdetails where email=:email", nativeQuery = true)
	Optional<UserDetails> findByEmail(@Param("email") String email);
	

	@Query(value="select * from userdetails where email=:email and pin=:pin", nativeQuery = true)
	Optional<UserDetails> findUser(String email, String pin);

}
