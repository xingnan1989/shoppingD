package com.fendou.order.po;

import java.io.Serializable;

//省份
public class Province implements Serializable{
	private int provinceID;//	省份ID	int
	private String provinceCode;//	省份编号	Varchar(2)
	private String province;//	身份名称	Varchar(20)
	public int getProvinceID() {
		return provinceID;
	}
	public void setProvinceID(int provinceID) {
		this.provinceID = provinceID;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
	
}
