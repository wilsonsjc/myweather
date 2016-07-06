package com.myweather.model;

import java.sql.Date;

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
@Table(name = "weather_hourly")
public class WeatherHourly implements java.io.Serializable {

	private static final long serialVersionUID = 6107378305627362L;
	
	private Integer id;
	private WeatherDay weatherDayHourlyHidden;
	private Integer temperature;
	private String time;
	private Date date;
	private Image image;
	private String description;
	private Integer order;
	
	@Id
	@Column(name = "weather_hourly_id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "temp", unique = false, nullable = true)
	public Integer getTemperature() {
		return temperature;
	}
	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}
	@Column(name = "time", unique = false, nullable = true)
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Column(name = "date", unique = false, nullable = true)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "image_id")
	@NotFound(action = NotFoundAction.IGNORE)	
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	@Column(name = "description", unique = false, nullable = true)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name = "order_number", unique = false, nullable = true)
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "weather_day_id")
	@NotFound(action = NotFoundAction.IGNORE)	
	public WeatherDay getWeatherDayHourlyHidden() {
		return weatherDayHourlyHidden;
	}
	public void setWeatherDayHourlyHidden(WeatherDay weatherDayHourlyHidden) {
		this.weatherDayHourlyHidden = weatherDayHourlyHidden;
	}
	
	

}
