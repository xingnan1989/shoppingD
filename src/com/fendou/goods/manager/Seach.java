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

public class Seach extends HttpServlet {


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
		String typeID = request.getParameter("typeID");
		String key = request.getParameter("key");
		Pagination page = new Pagination();
		int totalRecord = goodsDao.seachTotalRecord(key, typeID);
		page.setTotalRecord(totalRecord);
		int currentPage = 1;
		if(request.getParameter("pages")!=null) {
			currentPage = Integer.parseInt(request.getParameter("pages"));
		}
		page.setCurrentPage(currentPage);
		int currentPageRecord = 6;
		page.setCurrentPageRecord(currentPageRecord);
		page.setTotalPage(currentPageRecord);
		ArrayList goodsAl = goodsDao.seach(key,typeID,page);
		ArrayList all = goodsDao.select();
		request.setAttribute("alSuperType",all);
		request.setAttribute("goodsAl", goodsAl);
		request.setAttribute("page",page);
		request.getRequestDispatcher("goodsManage.jsp").forward(request,response);
		out.flush();
		out.close();
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
