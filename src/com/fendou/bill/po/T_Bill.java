package com.fendou.bill.po;

public class T_Bill {
	private int billId;//广告ID
	private int billCode;//广告编号
	private String billPicPath;//广告图片上传路径
	private String billAddTime;//广告添加时间
	private int billOrder;//广告排序
	private String billStatus;//广告状态
	private String billCreateUser;//广告创建人
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public String getBillPicPath() {
		return billPicPath;
	}
	public void setBillPicPath(String billPicPath) {
		this.billPicPath = billPicPath;
	}
	public String getBillAddTime() {
		return billAddTime;
	}
	public void setBillAddTime(String billAddTime) {
		this.billAddTime = billAddTime;
	}
	public int getBillOrder() {
		return billOrder;
	}
	public void setBillOrder(int billOrder) {
		this.billOrder = billOrder;
	}
	public String getBillStatus() {
		return billStatus;
	}
	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}
	public String getBillCreateUser() {
		return billCreateUser;
	}
	public void setBillCreateUser(String billCreateUser) {
		this.billCreateUser = billCreateUser;
	}
	public int getBillCode() {
		return billCode;
	}
	public void setBillCode(int billCode) {
		this.billCode = billCode;
	}
}
