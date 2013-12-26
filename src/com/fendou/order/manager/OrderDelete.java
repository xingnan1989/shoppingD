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
import com.fendou.order.po.Order;
import com.fendou.order.po.OrderDetail;
import com.fendou.order.po.OrderDetailArrayOrder;

public class OrderDelete extends HttpServlet {

	
	public OrderDelete() {
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
		HttpSession session = request.getSession();
		long orderID=Integer.parseInt(request.getParameter("orderID"));
		//System.out.println(request.getParameter("orderID:"+"orderID"));
		DaoFactory df=DaoFactory.getfactory();
		OrderDao od=(OrderDao)df.getDaoImpl("orderdaoimpl");
		//查找订单
		Order o=od.selectOrder2(orderID);
		String orderInvoice=o.getOrderInvoice();
		//System.out.println(orderInvoice);
		//删除订单
		od.deleteOrder(orderID,orderInvoice);
		///////////////////////
		
		//定义一个Order的ArrayList<OrderDetail>列表
		ArrayList<OrderDetailArrayOrder> ooal=new ArrayList();
		
		//获得该用户的订单
		//System.out.println("memberID:"+session.getAttribute("memberID"));
		long memberID=(Long)session.getAttribute("memberID");
		ArrayList<Order> orderal=od.selectOrder(memberID);
		session.setAttribute("orderal",orderal);
		
		//订单列表
		Order order2=null;
		long orderID2=0;
		OrderDetailArrayOrder odArrayo=null;
		for(int i=0;i<orderal.size();i++){
			order2=orderal.get(i);
			orderID2=order2.getOrderID();
			//显示订单详情
			ArrayList<OrderDetail> odal=od.selectOrderDetail(orderID2);
			OrderDetail odd=null;
			//System.out.println(i+"/orderID:"+orderID);
			//System.out.println("商品种类"+odal.size());
			for(int j=0;j<odal.size();j++){
				odd=odal.get(j);
				//System.out.println("GoodsName:"+odd.getGoodsName());
			}
			odArrayo=new OrderDetailArrayOrder();
			odArrayo.setOrder(order2);
			odArrayo.setOdal(odal);
			ooal.add(odArrayo);	
		}
		session.setAttribute("ooal", ooal);
		//out.print("N");
		request.getRequestDispatcher("OrderOrderAndDetatlSelect").forward(request, response);
		out.close();
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
