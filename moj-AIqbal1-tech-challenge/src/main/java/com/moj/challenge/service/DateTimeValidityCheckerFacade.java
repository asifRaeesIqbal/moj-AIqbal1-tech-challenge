package com.moj.challenge.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * A simple class that acts like a facade and cycles through all the validity checkers and test 
 * the date against the various conditions. IF any fail, a false will be returned.
 * 
 * {@link DateTimeValidityChecker} implementations are autowired into the class and cycled through.
 * 
 * @author AI
 *
 */
@Service
public class DateTimeValidityCheckerFacade {
	
	private List<DateTimeValidityChecker> checkers;
	
	@Autowired
	public DateTimeValidityCheckerFacade(List<DateTimeValidityChecker> checkers) {
		this.checkers = checkers;
	}

	public boolean isDateTimeValid(LocalDateTime dateTime) {
		boolean isValid = true;
		for(DateTimeValidityChecker checker : checkers) {
			isValid = checker.isDateTimeValid(dateTime);
			if(!isValid) {
				break;
			}
		}
		return isValid;
	}
}
