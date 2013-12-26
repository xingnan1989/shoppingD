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
import com.fendou.util.AddcarArrayList;

public class OrderShopcarMoney extends HttpServlet {

	public OrderShopcarMoney() {
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
		ArrayList car2=(ArrayList)session.getAttribute("car");
		ShopCarAdd sca=null;
		int num=0;
		double goodsNormalPrice=0;  //市场价格
		double goodsMemberPrice=0;  //商城价格
		double countgoodsNormalPrice=0.0;
		double countgoodsMemberPrice=0.0;
		//int[] c=
		try{
			for(int i=0;i<car2.size();i++){
				sca=(ShopCarAdd)car2.get(i);
				num=sca.getNum();
				goodsNormalPrice=sca.getGoods().getGoodsNormalPrice();
				goodsMemberPrice=sca.getGoods().getGoodsMemberPrice();
				countgoodsNormalPrice+=goodsNormalPrice*num;
				countgoodsMemberPrice+=goodsMemberPrice*num;
			}
			//request.setAttribute("countgoodsNormalPrice", countgoodsNormalPrice);
			//request.setAttribute("countgoodsMemberPrice", countgoodsMemberPrice);
			
			session.setAttribute("countgoodsNormalPrice", countgoodsNormalPrice);
			session.setAttribute("countgoodsMemberPrice", countgoodsMemberPrice);
			request.getRequestDispatcher("OrderShopcarPagination").forward(request,response);
			
			
		}catch(NullPointerException e){
			out.println("OrderShopcarMoney空指针异常");
			//session.setAttribute("countgoodsNormalPrice", countgoodsNormalPrice);
			//session.setAttribute("countgoodsMemberPrice", countgoodsMemberPrice);
			//request.getRequestDispatcher("/WEB-INF/show/cart_add.jsp").forward(request,response);
		}finally{
			out.close();
		}
		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
