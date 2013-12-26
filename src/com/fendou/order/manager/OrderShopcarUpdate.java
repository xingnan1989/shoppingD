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
import com.fendou.order.po.Goods;
import com.fendou.order.po.ShopCarAdd;

public class OrderShopcarUpdate extends HttpServlet {

	public OrderShopcarUpdate() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		ShopCarAdd sca=null;
		String goodsID_str=request.getParameter("goodsID");
		int goodsID=Integer.parseInt(goodsID_str);
		
		int num=Integer.parseInt(request.getParameter("num"));
			//设置购物车属性范围，修改购物车
		ArrayList car=(ArrayList)session.getAttribute("car");
		for(int i=0;i<car.size();i++){
			sca=(ShopCarAdd)car.get(i);
			if(sca.getGoods().getGoodsID() == goodsID){
				sca.setNum(num);
				session.setAttribute("car", car);
				break;
			}
		}
		ArrayList car2=(ArrayList)session.getAttribute("car");
		double goodsNormalPrice=0;  //市场价
		double goodsMemberPrice=0;  //会员价
		double countgoodsNormalPrice=0;
		double countgoodsMemberPrice=0;
		for(int i=0;i<car2.size();i++){
			sca=(ShopCarAdd)car2.get(i);
			num=sca.getNum();
			goodsNormalPrice=sca.getGoods().getGoodsNormalPrice();
			goodsMemberPrice=sca.getGoods().getGoodsMemberPrice();
			countgoodsNormalPrice+=goodsNormalPrice*num;
			countgoodsMemberPrice+=goodsMemberPrice*num;
		}
		session.setAttribute("countgoodsNormalPrice", countgoodsNormalPrice);
		session.setAttribute("countgoodsMemberPrice", countgoodsMemberPrice);
		String str=countgoodsNormalPrice+"|"+countgoodsMemberPrice+"|"+"修改成功！";
		out.print(str);
		
		
		out.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
