package com.skyforce.application.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExchangeRates {
	
	@Id
	private String rateDate;
	@Column
	private String gpbRate;
	@Column
	private String usdRate;
	@Column
	private String hkdRate;
	
	public String getRateDate() {
		return rateDate;
	}
	public void setRateDate(String rateDate) {
		this.rateDate = rateDate;
	}
	public String getGpbRate() {
		return gpbRate;
	}
	public void setGpbRate(String gpbRate) {
		this.gpbRate = gpbRate;
	}
	public String getUsdRate() {
		return usdRate;
	}
	public void setUsdRate(String usdRate) {
		this.usdRate = usdRate;
	}
	public String getHkdRate() {
		return hkdRate;
	}
	public void setHkdRate(String hkdRate) {
		this.hkdRate = hkdRate;
	}
}
