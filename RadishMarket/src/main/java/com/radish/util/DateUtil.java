package com.radish.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateUtil {
	private DateUtil() {
	}

	private static DateUtil instance;

	public static DateUtil getInstance() {
		if (instance == null)
			instance = new DateUtil();
		return instance;
	}
	
	public static String getDateNow() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	}
	
	public static String getCalcDateAgo(String date) {
		String nowDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String saveDate = date.split(" ")[0];
		int[] now = new int[3];
		int[] save = new int[3];
		for(int i = 0 ; i < 3 ; i++) {
			now[i] = Integer.parseInt(nowDate.split("-")[i]);
			save[i] = Integer.parseInt(saveDate.split("-")[i]);
		}
		Period period = Period.between(LocalDate.of(save[0],save[1],save[2]),LocalDate.of(now[0],now[2],now[2]));
		String printDateAgo = "오늘";
		if(period.getYears() != 0)
			printDateAgo = period.getYears() + "년 전";
		else if(period.getMonths() != 0)
			printDateAgo = period.getMonths() + "달 전";
		else if(period.getDays() != 0)
			printDateAgo = period.getDays() + "일 전";
		return printDateAgo;
	}
}
