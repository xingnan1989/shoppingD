package com.fendou.placard.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fendou.factory.DaoFactory;
import com.fendou.order.po.OrderDetailArrayOrder;
import com.fendou.pagination.po.Pagination;
import com.fendou.placard.dao.PlacardDao;
import com.fendou.placard.po.Placard;

public class PlacardSelect extends HttpServlet {

	public PlacardSelect() {
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
		/*
		PrintWriter out = response.getWriter();
		DaoFactory df=DaoFactory.getfactory();
		PlacardDao pd=(PlacardDao)df.getDaoImpl("placarddaoimpl");
		ArrayList<Placard> pdal=pd.selectPlacard();
		request.setAttribute("pdal", pdal);
		request.getRequestDispatcher("/WEB-INF/manager/placardManage.jsp").forward(request, response);
		out.close();
		*/
		PrintWriter out = response.getWriter();
		DaoFactory daoFactory = DaoFactory.getfactory();
		PlacardDao goodsDao = (PlacardDao)daoFactory.getDaoImpl("placarddaoimpl");
		//查找公告信息
		int count=goodsDao.selectPlacardCount();
		
		//分页处理
		Pagination page = new Pagination();
		int totalRecord = count;
		page.setTotalRecord(totalRecord);
		int currentPage = 1;
		if(request.getParameter("page")!=null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		page.setCurrentPage(currentPage);
		int currentPageRecord = 4;
		page.setCurrentPageRecord(currentPageRecord);
		page.setTotalPage(currentPageRecord);
		
		ArrayList<Placard> pdal = goodsDao.selectPlacardPagination(page);
		
		request.setAttribute("pdal", pdal);
		//System.out.println("commental:"+commental);
		//System.out.println("length:"+commental.size());
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/manager/placardManage.jsp").forward(request, response);
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
