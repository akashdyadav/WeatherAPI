package com.weather.api.model;

public class Weather {

	private String main;

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	@Override
	public String toString() {
		return "Weather [main=" + main + "]";
	}
	
	
}
