package com.myweather.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterJoinTable;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.ParamDef;

import com.myweather.dao.ZipcodeDAO;

@Entity
@Table(name = "zipcode")
@FilterDef(name="currentDayFilter", 
parameters=@ParamDef( name="currentDayFilterParam", type="date" ) )
public class Zipcode implements java.io.Serializable {

	private static final long serialVersionUID = 44565656565656L;
	
	private int zipId;
	private Integer zipcode;
	private City city;
	private List<WeatherDay> weatherDays;
	
	@Id
	@Column(name = "zipcode_id", unique = true, nullable = false)
	public int getZipId() {
		return zipId;
	}
	public void setZipId(int zipId) {
		this.zipId = zipId;
	}
	
	@Column(name = "zipcode", unique = true, nullable = false)
	public Integer getZipcode() {
		return zipcode;
	}
	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	@NotFound(action = NotFoundAction.IGNORE)
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}

	@OneToMany(fetch=javax.persistence.FetchType.LAZY, mappedBy="zipcodeHidden")
	@Filter(
			name = "currentDayFilter",
			condition="date = :currentDayFilterParam"
		)
	public List<WeatherDay> getWeatherDays() {
		return weatherDays;
	}
	public void setWeatherDays(List<WeatherDay> weatherDays) {
		this.weatherDays = weatherDays;
	}
	
}
	