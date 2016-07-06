package com.myweather.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.myweather.service.WeatherService;
import com.myweather.jaxb.content.WeatherReport;

@Produces({"application/xml","application/json"})
public class MyWeatherEndPoint {
	
	private WeatherService weatherService ;

	public WeatherService getWeatherService() {
		return weatherService;
	}

	public void setWeatherService(WeatherService weatherService) {
		this.weatherService = weatherService;
	}
	
	@GET
    @Path("/zipcode/{zipcode}")
	public WeatherReport getWeatherReportByZipCode(@PathParam("zipcode") Integer zipcd)
	{
		return weatherService.getWeatherReportByZipCode(zipcd);
	}
}
