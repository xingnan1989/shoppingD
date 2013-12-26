package com.fendou.member.dao;

import java.util.List;

import com.fendou.member.po.AreaList;
import com.fendou.member.po.Province;

public interface ProvinceDao {

	// 数据库T_province
	public List<Province> selectProvince();
	
	//省份
	public AreaList getAreaList(String provinceCode,String cityID,String areaID);
}
