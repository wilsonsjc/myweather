package com.myweather.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myweather.jaxb.content.WeatherReport;
import com.myweather.service.WeatherServiceIF;

@RestController
public class MyWeatherRestController {
	
	private static Logger log = Logger.getLogger(MyWeatherRestController.class);
	
	@Autowired
	WeatherServiceIF weatherService;
	
	@RequestMapping(value = "/zipcode/{zipcode}", method = RequestMethod.GET,
					headers ={"Accept=application/json,application/xml"},
					produces={"application/json", "application/xml"})
	public ResponseEntity<WeatherReport> getWeatherReportByZipCode(@PathVariable("zipcode") Integer zipcode) {
		log.info("Enter getWeatherReportByZipCode");
		return new ResponseEntity<WeatherReport>(weatherService.getWeatherReportByZipCode(zipcode), HttpStatus.OK);
	}
	


}
