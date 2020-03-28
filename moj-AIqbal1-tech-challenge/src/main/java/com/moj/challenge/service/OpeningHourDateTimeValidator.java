package com.moj.challenge.service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * This checker insures the date time supplied falls within the working hours.
 * 
 * @author AI
 *
 */

@Service
@Order(3)
public class OpeningHourDateTimeValidator implements DateTimeValidityChecker {

	@Override
	public boolean isDateTimeValid(LocalDateTime localDateTime) {
		boolean isValid = false;
		DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
		switch (dayOfWeek) {
		case MONDAY:
		case TUESDAY:
		case WEDNESDAY:
		    	isValid = fallsOnMonToWedHours(localDateTime);
			 	break;
		case THURSDAY:
		case FRIDAY:	
	    	isValid = fallsOnThurToFriHours(localDateTime);
		 	break;
		case SATURDAY:	
	    	isValid = fallsOnSatHours(localDateTime);
		 	break;
		default:
			isValid = false;
			break;
		}
		return isValid;
	}

	
	private boolean fallsOnMonToWedHours(LocalDateTime localDateTime) {
		LocalDateTime closingTime =
			    LocalDateTime.of(localDateTime.getYear(), localDateTime.getMonth(), localDateTime.getDayOfMonth(), 18, 00, 00, 000);
		return localDateTime.getHour() >= 9 && localDateTime.isBefore(closingTime);
	}
	
	private boolean fallsOnThurToFriHours(LocalDateTime localDateTime) {
		LocalDateTime closingTime =
			    LocalDateTime.of(localDateTime.getYear(), localDateTime.getMonth(), localDateTime.getDayOfMonth(), 20, 00, 00, 000);
		return localDateTime.getHour() >= 9 && localDateTime.isBefore(closingTime);
	}
	
	private boolean fallsOnSatHours(LocalDateTime localDateTime) {
		LocalDateTime closingTime =
			    LocalDateTime.of(localDateTime.getYear(), localDateTime.getMonth(), localDateTime.getDayOfMonth(), 12, 30, 00, 000);
		return localDateTime.getHour() >= 9 && localDateTime.isBefore(closingTime) ;
	}
	
}
