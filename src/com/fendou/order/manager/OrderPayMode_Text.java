package com.fendou.order.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fendou.factory.DaoFactory;
import com.fendou.order.dao.OrderDao;
import com.fendou.order.po.OrderPayMode;

public class OrderPayMode_Text extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 this.doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		/*
		int payID=Integer.parseInt(request.getParameter("payID"))+1;
		String payid=Integer.toString(payID);
		*/
		String payID=request.getParameter("payID");
		//System.out.println(payContent);
		DaoFactory df=DaoFactory.getfactory();
		OrderDao od=(OrderDao)df.getDaoImpl("orderdaoimpl");
		OrderPayMode opm=od.selectOrderPayMode_id(payID);
		session.setAttribute("opm", opm);//订单支付手段
		//System.out.println(opm.getPayID());
		String payContent=opm.getPayContent();
		out.print(payContent);
		out.close();
	}

}
