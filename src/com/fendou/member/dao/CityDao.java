package com.fendou.member.dao;

import java.util.List;

import com.fendou.member.po.City;



/**
 * 数据库T_City
 * 
 * @author hzp
 * 
 */

public interface CityDao {
	
	// 城市
	public List<City> selectCity(int cityId);
	
	
}
