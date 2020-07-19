package com.weather.api.serviceimpl;


import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.weather.api.exception.WeatherException;
import com.weather.api.model.WeatherDetails;
import com.weather.api.model.WeatherReport;
import com.weather.api.model.WeatherResponse;
import com.weather.api.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private WeatherDetails weatherDetails;
	
	@Autowired
	private WeatherResponse weatherResponse;
	
	@Value("${weather.appid}")
	private String appid;
	
	RestTemplate restTemplate = new RestTemplate();
	
	@Override
	public WeatherDetails getWeatherDetails(String place) {
		
		MultiValueMap<String,String> multiparams = new LinkedMultiValueMap<>();
		multiparams.add("q", place);
		multiparams.add("appid", appid);
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
			      .scheme("https").host("api.openweathermap.org").path("/data").path("/2.5").path("/weather").queryParams(multiparams).build();
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	    ResponseEntity<WeatherReport> result = null;
	    
	    try {
		result = restTemplate.exchange(uriComponents.toUriString(), HttpMethod.GET, entity, WeatherReport.class);
		
	    }catch(Exception ex) {
	    	
	    	throw new WeatherException("City Not Found",String.valueOf(404));
	    	
	    }
		Optional.ofNullable(result.getBody()).ifPresent(a->a.getWeather().ifPresent(b->weatherResponse.setDaytype(b.get(0).getMain())));
		Optional.ofNullable(result.getBody()).ifPresent(a->weatherResponse.setPlace(a.getName()));
		Optional.ofNullable(result.getBody()).ifPresent(a->a.getMain().ifPresent(b->weatherResponse.setTemperature(b.getTemp()-273.15)));
		Optional.ofNullable(result.getBody()).ifPresent(a->a.getSys().ifPresent(b->weatherResponse.setCountry(b.getCountry())));
		
		weatherDetails.setStatus("Success");
		weatherDetails.setMessage("");
		weatherDetails.setWeatherResponse(Optional.of(weatherResponse));
		return weatherDetails;
	}

}
