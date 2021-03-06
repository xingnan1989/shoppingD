package com.fendou.goods.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fendou.factory.DaoFactory;
import com.fendou.goods.dao.GoodsDao;

public class SelectSubTypeAjax extends HttpServlet {

	
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
		response.setHeader("Cache-Control","no-store");
		DaoFactory daoFactory = DaoFactory.getfactory();
		GoodsDao goodsDao = (GoodsDao)daoFactory.getDaoImpl("goodsdao");
		String  subTypeAjax = goodsDao.selectSubAjax((request.getParameter("superTypeCodeAjax")));
		out.print(subTypeAjax);
		out.flush();
		out.close();
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
