/*会员地址表
 * 此表用于存放会员地址信息*/
package com.fendou.member.po;

import java.util.Date;

public class MemberAddressBook {

	private long id;
	private long memberID;
	private String memberTrueName;
	private String memberAddress;
	private String provinceCode;
	private String cityCode;
	private String areaCode;
	private String memberPostcode;
	private String memberTelephone;
	private Date createDate;
	private Date updateDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	
}
