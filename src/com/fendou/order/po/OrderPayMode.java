package com.fendou.order.po;

import java.io.Serializable;

public class OrderPayMode implements Serializable{
	private int payID;
	private String payContent;
	private String payDesc;
	public int getPayID() {
		return payID;
	}
	public void setPayID(int payID) {
		this.payID = payID;
	}
	public String getPayContent() {
		return payContent;
	}
	public void setPayContent(String payContent) {
		this.payContent = payContent;
	}
	public String getPayDesc() {
		return payDesc;
	}
	public void setPayDesc(String payDesc) {
		this.payDesc = payDesc;
	}

}
