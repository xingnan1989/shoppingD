package com.fendou.member.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fendou.member.dao.ProvinceDao;
import com.fendou.member.po.AreaList;
import com.fendou.member.po.Province;
import com.fendou.system.db.Database;

public class ProvinceDaoImpl implements ProvinceDao {
	Database db = new Database();
	ResultSet rs = null;

	//�����ݿ��е�����ʡ�ݣ�����Ҳû����ʡ�ݣ�
	public List<Province> selectProvince() {
		List<Province> provinceList = new ArrayList<Province>();
		String sql = "select * from T_Province";
		rs = db.getexecuteR_Ps(sql);
		try {
			while (rs.next()) {
				Province province = new Province();
				province.setProvinceID(rs.getInt("'ProvinceID'"));
				province.setProvinceCode(rs.getString("'ProvinceCode'"));
				province.setProvince(rs.getString("'Province'"));
				provinceList.add(province);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return provinceList;
	}

	/**
	 * 获得地区的级联列表
	 */
	public AreaList getAreaList(String provinceCode,String cityID,String areaID){
		AreaList areaList = new AreaList();
		ResultSet rs1,rs2;
		String sql = "select Province from T_Province where ProvinceCode='" +provinceCode+"'";
		String sql1 = "select City from T_City where CityID='" + cityID+"'";
		String sql2 = "select Area from T_Area where AreaID='"+areaID+"'";
		rs = db.getexecuteR_Ps(sql);
		rs1 = db.getexecuteR_Ps(sql1);
		rs2 = db.getexecuteR_Ps(sql2);
		try {
			if(rs.next()) {
				areaList.setProvinceName(rs.getString("Province"));
			}
			if(rs1.next()) {
				areaList.setCityName(rs1.getString("City"));
			}
			if(rs2.next()) {
				areaList.setAreaName(rs2.getString("Area"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return areaList;

	}
}
