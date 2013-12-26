package com.fendou.order.po;

import java.io.Serializable;

public class MemberAddressBook implements Serializable{
	private int iD;
	private long memberID;
	private String memberTrueName;
	private String memberAddress;
	private String provinceCode;
	private String cityCode;
	private String areaCode;
	private String memberPostcode;
	private String memberTelephone;
	private String greateDate;
	private String updateDate;
	public int getID() {
		return iD;
	}
	public void setID(int id) {
		iD = id;
	}
	public long getMemberID() {
		return memberID;
	}
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
	public String getMemberTrueName() {
		return memberTrueName;
	}
	public void setMemberTrueName(String memberTrueName) {
		this.memberTrueName = memberTrueName;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
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
