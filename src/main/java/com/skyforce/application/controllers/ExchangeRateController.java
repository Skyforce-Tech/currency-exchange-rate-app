package com.skyforce.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skyforce.application.models.SaveRatesResponse;
import com.skyforce.application.services.ExchangeRateService;

@RestController
@RequestMapping("/exchangerateapp/v1")
public class ExchangeRateController {
	
	@Autowired
	ExchangeRateService exchangeRateService;
	
	@GetMapping("/saveRates")
	public ResponseEntity<SaveRatesResponse> saveRates(){
		SaveRatesResponse saveRatesResponse = exchangeRateService.saveRatesToDataBase();
		return new ResponseEntity<SaveRatesResponse>(saveRatesResponse, HttpStatus.OK);
	}
	
	@GetMapping("/getRateForSpecificDate/{userProvidedDate}/{currency}")
	public ResponseEntity<String> getRate(@PathVariable("userProvidedDate") String userProvidedDate, @PathVariable("currency") String currency){
		String rateResponse = exchangeRateService.getSpecificDateRate(userProvidedDate, currency);
		return new ResponseEntity<String>(rateResponse, HttpStatus.OK);
	}
}