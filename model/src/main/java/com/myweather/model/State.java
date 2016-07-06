package com.myweather.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "state")
public class State implements java.io.Serializable {
	
	private static final long serialVersionUID = 274246532923746234L;
	
	private Integer stateId;
	private String code;
	private String name;
	
	@Id
	@Column(name = "state_id", unique = true, nullable = false)
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	
	@Column(name = "state_cd", unique = true, nullable = false)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name = "name", unique = false, nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
