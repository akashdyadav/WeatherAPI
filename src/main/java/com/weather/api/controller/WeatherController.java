package com.weather.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.api.model.WeatherDetails;
import com.weather.api.service.WeatherService;

@RestController
@RequestMapping("/weatherapi")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("${weather.place}")
	public ResponseEntity<WeatherDetails> getRequest(@PathVariable("place") String place) {
		WeatherDetails response = weatherService.getWeatherDetails(place);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
