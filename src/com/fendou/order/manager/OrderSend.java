package com.fendou.order.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fendou.factory.DaoFactory;
import com.fendou.order.dao.OrderDao;
import com.fendou.order.po.Order;

public class OrderSend extends HttpServlet {

	public OrderSend() {
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
		long orderID=Long.parseLong(request.getParameter("orderID"));
		//送货
		DaoFactory df=DaoFactory.getfactory();
		OrderDao od=(OrderDao)df.getDaoImpl("orderdaoimpl");
		Order order=od.selectOrder2(orderID);
		//System.out.println("orderID:"+orderID);
		//System.out.println("OrderStatus:"+order.getOrderStatus());
		//out.print("11!");
		if(order.getOrderStatus().equals("Y")){
			//System.out.print("Y");
			request.getRequestDispatcher("OrderOrderAndDetatlSelect").forward(request, response);
		}else{
			request.getRequestDispatcher("RevertGoodsNumber?orderID="+orderID).forward(request, response);
		}
		out.close();
		
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
