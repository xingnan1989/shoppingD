package com.fendou.member.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fendou.member.dao.CityDao;
import com.fendou.member.po.City;
import com.fendou.system.db.Database;

/**
 * 获得所有的城市集合
 * 
 * @author hzp
 * 
 */

public class CityDaoImpl implements CityDao {

	Database db = new Database();
	ResultSet rs = null;

	public List<City> selectCity(int cityId) {
		List<City> cityList = new ArrayList<City>();
		String sql = "select * from T_City where ProvinceID=" + cityId;
		rs = db.getexecuteR_Ps(sql);
		try {
			while (rs.next()) {
				City city = new City();
				city.setCityID(rs.getInt("CityID"));
				city.setProvinceID(rs.getInt("ProvinceID"));
				city.setCityCode(rs.getString("CityCode"));
				city.setCity(rs.getString("City"));
				cityList.add(city);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cityList;

	}

}
