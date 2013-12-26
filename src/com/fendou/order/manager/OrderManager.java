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
import com.fendou.order.po.OrderDetail;
import com.fendou.order.po.OrderDetailArrayOrder;
import com.fendou.pagination.po.Pagination;

public class OrderManager extends HttpServlet {

	
	public OrderManager() {
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
		HttpSession session=request.getSession();
		DaoFactory df=DaoFactory.getfactory();
		OrderDao od=(OrderDao)df.getDaoImpl("orderdaoimpl");
		//定义一个Order的 ArrayList<OrderDetail>列表
		ArrayList<OrderDetailArrayOrder> ooal=new ArrayList();
		
		//订单列表
		ArrayList<Order> orderal=od.selectOrder();
		//session.setAttribute("orderal",orderal);
		
		//订单
		Order order2=null;
		long orderID=0;
		OrderDetailArrayOrder odArrayo=null;
		for(int i=0;i<orderal.size();i++){
			order2=orderal.get(i);
			orderID=order2.getOrderID();
			//订单明细
			ArrayList<OrderDetail> odal=od.selectOrderDetail(orderID);
			OrderDetail odd=null;
			//System.out.println(i+"/orderID:"+orderID);
			//System.out.println("商品种类"+odal.size());
			for(int j=0;j<odal.size();j++){
				odd=odal.get(j);
				//System.out.println("GoodsName:"+odd.getGoodsName());
			}
			odArrayo=new OrderDetailArrayOrder();
			odArrayo.setOrder(order2);
			odArrayo.setOdal(odal);
			ooal.add(odArrayo);	
		}
		
		//分页处理
		Pagination page = new Pagination();
		int totalRecord = ooal.size();
		page.setTotalRecord(totalRecord);
		int currentPage = 1;
		if(request.getParameter("page")!=null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		page.setCurrentPage(currentPage);
		int currentPageRecord = 4;
		page.setCurrentPageRecord(currentPageRecord);
		page.setTotalPage(currentPageRecord);
		
		ArrayList<OrderDetailArrayOrder> ooalP = new ArrayList();;
		int p=(currentPage-1)*currentPageRecord;//订单列表分页
		for(int i=0;i<currentPageRecord;i++){
			if(p+i<ooal.size()){
				ooalP.add(ooal.get(p+i));
			}else{
				break;
			}
		}
		request.setAttribute("ooal2", ooalP);
		//System.out.println("commental:"+commental);
		//System.out.println("length:"+commental.size());
		request.setAttribute("page", page);
		request.getRequestDispatcher("orderManage.jsp").forward(request, response);
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
