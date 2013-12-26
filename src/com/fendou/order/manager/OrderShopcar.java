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
import com.fendou.order.impl.OrderDaoImpl;
import com.fendou.order.po.*;
import com.fendou.util.*;
public class OrderShopcar extends HttpServlet {

	
	public OrderShopcar() {
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

		//response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		String goodsID=request.getParameter("goodsID");
		ArrayList car=(ArrayList)session.getAttribute("car");
		AddcarArrayList aal=new AddcarArrayList();
		aal.setCar(car);
		//订单购物车
		
		DaoFactory df=DaoFactory.getfactory();
		String key="orderdaoimpl";
		OrderDao od=(OrderDao)df.getDaoImpl(key);
		Goods goods=(Goods)od.selectGoods_goodsId(goodsID);
		//System.out.println("购买商品数量:"+goods.getBuyCount());
		//System.out.println(goods.getGoodsName());
		int num=1;
		//添加商品数量
		aal.addcar(goods, num);
		//System.out.println("aal.getCar():"+aal.getCar());
		session.setAttribute("car", aal.getCar());
		
		//放入购物车
		ArrayList car2=(ArrayList)session.getAttribute("car");
		ShopCarAdd sca=null;
		int num2=0;
		double goodsNormalPrice=0;  //定义市场价
		double goodsMemberPrice=0;  //定义会员价
		double countgoodsNormalPrice=0.0;
		double countgoodsMemberPrice=0.0;
		//计算总价格
		//int[] c=
			for(int i=0;i<car2.size();i++){
				sca=(ShopCarAdd)car2.get(i);
				num2=sca.getNum();
				goodsNormalPrice=sca.getGoods().getGoodsNormalPrice();
				goodsMemberPrice=sca.getGoods().getGoodsMemberPrice();
				countgoodsNormalPrice+=goodsNormalPrice*num2;
				countgoodsMemberPrice+=goodsMemberPrice*num2;
			}
			//request.setAttribute("countgoodsNormalPrice", countgoodsNormalPrice);
			//request.setAttribute("countgoodsMemberPrice", countgoodsMemberPrice);
			
		session.setAttribute("countgoodsNormalPrice", countgoodsNormalPrice);
		session.setAttribute("countgoodsMemberPrice", countgoodsMemberPrice);
		//session.setAttribute(arg0, arg1)	
		//
		//response.sendRedirect("OrderShopcarMoney");
		
		out.close();
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
