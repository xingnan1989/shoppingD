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
import com.fendou.order.po.OrderCarryMode;

public class OrderCarryModeUpdate extends HttpServlet {
	public OrderCarryModeUpdate() {
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
		DaoFactory df=(DaoFactory)DaoFactory.getfactory();
		OrderDao od=(OrderDao)df.getDaoImpl("orderdaoimpl");
		ArrayList<OrderCarryMode> alocm=(ArrayList)od.selectOrderCarryMode();
		OrderCarryMode ocm=null;
		String str="0,请选择|";
		for(int i=0;i<alocm.size();i++){
			ocm=alocm.get(i);
			str+=ocm.getCarryID()+","+ocm.getCarryContent()+"|";
		}
		out.print(str);
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
