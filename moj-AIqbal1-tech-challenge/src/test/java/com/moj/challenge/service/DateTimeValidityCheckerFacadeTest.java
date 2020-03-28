package com.moj.challenge.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DateTimeValidityCheckerFacadeTest {

	@Mock
	private DateTimeValidityChecker openingHourChecker;
	
	@Mock
	private DateTimeValidityChecker twoHourChecker;
	
	private List<DateTimeValidityChecker> checkerList = new ArrayList<>();

	private DateTimeValidityCheckerFacade checkerFacade;
	
	@BeforeEach
	public void init() {
	    checkerList.add(openingHourChecker);
	    checkerList.add(twoHourChecker);
	    
	    checkerFacade = new DateTimeValidityCheckerFacade(checkerList);
	}
	
	@Test
	public void test_isDateTimeValid_success_return_true() {
		LocalDateTime localDateTime = OffsetDateTime.now().toLocalDateTime();
		
		Mockito.when(openingHourChecker.isDateTimeValid(localDateTime)).thenReturn(true);
		Mockito.when(twoHourChecker.isDateTimeValid(localDateTime)).thenReturn(true);


		boolean isValid = checkerFacade.isDateTimeValid(localDateTime);
		
		assertTrue(isValid);

		Mockito.verify(openingHourChecker).isDateTimeValid(localDateTime);
		Mockito.verify(twoHourChecker).isDateTimeValid(localDateTime);

	}
	
	@Test
	public void test_isDateTimeValid_success_return_false() {
		LocalDateTime localDateTime = OffsetDateTime.now().toLocalDateTime();
		
		Mockito.when(openingHourChecker.isDateTimeValid(localDateTime)).thenReturn(true);
		Mockito.when(twoHourChecker.isDateTimeValid(localDateTime)).thenReturn(false);

		boolean isValid = checkerFacade.isDateTimeValid(localDateTime);
		
		assertFalse(isValid);

		Mockito.verify(openingHourChecker).isDateTimeValid(localDateTime);
		Mockito.verify(twoHourChecker).isDateTimeValid(localDateTime);

	}
	
}
