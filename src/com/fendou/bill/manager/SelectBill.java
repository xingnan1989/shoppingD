package com.fendou.bill.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fendou.bill.dao.BillDao;
import com.fendou.factory.DaoFactory;
import com.fendou.pagination.po.Pagination;

public class SelectBill extends HttpServlet {


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
		ArrayList al  = null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		DaoFactory daoFactory = DaoFactory.getfactory();
		BillDao billDao = (BillDao)daoFactory.getDaoImpl("billdao");
		Pagination page = new Pagination();	
		int currentPageRecord = 6;
		page.setCurrentPageRecord(currentPageRecord);
		int currentPage = 1;
		page.setCurrentPage(currentPage);
		if(request.getParameter("pages") != null) {
			page.setCurrentPage(Integer.parseInt(request.getParameter("pages")));
		}
		int totalRecord = billDao.getTotalRecord();
		page.setTotalRecord(totalRecord);
		page.setTotalPage(currentPageRecord);
		//HttpSession session = request.getSession(true);
		al = billDao.select(page);
		request.setAttribute("al", al);
		request.setAttribute("page", page);
		request.getRequestDispatcher("bill_list.jsp").forward(request,response);
		out.flush();
		out.close();
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
