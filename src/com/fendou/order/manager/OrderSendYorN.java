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

public class OrderSendYorN extends HttpServlet {

	public OrderSendYorN() {
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
		//是否能取消订单
		DaoFactory df=DaoFactory.getfactory();
		OrderDao od=(OrderDao)df.getDaoImpl("orderdaoimpl");
		Order order=od.selectOrder2(orderID);
		if(order.getOrderStatus().equals("Y")){
			out.print("对不起，商品已经发货，取消失败！");
			
		}else{
			out.print("取消成功");
		}
		out.close();
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
