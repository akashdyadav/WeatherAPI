package com.weather.api.service;


import com.weather.api.model.WeatherDetails;


public interface WeatherService {

	public WeatherDetails getWeatherDetails(String place);

}
