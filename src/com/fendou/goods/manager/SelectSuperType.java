package com.fendou.goods.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fendou.factory.DaoFactory;
import com.fendou.goods.dao.GoodsDao;
import com.fendou.goods.po.T_GoodsType;
import com.fendou.pagination.po.Pagination;

public class SelectSuperType extends HttpServlet {

	
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
		HttpSession session = request.getSession();
		DaoFactory daoFactory = DaoFactory.getfactory();
		GoodsDao goodsDao = (GoodsDao)daoFactory.getDaoImpl("goodsdao");
		Pagination page =new Pagination();
		int totalRecord = goodsDao.getTotalRecord();
		System.out.println(totalRecord);
		page.setTotalRecord(totalRecord);
		int currentPage = 1;
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		page.setCurrentPage(currentPage);
		int currentPageRecord = 6;//每页显示几条记录
		page.setCurrentPageRecord(currentPageRecord);
		page.setTotalPage(currentPageRecord);
		ArrayList al = goodsDao.select(page);
		request.setAttribute("alSuperType",al);
		request.setAttribute("page",page);
		//System.out.println("asdf*******");
		request.getRequestDispatcher("parameterManage.jsp").forward(request,response);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
