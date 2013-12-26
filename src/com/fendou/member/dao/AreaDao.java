package com.fendou.member.dao;

import java.util.List;

import com.fendou.member.po.Area;


/**
 * T_Area
 * @author jacky
 * 
 */

public interface AreaDao {
	
	//ͨ��Id�õ����еĵ���
	public List<Area> selectArea(int areaID);
	
	//地区
	
}
