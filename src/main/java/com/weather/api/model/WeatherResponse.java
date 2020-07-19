package com.weather.api.model;

import org.springframework.stereotype.Component;

@Component
public class WeatherResponse {

	private String place;
	private double temperature;
	private String country;
	private String daytype;
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDaytype() {
		return daytype;
	}
	public void setDaytype(String daytype) {
		this.daytype = daytype;
	}
	@Override
	public String toString() {
		return "WeatherResponse [place=" + place + ", temperature=" + temperature + ", country=" + country
				+ ", daytype=" + daytype + "]";
	}
	
	
	
}
