package com.fendou.member.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fendou.factory.DaoFactory;
import com.fendou.member.impl.AreaDaoImpl;
import com.fendou.member.po.Area;



public class ResponseArea extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setHeader("Cache-Control", "no-cache");
		StringBuffer responsearea = new StringBuffer();
		int cityId=Integer.parseInt(request.getParameter("cityId"));
		
		AreaDaoImpl areaDaoImpl = (AreaDaoImpl)DaoFactory.getfactory().getDaoImpl("areaDaoImpl");
		List<Area>areaList=new ArrayList<Area>();
		try {
			areaList = areaDaoImpl.selectArea(cityId);
		} catch (Exception e) {
		}
		
		responsearea.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		responsearea.append("<response>");
		if(cityId==0){
			responsearea.append("<areaid>"+"0"+"</areaid>");
			responsearea.append("<areaname>"+"请选择"+"</areaname>");
		}else{
			if(areaList.size()>0&&areaList!=null)
			{
				for (int i = 0; i < areaList.size(); i++) {
					Area area = (Area) areaList.get(i);
					
					responsearea.append("<areaid>" + area.getAreaID()+ "</areaid>");
					responsearea.append("<areaname>"+area.getArea()+"</areaname>");
			
				}
			}else{
				responsearea.append("<typeid>"+"数据库中没有地区(加载失败)"+"<typeid>");
			}
		}

		responsearea.append("</response>");
		out.println(responsearea);
		out.flush();
		out.close();

	}

}
