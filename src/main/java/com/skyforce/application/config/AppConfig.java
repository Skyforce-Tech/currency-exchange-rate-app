package com.skyforce.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.skyforce.application.utilities.RateUtility;

@Configuration
public class AppConfig {
	
	@Bean
	public RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}
	
	@Bean
	public RateUtility getRateUtility() {
		RateUtility rateUtility = new RateUtility();
		return rateUtility;
	}
}
