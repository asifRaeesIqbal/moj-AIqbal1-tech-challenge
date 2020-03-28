package com.moj.challenge.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

public class OpeningHourDateTimeValidatorTest {
	

	private OpeningHourDateTimeValidator checker = new OpeningHourDateTimeValidator();
	
	@Test
	public void test_mon_test_hours_return_true() {
		LocalDateTime dateTime = convertStrToLocalDateTime("2020-03-16 15:30");
		
		assertTrue(checker.isDateTimeValid(dateTime));
	}
	
	@Test
	public void test_tue_test_hours_return_true() {
		LocalDateTime dateTime = convertStrToLocalDateTime("2020-03-17 10:30");
		
		assertTrue(checker.isDateTimeValid(dateTime));
	}
	
	@Test
	public void test_wed_test_hours_return_true() {
		LocalDateTime dateTime = convertStrToLocalDateTime("2020-03-18 17:30");
		
		assertTrue(checker.isDateTimeValid(dateTime));
	}
	
	@Test
	public void test_wed_test_out_hours_return_false() {
		LocalDateTime dateTime = convertStrToLocalDateTime("2020-03-18 18:30");
		
		assertFalse(checker.isDateTimeValid(dateTime));
	}
	
	@Test
	public void test_mon_test_out_hours_return_false() {
		LocalDateTime dateTime = convertStrToLocalDateTime("2020-03-16 06:30");
		
		assertFalse(checker.isDateTimeValid(dateTime));
	}
	
	@Test
	public void test_thu_test_hours_return_true() {
		LocalDateTime dateTime = convertStrToLocalDateTime("2020-03-19 19:30");
		
		assertTrue(checker.isDateTimeValid(dateTime));
	}
	
	@Test
	public void test_fri_test_hours_return_true() {
		LocalDateTime dateTime = convertStrToLocalDateTime("2020-03-20 17:30");
		
		assertTrue(checker.isDateTimeValid(dateTime));
	}
	
	@Test
	public void test_fri_test_out_hours_return_false() {
		LocalDateTime dateTime = convertStrToLocalDateTime("2020-03-20 21:30");
		
		assertFalse(checker.isDateTimeValid(dateTime));
	}

	
	@Test
	public void test_sat_test_hours_return_true() {
		LocalDateTime dateTime = convertStrToLocalDateTime("2020-03-21 10:30");
		
		assertTrue(checker.isDateTimeValid(dateTime));
	}
	
	@Test
	public void test_sat_test_out_hours_return_false() {
		LocalDateTime dateTime = convertStrToLocalDateTime("2020-03-21 12:45");
		
		assertFalse(checker.isDateTimeValid(dateTime));
	}
	
	@Test
	public void test_sun_test_out_hours_return_false() {
		LocalDateTime dateTime = convertStrToLocalDateTime("2020-03-22 12:45");
		
		assertFalse(checker.isDateTimeValid(dateTime));
	}
	
	private static LocalDateTime convertStrToLocalDateTime(String str) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime formatDateTime = LocalDateTime.parse(str, formatter);
		return formatDateTime;
	}
}
