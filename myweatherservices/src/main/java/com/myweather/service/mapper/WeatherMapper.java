package com.myweather.service.mapper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.myweather.jaxb.content.*;
import com.myweather.model.*;

public class WeatherMapper {
	private static Logger log = Logger.getLogger(WeatherMapper.class);
	private static final String imagePrefix = "http://localhost:8080/myweather/service/images/";
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	public WeatherReport mapCurrentDayWeather(Zipcode zipEntity)
	{	log.info("Enter mapWeather");
		WeatherReport jaxbReport = new WeatherReport();
		jaxbReport.setZipcode(zipEntity.getZipcode());
		
		if (zipEntity.getWeatherDays() != null && zipEntity.getWeatherDays().size() > 0)
		{
			WeatherDay weatherDayEntity = zipEntity.getWeatherDays().get(0);
			jaxbReport.setMaxTemp( weatherDayEntity.getMaxtemp() );
			jaxbReport.setMinTemp( weatherDayEntity.getMintemp() );
			jaxbReport.setDescription(weatherDayEntity.getDescription());
			jaxbReport.setCityName(zipEntity.getCity().getName());
			jaxbReport.setState(zipEntity.getCity().getState().getName());
			jaxbReport.setImageURL(imagePrefix+ weatherDayEntity.getImage().getImgPath()+"/"+ weatherDayEntity.getImage().getImgName());
			jaxbReport.setDetails( mapDayDetails( weatherDayEntity.getWeatherDetails()));
			jaxbReport.setForecast(mapHourly( weatherDayEntity.getWeatherHourly()));
		}
		log.info("Exit mapWeather");
		return jaxbReport;
	}

	
	public List<Day> mapDays( List<WeatherDay> daysEnityList)
	{
		List<Day> dayList = new ArrayList<Day>();
		for (WeatherDay wDay: daysEnityList)
		{
			Day jaxbDay = new Day();
			jaxbDay.setDate( formatter.format(wDay.getDate()));
			jaxbDay.setMinTemp( wDay.getMintemp().toString());
			jaxbDay.setMaxTemp(wDay.getMaxtemp().toString());
			jaxbDay.setImageURL(imagePrefix+wDay.getImage().getImgPath()+"/"+wDay.getImage().getImgName());
			dayList.add(jaxbDay);
		}
		
		return dayList;
	}
	
	private Details mapDayDetails(Set<WeatherDetail> wDetailSet)
	{
		Details jaxbDetails = new Details();
		for (WeatherDetail wDetail : wDetailSet)
		{
			Detail jaxbDetail = new Detail();
			jaxbDetail.setDescription( wDetail.getDetailConstant().getName()+" "+ wDetail.getDetails());
			jaxbDetails.getDetail().add(jaxbDetail);
		}
		return jaxbDetails;
	}
	
	public Forecast mapHourly( Set<WeatherHourly> wHourlySet)
	{	Forecast forecast = new Forecast();
	
		for (WeatherHourly hourly :wHourlySet){
			Hourly hrly = new Hourly();
			hrly.setTemp( hourly.getTemperature().toString());
			hrly.setTime( hourly.getTime());
			hrly.setImageURL( imagePrefix+hourly.getImage().getImgPath()+"/"+hourly.getImage().getImgName());
			forecast.getHourly().add(hrly);
		}
		return forecast;
	}
}
