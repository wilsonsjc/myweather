package com.myweather.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.myweather.dao.ZipcodeDAO;
import com.myweather.jaxb.content.*;
import com.myweather.model.*;
import com.myweather.service.mapper.WeatherMapper;
/*import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonInputMessage;
import org.springframework.http.converter.json.MappingJacksonValue;*/


public class WeatherServiceImpl implements WeatherServiceIF {
	
	private static Logger log = Logger.getLogger(WeatherServiceImpl.class);
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	private ZipcodeDAO zipcodeDAO;
	private WeatherMapper weatherMapper;
	
	public WeatherServiceImpl(ZipcodeDAO zipcodeDAO) {
		this.zipcodeDAO = zipcodeDAO;
	}
	
	public WeatherMapper getWeatherMapper() {
		return weatherMapper;
	}

	public void setWeatherMapper(WeatherMapper weatherMapper) {
		this.weatherMapper = weatherMapper;
	}
	
	public WeatherReport getWeatherReportByZipCode(Integer zipcd)
	{
		zipcodeDAO.enableTodayDateFilter();
		Zipcode zipcodeEntity = zipcodeDAO.getByZipCode(zipcd);
		WeatherReport jaxbWeatherReport = weatherMapper.mapCurrentDayWeather(zipcodeEntity);
		zipcodeDAO.disableTodayDateFilter();
		
		/*
		 * Write another dao (WeatherDaysDao.java) on that write a method to get List<WeatherDay> 
		 * with where condition date field from today date +1 to 10 days. 
		 * Join WeatherDay with Zipcode.
		 */
		Calendar start = Calendar.getInstance();
		Calendar end = (Calendar)start.clone();
		start.add(Calendar.DATE, 1);
		end.add(Calendar.DATE, 10);
		
		log.info ("Start: "+start.getTime());
		log.info ("End : "+ end.getTime());
		
		List<WeatherDay> daysEntityList = zipcodeDAO.getNextTenDays(zipcd, start.getTime(), end.getTime());
		log.info("daysEntityList "+ daysEntityList.size());
		List<Day> jaxbDaysList = weatherMapper.mapDays(daysEntityList);
		jaxbWeatherReport.setDays( new Days());
		jaxbWeatherReport.getDays().getDay().addAll(jaxbDaysList );
		
		
		return jaxbWeatherReport;
	}
}
