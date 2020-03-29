package com.moj.challenge.web;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moj.challenge.service.DateTimeValidityCheckerFacade;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = "Valid Date Checker API")
public class CheckDateController {

	@Autowired
	private DateTimeValidityCheckerFacade checkDateController;

	@ApiOperation(value = "Checks if the date passed in is valid. Accepts the format ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully checked the date."),
			@ApiResponse(code = 401, message = "You are not authorized to get this information."), })
	@GetMapping("/callcenter/availability/date/check")
	public boolean getStatus(@ApiParam("Local Date Time to validate, Cannot be empty and must be in the most common ISO DateTime Format yyyy-MM-dd'T'HH:mm:ss.SSSXXX. eg 2020-03-30T15:30:00.000")
			@RequestParam("dateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime)
			throws Exception {

		return checkDateController.isDateTimeValid(dateTime);
	}
}
