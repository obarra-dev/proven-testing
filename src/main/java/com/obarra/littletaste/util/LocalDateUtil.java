package com.obarra.littletaste.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateUtil {
	
	private LocalDateUtil() {
		
	}
	
	public static LocalDateTime getLastDateTimeOfCurrentMonth() {
		return getLastDateTimeOfMonth(YearMonth.now());
	}
	
	public static LocalDateTime getLastDateTimeOfMonth(final YearMonth yearMonth) {
		LocalDate lastDateOfMonth = yearMonth.atEndOfMonth();
		LocalDateTime lastDateTimeOfDay = lastDateOfMonth.atTime(LocalTime.parse("23:59:59"));
		return lastDateTimeOfDay;
	}
	
	public static String formatLocalDateTime(final LocalDateTime localDateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return localDateTime.format(formatter);
	}

	public static LocalDate getFirstDateOfCurrentMonth() {
		return getFirstDate(YearMonth.now());
	}
	
	public static LocalDate getFirstDate(final YearMonth yearMonth) {
		return yearMonth.atDay(1);
	}
	
	public static String formatLocalDate(final LocalDate localDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return localDate.format(formatter);
	}
	
	public static Date convertLocalDateToDate(final LocalDate localDate) {
		return java.util.Date.from(localDate.atStartOfDay()
			      .atZone(ZoneId.systemDefault())
			      .toInstant());
	}
	
	public static Date convertLocalDateTimeToDate(final LocalDateTime localDateTime) {
		  return java.util.Date
			      .from(localDateTime.atZone(ZoneId.systemDefault())
			      .toInstant());

	}
	

}
