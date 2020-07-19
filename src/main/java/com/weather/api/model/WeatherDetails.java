package com.weather.api.model;

import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class WeatherDetails {
	
	private String status;
	private String message;
	private Optional<WeatherResponse> weatherResponse=Optional.empty();
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Optional<WeatherResponse> getWeatherResponse() {
		return weatherResponse;
	}
	public void setWeatherResponse(Optional<WeatherResponse> weatherResponse) {
		this.weatherResponse = weatherResponse;
	}
	@Override
	public String toString() {
		return "WeatherDetails [status=" + status + ", message=" + message + ", weatherResponse=" + weatherResponse
				+ "]";
	}
	
	

}
