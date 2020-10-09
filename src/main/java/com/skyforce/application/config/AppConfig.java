package com.skyforce.application.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.skyforce.application.utilities.RateUtility;

import brave.sampler.Sampler;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class AppConfig {
	
	@Value("${application-name}")
	private String applicationName;
	@Value("${application-description}")
	private String applicationDescription;
	@Value("${application-version}")
	private String applicationVersion;
	
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
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(
					new Info().title(applicationName)
					.description(applicationDescription)
					.version(applicationVersion)
				);
	}
	
	@Bean
	public Sampler defaultSampler()  {  
		return Sampler.ALWAYS_SAMPLE;
	}
}
