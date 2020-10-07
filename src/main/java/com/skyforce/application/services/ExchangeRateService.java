package com.skyforce.application.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.skyforce.application.models.ExchangeRateApiResponse;
import com.skyforce.application.models.ExchangeRates;
import com.skyforce.application.models.SaveRatesResponse;
import com.skyforce.application.repositories.ExchangeRateRepository;
import com.skyforce.application.utilities.RateConstants;
import com.skyforce.application.utilities.RateUtility;

@Service
public class ExchangeRateService {

	@Autowired
	ExchangeRateRepository exchangeRateRepository;
	@Autowired
	RateUtility rateUtility;
	@Autowired
	RestTemplate restTemplate;
	
	public SaveRatesResponse saveRatesToDataBase() {
		SaveRatesResponse saveRatesResponse = new SaveRatesResponse();
		List<String> lastTwelveMonthsDates= rateUtility.getLastTwelveMonthsDates();
		Iterator<String> lastTwelveMonthsDatesIterator = lastTwelveMonthsDates.iterator();
		while (lastTwelveMonthsDatesIterator.hasNext()) {
			ExchangeRateApiResponse exchangeRateApiResponse = restTemplate.getForEntity("https://api.ratesapi.io/api/"+
	    									lastTwelveMonthsDatesIterator.next()+"?symbols=USD,GBP,HKD" , ExchangeRateApiResponse.class).getBody();
			ExchangeRates exchangeRates=new ExchangeRates();
			exchangeRates.setRateDate(rateUtility.getDateInYYMMFormat(exchangeRateApiResponse.getDate()));
			exchangeRates.setGpbRate(exchangeRateApiResponse.getRates().get("GBP"));
			exchangeRates.setUsdRate(exchangeRateApiResponse.getRates().get("USD"));
			exchangeRates.setHkdRate(exchangeRateApiResponse.getRates().get("HKD"));
			exchangeRateRepository.save(exchangeRates);
	    }
		saveRatesResponse.setResponseStatus(RateConstants.SUCCESS);
		saveRatesResponse.setResponseMessage("Currency rates inserted successfully.");
		
		return saveRatesResponse; 
	}
	
	public String getSpecificDateRate(String userProvidedDate, String currency) {
		ExchangeRates exchangeRates = exchangeRateRepository.findById(rateUtility.getDateInYYMMFormat(userProvidedDate)).get();
		if(currency.equals("GBP"))
			return exchangeRates.getGpbRate();
		else if(currency.equals("USD"))
			return exchangeRates.getUsdRate();
		else if(currency.equals("HKD"))
			return exchangeRates.getHkdRate();
		else
			return "NRF";
	}
}
