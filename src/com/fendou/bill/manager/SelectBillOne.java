package com.fendou.bill.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fendou.bill.dao.BillDao;
import com.fendou.bill.po.T_Bill;
import com.fendou.factory.DaoFactory;

public class SelectBillOne extends HttpServlet {


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
		HttpSession session = request.getSession(true);
		T_Bill bill = new T_Bill();
		bill.setBillId(Integer.parseInt(request.getParameter("billId")));
		DaoFactory daoFactory = DaoFactory.getfactory();
		BillDao billDao = (BillDao)daoFactory.getDaoImpl("billdao");
		bill = billDao.selectOne(bill);
		session.setAttribute("bill",bill);
		request.getRequestDispatcher("bill_modify.jsp").forward(request,response);
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
