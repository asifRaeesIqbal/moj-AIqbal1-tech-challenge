package com.moj.challenge.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;


/**
 * This checker insures the date time supplied is not any earlier than 2 hours in the future.
 * 
 * @author AI
 *
 */

@Service
@Order(2)
public class Future2HourDateTimeValidityChecker implements DateTimeValidityChecker {

	@Override
	public boolean isDateTimeValid(LocalDateTime localDateTime) {
		if(localDateTime.isBefore(getDateTime())) { // past
			return false;
		}
		
		LocalDateTime dateTime = getDateTime();
		dateTime = dateTime.plusHours(2);		
		if(localDateTime.isAfter(dateTime) || localDateTime.equals(dateTime)) {
			return true;
		}
		return false;
	}
	
	LocalDateTime getDateTime() {
		return OffsetDateTime.now().toLocalDateTime();
	}
}
