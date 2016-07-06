package com.myweather.service;

import com.myweather.jaxb.content.WeatherReport;

public interface WeatherServiceIF {

	public WeatherReport getWeatherReportByZipCode(Integer zipcd);
}
