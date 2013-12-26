package com.fendou.goods.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.fendou.factory.DaoFactory;
import com.fendou.goods.dao.GoodsDao;
import com.fendou.goods.po.T_GoodsType;

public class SuperTypeAdd extends HttpServlet {


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
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		T_GoodsType type = new T_GoodsType();
		type.setTypeName(request.getParameter("typename"));
		type.setTypeDesc(request.getParameter("description"));
		type.setTypeCode(request.getParameter("typeCode"));
		type.setCreater(username);//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		type.setUpdater(username);//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		DaoFactory daoFactory = DaoFactory.getfactory();
		GoodsDao goodsDao = (GoodsDao)daoFactory.getDaoImpl("goodsdao");
		if(goodsDao.insert(type) > 0) {
			request.getRequestDispatcher("SelectSuperType").forward(request,response);
		}
		out.flush();
		out.close();
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
