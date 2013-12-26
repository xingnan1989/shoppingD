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
import com.fendou.order.po.OrderCarryTime;
import com.fendou.order.po.OrderDetail;

public class OrderDetailShow2 extends HttpServlet {

	
	public OrderDetailShow2() {
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
		//System.out.println(orderID);
		DaoFactory df=DaoFactory.getfactory();
		OrderDao od=(OrderDao)df.getDaoImpl("orderdaoimpl");
		Order o=od.selectOrder2(orderID);//该订单详情
		if(o.getOrderInvoice().equals("Y")){
			o.setOrderInvoice("要");
		}else{
			o.setOrderInvoice("不要");
		}
		//订单送货地址
		String provinceCode=o.getMemberProvince();
		String cityCode=o.getMemberCity();
		String areaCode=o.getMemberArea();
		String province=od.selectProvinceCode(provinceCode);
		String city=od.selectCityCode(cityCode);
		String area=od.selectAreaCode(areaCode);
		//System.out.println("province:"+province+"  city"+city+"  area"+area);
		o.setMemberProvince(province);
		o.setMemberCity(city);
		o.setMemberArea(area);
		
		request.setAttribute("order2", o);
		ArrayList<OrderDetail> odlal=od.selectOrderDetail(orderID);//查询明细
		/*
		OrderDetail odtl=null;
		for(int i=0;i<odlal.size();i++){
			odtl=odlal.get(i);
			System.out.println(odtl.getGoodsName());
		}*/
		request.setAttribute("odarray", odlal);
		OrderCarryTime oct=od.selectOrderCarryTimeToID(o.getOrderCarryTime());//提货时间
		request.setAttribute("oct2", oct);
		//System.out.println("OK");
		request.getRequestDispatcher("/WEB-INF/manager/order_detail.jsp").forward(request, response);
		out.close();
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
