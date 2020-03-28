package com.moj.challlenge.web;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moj.challenge.service.DateTimeValidityCheckerFacade;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = "Valid Date Checker API")
public class CheckDateController {

	@Autowired
	private DateTimeValidityCheckerFacade checkDateController;

	@ApiOperation(value = "Checks if the date passed in is valid.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully checked the date."),
			@ApiResponse(code = 401, message = "You are not authorized to get this information."), })
	@GetMapping("/callcenter/availability/date/check")
	public boolean getStatus(
			@RequestParam("dateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime)
			throws Exception {

		return checkDateController.isDateTimeValid(dateTime);
	}
}
