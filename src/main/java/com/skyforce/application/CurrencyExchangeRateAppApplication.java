package com.skyforce.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyExchangeRateAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeRateAppApplication.class, args);
	}
}
