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
import com.fendou.order.po.Order;
import com.fendou.order.po.OrderDetail;
import com.fendou.order.po.OrderDetailArrayOrder;

public class OrderSearch extends HttpServlet {

	public OrderSearch() {
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
		String orderNum=request.getParameter("oid");
		DaoFactory df=DaoFactory.getfactory();
		OrderDao od=(OrderDao)df.getDaoImpl("orderdaoimpl");
		//订单搜索
		//1.����ģ���ѯ
		if(orderNum.length()<=8){
			//�������
			String date=orderNum.substring(0, orderNum.length());
			ArrayList<Order> oal1=od.selectDate(date);
			//System.out.println("oal1:"+oal1);
			if(oal1.size()==0){
				request.getRequestDispatcher("orderManage.jsp").forward(request, response);
			}else{
				//根据ID搜索
				ArrayList<OrderDetailArrayOrder> ooal=new ArrayList();;
				for(int i=0;i<oal1.size();i++){
						//System.out.println("i"+i);
						Long orderID=oal1.get(i).getOrderID();
						//����������װ����Order �ʹ˶�������ϸ������ ArrayList<OrderDetail>
						
						//根据orderID搜索订单
						Order order=od.selectOrder2(orderID);
						//session.setAttribute("orderal",orderal);
						
						//根据orderID搜索订单详情
						Order order2=null;
						//订单明细
						ArrayList<OrderDetail> odal=od.selectOrderDetail(orderID);
						OrderDetailArrayOrder odArrayo=new OrderDetailArrayOrder();
						odArrayo.setOrder(order);
						odArrayo.setOdal(odal);
						ooal.add(odArrayo);	
						//System.out.println("ooal.length:"+ooal.size());
						request.setAttribute("ooal2", ooal);

				}						
				request.getRequestDispatcher("orderManage.jsp").forward(request, response);
			}
		}else{
			//�������
			String date=orderNum.substring(0, 4);
			//��ö���ID
			long orderID=Long.parseLong(orderNum.substring(8, orderNum.length()));
			System.out.println("date:"+date+"   orderID:"+orderID);
			ArrayList<Order> oal1=od.selectDate(date);
			//System.out.println("oal1:"+oal1);
			if(oal1.size()==0){
				request.getRequestDispatcher("orderManage.jsp").forward(request, response);
			}else{
				
				try{
					//��ϸ��ѯ
													
					//��ѯ����ID
					ArrayList<Order> oal=od.selectOrder();
					for(int i=0;i<oal.size();i++){
						if(oal.get(i).getOrderID() == orderID){
							//����������װ����Order �ʹ˶�������ϸ������ ArrayList<OrderDetail>
							ArrayList<OrderDetailArrayOrder> ooal=new ArrayList();
							//���orderID��ѯ����
							Order order=od.selectOrder2(orderID);
							//session.setAttribute("orderal",orderal);
							
							//���orderID��ѯ������ϸ��
							Order order2=null;
							//��ݶ����Ų�ѯ��ϸ��
							ArrayList<OrderDetail> odal=od.selectOrderDetail(orderID);
							OrderDetailArrayOrder odArrayo=new OrderDetailArrayOrder();
							odArrayo.setOrder(order);
							odArrayo.setOdal(odal);
							ooal.add(odArrayo);	
							request.setAttribute("ooal2", ooal);
						}
					}						
					request.getRequestDispatcher("orderManage.jsp").forward(request, response);
					out.close();
				}catch(StringIndexOutOfBoundsException se){
					request.getRequestDispatcher("orderManage.jsp").forward(request, response);
				}
				
			}
				
		
		}
		
		
		
		
		

		/*
		try{
			//��ϸ��ѯ
											
			//��ѯ����ID
			ArrayList<Order> oal=od.selectOrder();
			for(int i=0;i<oal.size();i++){
				if(oal.get(i).getOrderID() == orderID){
					//����������װ����Order �ʹ˶�������ϸ������ ArrayList<OrderDetail>
					ArrayList<OrderDetailArrayOrder> ooal=new ArrayList();
					//���orderID��ѯ����
					Order order=od.selectOrder2(orderID);
					//session.setAttribute("orderal",orderal);
					
					//���orderID��ѯ������ϸ��
					Order order2=null;
					//��ݶ����Ų�ѯ��ϸ��
					ArrayList<OrderDetail> odal=od.selectOrderDetail(orderID);
					OrderDetailArrayOrder odArrayo=new OrderDetailArrayOrder();
					odArrayo.setOrder(order);
					odArrayo.setOdal(odal);
					ooal.add(odArrayo);	
					request.setAttribute("ooal2", ooal);
				}
			}						
			request.getRequestDispatcher("orderManage.jsp").forward(request, response);
			out.close();
		}catch(StringIndexOutOfBoundsException se){
			request.getRequestDispatcher("orderManage.jsp").forward(request, response);
		}
		*/
		

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
