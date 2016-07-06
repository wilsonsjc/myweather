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
@Table(name = "city")
public class City implements java.io.Serializable {
	
	private static final long serialVersionUID = 3392983427384237L;
	
	private Integer cityId;
	private String name;
	private State state;
	private Zipcode zipcode;
	
	@Id
	@Column(name = "city_id", unique = true, nullable = false)
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	@Column(name = "name", unique = true, nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_id")
	@NotFound(action = NotFoundAction.IGNORE)	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "zipcode_id")
	@NotFound(action = NotFoundAction.IGNORE)	
	public Zipcode getZipcode() {
		return zipcode;
	}
	public void setZipcode(Zipcode zipcode) {
		this.zipcode = zipcode;
	}
	
	
	

}
