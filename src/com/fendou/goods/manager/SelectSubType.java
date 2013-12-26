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

public class SelectSubType extends HttpServlet {

	
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
		response.setHeader("Cache-Control","no-store");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		T_GoodsType type = new T_GoodsType();
		DaoFactory daoFactory = DaoFactory.getfactory();
		GoodsDao goodsDao = (GoodsDao)daoFactory.getDaoImpl("goodsdao");
		Pagination page =new Pagination();
		if(request.getParameter("superTypeCode")!=null) {
			int totalRecord = goodsDao.getTotalRecordSub(request.getParameter("superTypeCode"));
			page.setTotalRecord(totalRecord);
			int currentPage = 1;
			if(request.getParameter("page") != null) {
				currentPage = Integer.parseInt(request.getParameter("page"));
			}
			page.setCurrentPage(currentPage);
			int currentPageRecord = 6;//每页显示几条记录
			page.setCurrentPageRecord(currentPageRecord);
			page.setTotalPage(currentPageRecord);
			//String superTypeName = request.getParameter("superTypeName");//!!!!!!!!!
			ArrayList al = goodsDao.selectSub(page,request.getParameter("superTypeCode"));
			request.setAttribute("superTypeCode", request.getParameter("superTypeCode"));
			request.setAttribute("al",al);
			request.setAttribute("page",page);
			//request.setAttribute("superTypeName",superTypeName);url传中文容易出乱码
			//System.out.println(superTypeName+"又是乱码");//!!!!!!!!!
			request.getRequestDispatcher("subType.jsp").forward(request,response);
		} else {
			String superTypeCode = (String)request.getAttribute("superTypeCode");
			int totalRecord = goodsDao.getTotalRecordSub(superTypeCode);
			page.setTotalRecord(totalRecord);
			int currentPage = 1;
			if(request.getParameter("page") != null) {
				currentPage = Integer.parseInt(request.getParameter("page"));
			}
			page.setCurrentPage(currentPage);
			int currentPageRecord = 6;//每页显示几条记录
			page.setCurrentPageRecord(currentPageRecord);
			page.setTotalPage(currentPageRecord);
			ArrayList al = goodsDao.selectSub(page,superTypeCode);
			request.setAttribute("al",al);
			request.setAttribute("page",page);
			request.getRequestDispatcher("subType.jsp").forward(request,response);
		} 
		out.flush();
		out.close();
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
