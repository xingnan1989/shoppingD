/*地区表
 * 此表用于存放会员所在的详细地区*/
package com.fendou.member.po;

public class Area {
	private int areaID;
	private int cityID;
	private String areaCode;
	private String area;
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
