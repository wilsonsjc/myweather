package com.myweather.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detail_constant")
public class DetailConstant implements java.io.Serializable {
	
	private static final long serialVersionUID = 1452343243227L;
	private Integer constantId;
	private String name;
	
	@Id
	@Column(name = "detail_constant_id", unique = true, nullable = false)
	public Integer getConstantId() {
		return constantId;
	}
	public void setConstantId(Integer constantId) {
		this.constantId = constantId;
	}
	@Column(name = "name", unique = false, nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
