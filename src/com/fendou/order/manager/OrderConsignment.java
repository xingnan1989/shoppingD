package com.fendou.order.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fendou.factory.DaoFactory;
import com.fendou.order.dao.OrderDao;

public class OrderConsignment extends HttpServlet {

	
	public OrderConsignment() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		long orderID=Long.parseLong(request.getParameter("orderID"));
		DaoFactory df=DaoFactory.getfactory();
		OrderDao od=(OrderDao)df.getDaoImpl("orderdaoimpl");
		od.updateOrderStatus(orderID);
		request.getRequestDispatcher("OrderManager").forward(request, response);
		out.close();
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
