package com.fendou.order.po;

import java.io.Serializable;

public class OrderCarryMode implements Serializable{
	private int carryID;//	取货方式ID	int
	private String carryContent;//	取货方式内容	varchar(50)
	private int carryDay;//	时间	int
	private String carryDesc;//	描述	varchar(150)
	public int getCarryID() {
		return carryID;
	}
	public void setCarryID(int carryID) {
		this.carryID = carryID;
	}
	public String getCarryContent() {
		return carryContent;
	}
	public void setCarryContent(String carryContent) {
		this.carryContent = carryContent;
	}
	public int getCarryDay() {
		return carryDay;
	}
	public void setCarryDay(int carryDay) {
		this.carryDay = carryDay;
	}
	public String getCarryDesc() {
		return carryDesc;
	}
	public void setCarryDesc(String carryDesc) {
		this.carryDesc = carryDesc;
	}
	
}
