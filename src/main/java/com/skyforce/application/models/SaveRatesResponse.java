package com.skyforce.application.models;

import org.springframework.stereotype.Component;

@Component
public class SaveRatesResponse {
	
	private String responseStatus;
	private String responseMessage;
	
	public String getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
}
