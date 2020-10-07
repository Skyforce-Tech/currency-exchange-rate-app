package com.skyforce.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skyforce.application.models.ExchangeRates;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRates, String>{
	
}
