package com.fendou.order.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fendou.order.po.ShopCarAdd;
import com.fendou.pagination.po.Pagination;

public class OrderShopcarDelete extends HttpServlet {

	public OrderShopcarDelete() {
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
		int goodsID=Integer.parseInt(request.getParameter("goodsID"));
		//System.out.println(goodsID);
		HttpSession session=request.getSession();
		ArrayList car=(ArrayList)session.getAttribute("car");
		for(int i=0;i<car.size();i++){
			ShopCarAdd sca=(ShopCarAdd)car.get(i);
			if(sca.getGoods().getGoodsID() == goodsID){
				car.remove(i);
				break;
			}
		}
		session.setAttribute("car", car);
		request.getRequestDispatcher("OrderShopcarMoney").forward(request, response);
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
