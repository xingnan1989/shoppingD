package com.fendou.order.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fendou.factory.DaoFactory;
import com.fendou.order.dao.OrderDao;
import com.fendou.order.po.OrderCarryMode;
import com.fendou.order.po.OrderPayMode;

public class OrderCarryMode_Text extends HttpServlet {

	public OrderCarryMode_Text() {
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
		String carryID=request.getParameter("carryID");
		//System.out.println(payContent);
		DaoFactory df=DaoFactory.getfactory();
		OrderDao od=(OrderDao)df.getDaoImpl("orderdaoimpl");
		OrderCarryMode ocm=od.selectOrderCarryMode_id(carryID);
		session.setAttribute("ocm", ocm);//支付方式
		//System.out.println(opm.getPayID());
		String carryContent=ocm.getCarryContent();
		out.print(carryContent);
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
