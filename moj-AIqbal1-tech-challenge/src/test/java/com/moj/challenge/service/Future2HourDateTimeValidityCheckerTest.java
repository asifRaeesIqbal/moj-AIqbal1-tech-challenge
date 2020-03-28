package com.moj.challenge.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

public class Future2HourDateTimeValidityCheckerTest {

	@Test
	public void test_isDateTimeValid_falls_within_2_hours_success_return_true() {
		Future2HourDateTimeValidityChecker checker = new FakeFuture2HourDateTimeValidityChecker("2020-03-20 09:30");
		
		boolean dateTimeValid = checker.isDateTimeValid(convertStrToLocalDateTime("2020-03-20 10:30"));
		
		assertTrue(dateTimeValid);

	}
	
	@Test
	public void test_isDateTimeValid_falls_outside_2_hours_return_false() {
		Future2HourDateTimeValidityChecker checker = new FakeFuture2HourDateTimeValidityChecker("2020-02-20 07:30");
		
		boolean dateTimeValid = checker.isDateTimeValid(convertStrToLocalDateTime("2020-02-20 10:30"));
		
		assertFalse(dateTimeValid);

	}
	
	@Test
	public void test_isDateTimeValid_date_before_current_return_false() {
		Future2HourDateTimeValidityChecker checker = new FakeFuture2HourDateTimeValidityChecker("2020-02-20 07:30");
		
		boolean dateTimeValid = checker.isDateTimeValid(convertStrToLocalDateTime("2020-02-19 08:30"));
		
		assertFalse(dateTimeValid);

	}

	static class FakeFuture2HourDateTimeValidityChecker extends Future2HourDateTimeValidityChecker {
		private String str;
		
		public FakeFuture2HourDateTimeValidityChecker(String str) {
			super();
			this.str = str;
		}

		@Override
		LocalDateTime getDateTime() {
			return convertStrToLocalDateTime(str);
		}
		
	}
	
	private static LocalDateTime convertStrToLocalDateTime(String str) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime formatDateTime = LocalDateTime.parse(str, formatter);
		return formatDateTime;
	}
	
}
