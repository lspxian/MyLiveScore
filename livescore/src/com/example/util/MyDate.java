package com.example.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MyDate extends Date{
	
	
	@SuppressWarnings("deprecation")
	public String toString(){
		Calendar calendar=Calendar.getInstance(TimeZone.getTimeZone("GMT+1"), Locale.FRANCE);
		return this.getYear()+"-"+this.getMonth()+"-"+this.getDay();
	}
}
