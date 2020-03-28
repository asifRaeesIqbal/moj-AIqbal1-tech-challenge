package com.moj.challenge.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * This checker insures the date time supplied is not more than 6 working days in the future.
 * 
 * @author AI
 *
 */

@Service
@Order(1)
public class FutureWorkingDayDateTimeValidityChecker implements DateTimeValidityChecker {

	@Override
	public boolean isDateTimeValid(LocalDateTime localDateTime) {
		LocalDate newDate = get6thWorkingDay();
		if(localDateTime.toLocalDate().isBefore(newDate) || localDateTime.toLocalDate().isEqual(newDate)) {
			return true;
		}
		return false;
	}
	
	private LocalDate get6thWorkingDay() {
		LocalDate updatedDate = getTodaysDate();
	    int daysAdded = 0;
	    while (daysAdded < 6) {
	        updatedDate = updatedDate.plusDays(1);
	        if (!isWeekend(updatedDate)) {
	            ++daysAdded;
	        }
	    }
	    return updatedDate;
	}
	
	LocalDate getTodaysDate() {
		return OffsetDateTime.now().toLocalDate();
	}
	
	private boolean isWeekend(LocalDate date) {
		return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
	}

}
