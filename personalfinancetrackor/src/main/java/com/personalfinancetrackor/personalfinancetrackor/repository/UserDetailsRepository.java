package com.personalfinancetrackor.personalfinancetrackor.repository;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

public interface UserDetailsRepository extends CrudRepository<UserDetails, BigDecimal> {

}
