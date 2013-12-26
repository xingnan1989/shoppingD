package com.fendou.order.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fendou.factory.DaoFactory;
import com.fendou.order.dao.OrderDao;
import com.fendou.order.po.Goods;
import com.fendou.order.po.OrderDetail;

public class RevertGoodsNumber extends HttpServlet {

	
	public RevertGoodsNumber() {
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
		long orderID=Integer.parseInt(request.getParameter("orderID"));
		//System.out.println(request.getParameter("orderID:"+"orderID"));
		DaoFactory df=DaoFactory.getfactory();
		OrderDao od=(OrderDao)df.getDaoImpl("orderdaoimpl");
		//订单详情——后台管理
		//1.统计商品数量
		ArrayList<OrderDetail> odal=od.selectOrderDetail(orderID);
		OrderDetail odl=null;
		long goodsID=0;
		int goodsCount=0;//当前被买的商品数量
		Goods goods=null;
		int goodsnumber=0;//剩余商品数量
		int buyGoodsNumber=0;//被卖出商品商量
		for(int i=0;i<odal.size();i++){
			odl=odal.get(i);
			goodsID=odl.getGoodsID();
			goodsCount=odl.getGoodsCount();
			//该商品的数量
			String goodsid=Long.toString(goodsID);
			goods=od.selectGoods_goodsId(goodsid);
			goodsnumber=goods.getGoodsNumber()+goodsCount;
			buyGoodsNumber=goods.getBuyGoodsNumber()-goodsCount;
			//System.out.println("剩余goodsnumber的数量值"+goodsnumber);
			//System.out.println("被卖出buyGoodsNumber的数量值"+buyGoodsNumber);
			
			od.updateGoodsNumber(goodsnumber, goodsid);//修改商品数量
			od.updateBuyGoodsNumber(goodsid,buyGoodsNumber);
		}
		request.getRequestDispatcher("OrderDelete").forward(request, response);
		out.close();
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
