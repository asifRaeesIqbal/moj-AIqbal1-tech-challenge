package com.moj.challenge.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

public class FutureWorkingDayDateTimeValidityCheckerTest {

	@Test
	public void test_isDateTimeValid_falls_within_6_working_days_success_return_true() {
		FutureWorkingDayDateTimeValidityChecker checker = new FakeFutureWorkingDayDateTimeValidityChecker("2020-03-12");
		
		boolean dateTimeValid = checker.isDateTimeValid(convertStrToLocalDateTime("2020-02-20 10:30"));
		
		assertTrue(dateTimeValid);

	}
	
	@Test
	public void test_isDateTimeValid_falls_outside_6_working_days_return_false() {
		FutureWorkingDayDateTimeValidityChecker checker = new FakeFutureWorkingDayDateTimeValidityChecker("2020-03-12");
		
		boolean dateTimeValid = checker.isDateTimeValid(convertStrToLocalDateTime("2020-02-21 10:30"));
		
		assertTrue(dateTimeValid);

	}

	static class FakeFutureWorkingDayDateTimeValidityChecker extends FutureWorkingDayDateTimeValidityChecker {
		private String str;
		
		public FakeFutureWorkingDayDateTimeValidityChecker(String str) {
			super();
			this.str = str;
		}

		@Override
		LocalDate getTodaysDate() {
			return convertStrToLocalDate(str);
		}
	}

	private static LocalDate convertStrToLocalDate(String str) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate formatDate = LocalDate.parse(str, formatter);
		return formatDate;
	}
	
	private static LocalDateTime convertStrToLocalDateTime(String str) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime formatDateTime = LocalDateTime.parse(str, formatter);
		return formatDateTime;
	}
}
