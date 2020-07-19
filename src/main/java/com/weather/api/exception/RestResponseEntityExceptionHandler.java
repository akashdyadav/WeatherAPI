package com.weather.api.exception;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.weather.api.model.WeatherDetails;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@Autowired
	private WeatherDetails weatherDetails;
	
	@ExceptionHandler(value = { WeatherException.class})
	protected ResponseEntity<WeatherDetails> handleConflict(WeatherException ex) {
		
		weatherDetails.setStatus(ex.getErrorCode());
		weatherDetails.setMessage(ex.getErrorMessage());
		weatherDetails.setWeatherResponse(Optional.empty());
		return new ResponseEntity<>(weatherDetails,HttpStatus.valueOf(Integer.parseInt(ex.getErrorCode())));
	}

}
