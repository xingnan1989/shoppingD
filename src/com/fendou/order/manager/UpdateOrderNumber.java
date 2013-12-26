package com.fendou.order.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fendou.factory.DaoFactory;
import com.fendou.order.dao.OrderDao;
import com.fendou.order.po.Goods;
import com.fendou.order.po.GoodsNumber;
import com.fendou.order.po.Order;
import com.fendou.order.po.OrderInvoice;
import com.fendou.order.po.ShopCarAdd;

public class UpdateOrderNumber extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		DaoFactory df=DaoFactory.getfactory();
		OrderDao od=(OrderDao)df.getDaoImpl("orderdaoimpl");
		//修改订单——管理员
		String goodsid=null;
		int goodsnumber=0;//商品数量
		GoodsNumber gn=null;
		int buyGoodsNumber=0;//卖出数量
		boolean falg=false;
		String goodss="";
		ArrayList<GoodsNumber> algoosnumber=(ArrayList)session.getAttribute("algoosnumber");
		for(int i=0;i<algoosnumber.size();i++){
			gn=algoosnumber.get(i);
			goodsid=gn.getGoodsID();
			goodsnumber=gn.getGoodsNumber();
			buyGoodsNumber=gn.getBuyGoodsNumber();
			if(goodsnumber>0){
				//System.out.println("商品(new):"+goodsnumber);
				od.updateGoodsNumber(goodsnumber, goodsid);//修改购买商品数量后
				od.updateBuyGoodsNumber(goodsid,buyGoodsNumber);
				falg=false;
			}else{
				falg=true;
				Goods goods=od.selectGoods_goodsId(goodsid);
				goodss+=goods.getGoodsName()+",";
			}	
		}
		if(falg==false){
			//计算商品价格
			ArrayList<ShopCarAdd> car=(ArrayList)session.getAttribute("car");
			//System.out.println("falg:"+car.size());
			Order o=(Order)session.getAttribute("o");//获得订单值
			OrderInvoice oi=(OrderInvoice)session.getAttribute("oi");//获得发票信息
			
			od.insertOrder(o,oi,car);
			session.setAttribute("car", null);
			double countgoodsNormalPrice=0.0;
			double countgoodsMemberPrice=0.0;
			session.setAttribute("countgoodsNormalPrice", countgoodsNormalPrice);
			session.setAttribute("countgoodsMemberPrice", countgoodsMemberPrice);
			request.getRequestDispatcher("OrderOrderAndDetatlSelect").forward(request, response);
			
		}else{
			//out.println("<script>alert('�Բ���,"+goodss+"��Ʒ������,���޸Ĺ�����')</script>");
			request.getRequestDispatcher("/WEB-INF/show/cart_add.jsp?goodss="+goodss+"&falg="+falg).forward(request,response);
		}
		out.close();
		
	}


}
