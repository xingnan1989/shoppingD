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
import com.fendou.member.impl.CityDaoImpl;
import com.fendou.member.po.City;


public class ResponseCity extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
     doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setHeader("Cache-Control", "no-cache");
		StringBuffer responsecity = new StringBuffer();
		
		int provinceId=Integer.parseInt(request.getParameter("provinceId"));
		
		CityDaoImpl cityDaoImpl = (CityDaoImpl)DaoFactory.getfactory().getDaoImpl("cityDaoImpl");
		List<City> cityList=new ArrayList<City>();
		try {
			cityList = cityDaoImpl.selectCity(provinceId);
		} catch (Exception e) {
		}
		
		responsecity.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		responsecity.append("<response>");
		if(provinceId == 0){
			responsecity.append("<cityid>"+"0"+"</cityid>");
			responsecity.append("<cityname>"+"请选择"+"</cityname>");
		}else{
			if(cityList.size()>0&&cityList!=null)
			{
				for (int i = 0; i < cityList.size(); i++) {
					City city = (City) cityList.get(i);
					responsecity.append("<cityid>" + city.getCityID()+ "</cityid>");
					responsecity.append("<cityname>"+city.getCity()+"</cityname>");
			
				}
			}else{
				responsecity.append("<typeid>"+"数据库中没有对应城市(加载失败)"+"<typeid>");
			}
		}
		
		responsecity.append("</response>");
		out.println(responsecity);
		out.flush();
		out.close();
   
	}

}
