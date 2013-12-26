package com.fendou.order.po;

import java.io.Serializable;

public class Order implements Serializable{
	private long orderID;//		订单ID	bigint
	private long memberID;//	用户ID	bigint
	private String memberTureName;//	用户真实姓名	Varchar(30)
	private String memberAddress;//		用户地址	Varchar(100)
	private String memberProvince;//	地址省份	Varchar(30)
	private String memberCity;//		地址城市	Varchar(30)
	private String memberArea;//		地址区域	Varchar(50)
	private String memberPostcode;//	邮编	Varchar(6)
	private String memberTelephone;//	电话Varchar(20)
	private double orderAmount;//		订单总额	money
	private String orderPay;//			支付方式	varchar(20)
	private String orderInvoice;//		发票	Char(1)
	private String orderCarry;//		取货情况	int
	private int orderCarryTime;//		取货时间	int
	private String orderRemark;//		取货标记Varchar(2000)
	private String orderStatus;//		提货状态	Char(1)
	private String greateDate;//		开始时间	datetime
	private String updateDate;//		修改时间
	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
	public long getMemberID() {
		return memberID;
	}
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
	public String getMemberTureName() {
		return memberTureName;
	}
	public void setMemberTureName(String memberTureName) {
		this.memberTureName = memberTureName;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public String getMemberProvince() {
		return memberProvince;
	}
	public void setMemberProvince(String memberProvince) {
		this.memberProvince = memberProvince;
	}
	public String getMemberCity() {
		return memberCity;
	}
	public void setMemberCity(String memberCity) {
		this.memberCity = memberCity;
	}
	public String getMemberArea() {
		return memberArea;
	}
	public void setMemberArea(String memberArea) {
		this.memberArea = memberArea;
	}
	public String getMemberPostcode() {
		return memberPostcode;
	}
	public void setMemberPostcode(String memberPostcode) {
		this.memberPostcode = memberPostcode;
	}
	public String getMemberTelephone() {
		return memberTelephone;
	}
	public void setMemberTelephone(String memberTelephone) {
		this.memberTelephone = memberTelephone;
	}
	public double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getOrderPay() {
		return orderPay;
	}
	public void setOrderPay(String orderPay) {
		this.orderPay = orderPay;
	}
	public String getOrderInvoice() {
		return orderInvoice;
	}
	public void setOrderInvoice(String orderInvoice) {
		this.orderInvoice = orderInvoice;
	}
	public String getOrderCarry() {
		return orderCarry;
	}
	public void setOrderCarry(String orderCarry) {
		this.orderCarry = orderCarry;
	}
	public int getOrderCarryTime() {
		return orderCarryTime;
	}
	public void setOrderCarryTime(int orderCarryTime) {
		this.orderCarryTime = orderCarryTime;
	}
	public String getOrderRemark() {
		return orderRemark;
	}
	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getGreateDate() {
		return greateDate;
	}
	public void setGreateDate(String greateDate) {
		this.greateDate = greateDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
}
