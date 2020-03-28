package com.moj.challenge.service;

import java.time.LocalDateTime;

/**
 * A basic interface that validates the date time passed in.
 * 
 * @author AI
 *
 */
@FunctionalInterface
public interface DateTimeValidityChecker {

	/**
	 * Implementations of this method will check that the dateTime passed in is valid. 
	 * 
	 * @param localDateTime
	 * @return
	 */
	boolean isDateTimeValid(LocalDateTime localDateTime);
}
