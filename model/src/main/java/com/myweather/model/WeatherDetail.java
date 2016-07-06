package com.myweather.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
@Table(name = "weather_detail")
public class WeatherDetail implements java.io.Serializable {

	
	private static final long serialVersionUID = 68678686676775L;
	
	private Integer id;
	private WeatherDay weatherDayHidden;
	private DetailConstant detailConstant;
	private String details;

	
	@Id
	@Column(name = "weather_detail_id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "detail_constant_id")
	@NotFound(action = NotFoundAction.IGNORE)
	public DetailConstant getDetailConstant() {
		return detailConstant;
	}
	public void setDetailConstant(DetailConstant detailConstant) {
		this.detailConstant = detailConstant;
	}
	@Column(name = "detail", unique = false, nullable = true)
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "weather_day_id")
	@NotFound(action = NotFoundAction.IGNORE)	
	public WeatherDay getWeatherDayHidden() {
		return weatherDayHidden;
	}
	public void setWeatherDayHidden(WeatherDay weatherDayHidden) {
		this.weatherDayHidden = weatherDayHidden;
	}
	
	
	
}
