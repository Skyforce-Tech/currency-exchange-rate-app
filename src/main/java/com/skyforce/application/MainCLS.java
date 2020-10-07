package com.skyforce.application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainCLS {
	public static void main(String[] args) throws ParseException {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM");
		Date date = dateFormat.parse("2020-10-06");
		String strDate = dateFormat2.format(date);
		System.out.println(strDate);
	}
}
