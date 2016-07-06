package com.myweather.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "image")
public class Image implements java.io.Serializable {

	private static final long serialVersionUID = 5458998989898L;
	
	private int imgId;
	private String imgName;
	private String imgPath;
	
	@Id
	@Column(name = "image_id", unique = true, nullable = false)
	public int getImgId() {
		return imgId;
	}
	public void setImgId(int imgId) {
		this.imgId = imgId;
	}
	
	@Column(name = "name", unique = true, nullable = true)
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	@Column(name = "path", unique = true, nullable = true)
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

}
