package com.fendou.goods.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fendou.factory.DaoFactory;
import com.fendou.goods.dao.GoodsDao;
import com.fendou.pagination.po.Pagination;

public class Sale extends HttpServlet {

	
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
		GoodsDao goodsDao = (GoodsDao)daoFactory.getDaoImpl("goodsdao");
		Pagination page = new Pagination();
		int currentPage = 1;
		if(request.getParameter("pages")!=null) {
			currentPage = Integer.parseInt(request.getParameter("pages"));
		}
		page.setCurrentPage(currentPage);
		int currentPageRecord = 4; 
		int totalRecord = goodsDao.totalTejiaGoods();
		page.setTotalRecord(totalRecord);
		page.setCurrentPageRecord(currentPageRecord);
		page.setTotalPage(currentPageRecord);//总页数要放在最后，因为要set总记录数和set每页多少条记录
		ArrayList all = goodsDao.select();
		request.setAttribute("superTypeal",all);
		ArrayList al = goodsDao.saleGoods(page);
		request.setAttribute("alSaleGoods", al);
		request.setAttribute("page", page);
		request.getRequestDispatcher("WEB-INF/show/sale.jsp").forward(request, response);
		out.flush();
		out.close();
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
