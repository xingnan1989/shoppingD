/*城市表
 * 此表用于存放会员所在城市*/
package com.fendou.member.po;

public class City {
	private int cityID;
	private int provinceID;
	private String cityCode;
	private String city;
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
