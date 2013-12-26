package com.fendou.bill.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fendou.bill.impl.BillDaoImpl;
import com.fendou.bill.po.T_Bill;
import com.fendou.factory.DaoFactory;

public class DeleteBill extends HttpServlet {

	
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
		T_Bill bill = new T_Bill();
		bill.setBillId(Integer.parseInt(request.getParameter("billId")));
		DaoFactory daoFactory = DaoFactory.getfactory();
		BillDaoImpl billDao = (BillDaoImpl)daoFactory.getDaoImpl("billdao");
		billDao.delete(bill);
		request.getRequestDispatcher("SelectBill").forward(request,response);
		out.flush();
		out.close();
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
