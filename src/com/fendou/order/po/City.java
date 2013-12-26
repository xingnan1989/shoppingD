package com.fendou.order.po;

import java.io.Serializable;

//城市类
public class City implements Serializable{
	private int cityID;//	城市ID	int
	private int provinceID;//	省份ID	int
	private String cityCode;//	城市代号	Varchar(6)
	private String city;//	城市名称	Varchar(20)
	public int getCityID() {
		return cityID;
	}
	public void setCityID(int cityID) {
		this.cityID = cityID;
	}
	public int getProvinceID() {
		return provinceID;
	}
	public void setProvinceID(int provinceID) {
		this.provinceID = provinceID;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	
}
