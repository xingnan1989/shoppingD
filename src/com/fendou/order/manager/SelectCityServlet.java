package com.fendou.order.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fendou.factory.DaoFactory;
import com.fendou.order.dao.OrderDao;
import com.fendou.order.po.City;

public class SelectCityServlet extends HttpServlet {

	public SelectCityServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String provinceCode=request.getParameter("provinceCode");
		DaoFactory df=DaoFactory.getfactory();
		OrderDao od=(OrderDao)df.getDaoImpl("orderdaoimpl");
		
		//根据provinceCode获得provinceID
		int provinceID=od.selectProvinceIDtoCode(provinceCode);			
		
		City c=new City();
		//System.out.println("servlet  OK");
		//sSystem.out.println(provinceID);
		if(!provinceCode.equals("0")){
			ArrayList<City> cal=od.selectCity(provinceID);
			String cstr="";
			for(int i=0;i<cal.size();i++){
				
				cstr+="|"+cal.get(i).getCityCode()+","+cal.get(i).getCity();
			}
			out.print(cstr);
			//System.out.println("servlet :"+cstr);
			request.setAttribute("cal",cal);
		}
		
		//request.getRequestDispatcher("").forward(request,response);
		out.close();
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
