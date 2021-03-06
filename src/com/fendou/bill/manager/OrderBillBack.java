package com.fendou.bill.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fendou.bill.dao.BillDao;
import com.fendou.bill.po.T_Bill;
import com.fendou.factory.DaoFactory;

public class OrderBillBack extends HttpServlet {


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		DaoFactory daoFactory = DaoFactory.getfactory();
		BillDao billDao = (BillDao)daoFactory.getDaoImpl("billdao");
		int order = Integer.parseInt(request.getParameter("billOrder"));
		int billId = Integer.parseInt(request.getParameter("billId"));
		ArrayList al = billDao.selectBillOrder();
		int getOrder = 0;
		for(int i=0;i<al.size();i++) {
			T_Bill bill = (T_Bill)al.get(i);
			getOrder = bill.getBillOrder();
			if(getOrder>order) {
				billDao.updateBillOrderBack(bill.getBillId());
			} else if(getOrder==order) {
				billDao.updateBillOrderBack1(billId);
			}
		}
		request.getRequestDispatcher("SelectBill").forward(request,response);
		out.flush();
		out.close();
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
