package com.fendou.order.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderShopcarDrop extends HttpServlet {
	public OrderShopcarDrop() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		session.setAttribute("car",null);
		session.setAttribute("countgoodsNormalPrice",0);
		session.setAttribute("countgoodsMemberPrice", 0);
		request.getRequestDispatcher("/WEB-INF/show/cart_add.jsp").forward(request,response);
		
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
