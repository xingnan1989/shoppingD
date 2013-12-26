package com.fendou.order.po;

import java.io.Serializable;

//�����
public class Area implements Serializable{
	private int areaID;//	地区ID	int
	private int cityID;//	城市ID	int
	private String areaCode;//	地区代号	Varchar(6)
	private String area;//	地区名称	Varchar(50)
	public int getAreaID() {
		return areaID;
	}
	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}
	public int getCityID() {
		return cityID;
	}
	public void setCityID(int cityID) {
		this.cityID = cityID;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
}
