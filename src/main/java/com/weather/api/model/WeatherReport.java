package com.weather.api.model;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;


public class WeatherReport {
	
	private Optional<List<Weather>> weather=Optional.empty();
	private Optional<Main> main=Optional.empty();
	private Optional<Sys> sys=Optional.empty();
	public Optional<Sys> getSys() {
		return sys;
	}
	public void setSys(Optional<Sys> sys) {
		this.sys = sys;
	}
	private String name;
	public Optional<List<Weather>> getWeather() {
		return weather;
	}
	public void setWeather(Optional<List<Weather>> weather) {
		this.weather = weather;
	}
	public Optional<Main> getMain() {
		return main;
	}
	public void setMain(Optional<Main> main) {
		this.main = main;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "WeatherReport [weather=" + weather + ", main=" + main + ", sys=" + sys + ", name=" + name + "]";
	}
	
	
	
	
	
	

}
