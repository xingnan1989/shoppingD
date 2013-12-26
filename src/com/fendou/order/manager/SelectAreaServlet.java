package com.fendou.order.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fendou.factory.DaoFactory;
import com.fendou.order.dao.OrderDao;
import com.fendou.order.po.Area;
import com.fendou.order.po.City;

public class SelectAreaServlet extends HttpServlet {

	public SelectAreaServlet() {
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
		HttpSession session=request.getSession();
		DaoFactory df=DaoFactory.getfactory();
		OrderDao od=(OrderDao)df.getDaoImpl("orderdaoimpl");
		String cityCode=request.getParameter("cityCode");
		//地区ID
		int cityID=od.selectCityIDtoCode(cityCode);
		Area a=new Area();
		//System.out.println(cityCode);
		if(!cityCode.equals("0")){
			ArrayList<Area> aal=od.selectArea(cityID);
			String cstr="";
			for(int i=0;i<aal.size();i++){
				
				cstr+="|"+aal.get(i).getAreaCode()+","+aal.get(i).getArea();
			}
			out.print(cstr);
			request.setAttribute("aal",aal);
		}
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
