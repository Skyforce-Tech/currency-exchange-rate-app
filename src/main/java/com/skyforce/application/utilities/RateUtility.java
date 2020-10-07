package com.skyforce.application.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RateUtility {
	
	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat YYMMdateFormatter = new SimpleDateFormat("yyyy-MM");
	
	public List<String> getLastTwelveMonthsDates() {
		//This is the list to return with last 12 months date
		List<String> lastTwelveMonthsDates = new ArrayList<String>();
		
		//This is to fetch the current date with which we will find last twelve months from now.
		Calendar currentDate = Calendar.getInstance();
		currentDate.setTime(Calendar.getInstance().getTime());
		
		for (int i = 1; i <= 12; i++) {
			//We will move a month back each time before adding to list
			currentDate.add(Calendar.MONTH, -1);
		    String previousMonth = dateFormatter.format(currentDate.getTime());
		    lastTwelveMonthsDates.add(previousMonth);
		}
		
		return lastTwelveMonthsDates;
	}

	public String getDateInYYMMFormat(String date) {
		String parsedDate = "";
		System.out.println(date);
		try {
			parsedDate = YYMMdateFormatter.format(dateFormatter.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parsedDate;
	}
}
