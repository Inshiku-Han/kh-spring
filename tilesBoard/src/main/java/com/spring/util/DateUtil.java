package com.spring.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
	//현재날짜
	public static String getToDate(String format) {
		//날짜 선언
		Calendar cal = Calendar.getInstance();
		//날짜 포맷 선언
		SimpleDateFormat formatted = new SimpleDateFormat(format);
		//포맷에 날짜 넣기
		String toDate = formatted.format(cal.getTime());
		
		return toDate;
	}
	
	//한달전 날짜
	public static String getFromDate(String format) {
		//날짜 선언
		Calendar cal = Calendar.getInstance();
		//날짜 포맷 선언
		SimpleDateFormat formatted = new SimpleDateFormat(format);
		//날짜 변경
		cal.add(Calendar.MONTH, -1); 
		//포맷에 바뀐 날짜 넣기
		String fromDate = formatted.format(cal.getTime());
		
		return fromDate;
	}
	
	//현재날짜 및 시분초 가져오는 메소드
		public static String getNowDateTime() {
			//Calendar 객체 생성
			Calendar cal = Calendar.getInstance();
			
			String year = cal.get(Calendar.YEAR) + "";
			String month = cal.get(Calendar.MONTH) + 1 + "";
			String day = cal.get(Calendar.DAY_OF_MONTH) + "";
			String hour = cal.get(Calendar.HOUR) + "";
			String minute = cal.get(Calendar.MINUTE) + "";
			String second = cal.get(Calendar.SECOND) + "";
			
			return year + month + day + hour + minute + second;
		}
}
