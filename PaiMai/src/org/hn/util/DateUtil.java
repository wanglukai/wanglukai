package org.hn.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date strToDate(String date){
		DateFormat dateformate=null;
		dateformate=new SimpleDateFormat("yyyy/MM/dd");
		dateformate.setLenient(false);
		try {
			Date day=dateformate.parse(date);
			return day;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		
		
		}
}
