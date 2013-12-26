package com.fendou.goods.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fendou.factory.DaoFactory;
import com.fendou.goods.dao.GoodsDao;
import com.fendou.goods.po.T_GoodsType;

public class SelectSubTypeOne extends HttpServlet {

	/**
	 * 
	 */
	

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
		String typeCode = request.getParameter("typeCode");
		String superTypeCode = request.getParameter("superTypeCode");
		T_GoodsType type = goodsDao.selectSubTypeOne(typeCode);
		request.setAttribute("superTypeCode",superTypeCode);
		request.setAttribute("type",type);
		request.getRequestDispatcher("subType_modify.jsp").forward(request, response);
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
