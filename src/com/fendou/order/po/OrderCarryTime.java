package com.fendou.order.po;

import java.io.Serializable;

public class OrderCarryTime implements Serializable{
	private int carryTimeID;//	提货时间ID	Int
	private String carryTimeContent;//	提货时间	Varchar(100)
	public int getCarryTimeID() {
		return carryTimeID;
	}
	public void setCarryTimeID(int carryTimeID) {
		this.carryTimeID = carryTimeID;
	}
	public String getCarryTimeContent() {
		return carryTimeContent;
	}
	public void setCarryTimeContent(String carryTimeContent) {
		this.carryTimeContent = carryTimeContent;
	}
	
}
