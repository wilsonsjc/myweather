package com.myweather.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
@Table(name = "weather_day")
public class WeatherDay implements java.io.Serializable {

	
	private static final long serialVersionUID = 6867868675L;
	
	private Integer id;
	private Integer mintemp;
	private Integer maxtemp;
	private Image image;
	private Zipcode zipcodeHidden;
	private Date date;
	private String description;
	private Set<WeatherDetail> weatherDetails;
	private Set<WeatherHourly> weatherHourly;
	
	
	@Id
	@Column(name = "weather_day_id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "min_temp", unique = false, nullable = false)
	public Integer getMintemp() {
		return mintemp;
	}
	public void setMintemp(Integer mintemp) {
		this.mintemp = mintemp;
	}
	
	@Column(name = "max_temp", unique = false, nullable = false)
	public Integer getMaxtemp() {
		return maxtemp;
	}
	public void setMaxtemp(Integer maxtemp) {
		this.maxtemp = maxtemp;
	}

	@Column(name = "date", unique = false, nullable = false)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "zipcode_id", insertable=false, updatable=false, nullable=true)
	@NotFound(action = NotFoundAction.IGNORE)		
	public Zipcode getZipcodeHidden() {
		return zipcodeHidden;
	}
	public void setZipcodeHidden(Zipcode zipcodeHidden) {
		this.zipcodeHidden = zipcodeHidden;
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
	@Column(name = "description", unique = false, nullable = false)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="weatherDayHidden")
	public Set<WeatherDetail> getWeatherDetails() {
		return weatherDetails;
	}
	public void setWeatherDetails(Set<WeatherDetail> weatherDetails) {
		this.weatherDetails = weatherDetails;
	}
	@OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="weatherDayHourlyHidden")
	public Set<WeatherHourly> getWeatherHourly() {
		return weatherHourly;
	}
	public void setWeatherHourly(Set<WeatherHourly> weatherHourly) {
		this.weatherHourly = weatherHourly;
	}
	
	
}
