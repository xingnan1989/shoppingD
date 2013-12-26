package com.fendou.member.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fendou.member.dao.AreaDao;
import com.fendou.member.po.Area;
import com.fendou.system.db.Database;


/**
 * 地区设置
 * 
 * @author hzp
 * 
 */

public class AreaDaoImpl implements AreaDao {
	Database db = new Database();
	ResultSet rs = null;
	public List<Area> selectArea(int areaID){
		List<Area> areaList = new ArrayList<Area>();
		String sql = "select * from T_Area where CityID="+areaID;
		rs = db.getexecuteR_Ps(sql);
		try {
			while (rs.next()) {
				Area area = new Area();
				area.setAreaID(rs.getInt("AreaID"));
				area.setCityID(rs.getInt("CityID"));
				area.setAreaCode(rs.getString("AreaCode"));
				area.setArea(rs.getString("Area"));
				areaList.add(area);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return areaList;
	}
	
}
