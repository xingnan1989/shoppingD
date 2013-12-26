package com.fendou.order.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fendou.factory.DaoFactory;
import com.fendou.order.dao.OrderDao;
import com.fendou.order.po.Goods;
import com.fendou.order.po.GoodsNumber;
import com.fendou.order.po.MemberAddressBook;
import com.fendou.order.po.Order;
import com.fendou.order.po.OrderCarryMode;
import com.fendou.order.po.OrderDetail;
import com.fendou.order.po.OrderDetailArrayOrder;
import com.fendou.order.po.OrderInvoice;
import com.fendou.order.po.OrderPayMode;
import com.fendou.order.po.ShopCarAdd;

public class OrderSubmit extends HttpServlet {


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
		long memberID=(Long)session.getAttribute("memberID");		
		MemberAddressBook mab=(MemberAddressBook)session.getAttribute("mab");
		String memberTureName=mab.getMemberTrueName();
		String memberAddress=mab.getMemberAddress();
		String memberProvince=request.getParameter("province");
		String memberCity=request.getParameter("city");//获得城市属性
		String memberArea=request.getParameter("area");
		String memberPostcode=mab.getMemberPostcode();
		String memberTelephone=mab.getMemberTelephone();
		double orderAmount=(Double)session.getAttribute("countgoodsMemberPrice");
		//System.out.println("orderAmount="+orderAmount);
		OrderPayMode opm=(OrderPayMode)session.getAttribute("opm");
		String orderPay=opm.getPayContent();//支付方式描述
		String orderInvoice=request.getParameter("needinvoice");//是否需要发票
		if(orderInvoice==null){
			orderInvoice="N";
		}else{
			orderInvoice="Y";
		}
		OrderCarryMode ocm=(OrderCarryMode)session.getAttribute("ocm");
		String orderCarry=ocm.getCarryContent();//送货描述
		int orderCarryTime=Integer.parseInt(request.getParameter("time1"));//货到时间int(11)
		System.out.println("货到时间："+orderCarryTime);
		String orderRemark=request.getParameter("bz");//数据库类型	Varchar(2000)
		String orderStatus="N";//是否已经发货，数据库类型Char(1)
		//JAVABean中相关属性
		Order o=new Order();
		o.setMemberID(memberID);
		o.setMemberTureName(memberTureName);
		o.setMemberAddress(memberAddress);
		o.setMemberProvince(memberProvince);
		o.setMemberCity(memberCity);
		o.setMemberArea(memberArea);
		o.setMemberPostcode(memberPostcode);
		o.setMemberTelephone(memberTelephone);
		o.setOrderAmount(orderAmount);
		o.setOrderPay(orderPay);//支付方式֧
		o.setOrderInvoice(orderInvoice);
		o.setOrderCarry(orderCarry);//取货方式
		o.setOrderCarryTime(orderCarryTime);
		o.setOrderRemark(orderRemark);
		o.setOrderStatus(orderStatus);
		session.setAttribute("o", o);
		//发票情况
		String invoiceTitle=request.getParameter("invoicetitle");//发票标题，数据库类型Varchar(100)
		String invoiceContent=request.getParameter("invoicecontent");//	发票内容，数据库类型Varchar(150)
		//System.out.println(InvoiceTitle+"|"+InvoiceContent);
		OrderInvoice oi=new OrderInvoice();
		oi.setInvoiceTitle(invoiceTitle);
		oi.setInvoiceContent(invoiceContent);
		session.setAttribute("oi", oi);
		//购物车提交
		ArrayList<ShopCarAdd> car=(ArrayList)session.getAttribute("car");
		int num=0;//该商品数量
		String goodsid=null;
		int goodsnumber=0;//剩余商品数量
		int buyGoodsNumber=0;//被卖商品数量
		boolean falg=false;
		String goodss="";
		ArrayList<GoodsNumber> algoosnumber=new ArrayList();//�洢��Ʒ��
		GoodsNumber gn=null;
		if(car !=null){
			for(int i=0;i<car.size();i++){
				ShopCarAdd sca=car.get(i);			
				num=sca.getNum();
				//System.out.println("卖出数量:"+num);
				goodsid=Long.toString(sca.getGoods().getGoodsID());
				//剩余商品统计
				Goods goods=od.selectGoods_goodsId(goodsid);
				goodsnumber=goods.getGoodsNumber()-num;//还剩商品数量
				buyGoodsNumber=goods.getBuyGoodsNumber()+num;
				gn=new GoodsNumber();
				gn.setGoodsID(goodsid);
				gn.setGoodsNumber(goodsnumber);
				gn.setBuyGoodsNumber(buyGoodsNumber);
				algoosnumber.add(gn);
			}
			session.setAttribute("algoosnumber",algoosnumber);
		}
		
		
		request.getRequestDispatcher("UpdateOrderNumber").forward(request, response);
		out.close();
		
	}
}
