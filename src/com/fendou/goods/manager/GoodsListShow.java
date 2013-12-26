package com.fendou.goods.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fendou.bill.dao.BillDao;
import com.fendou.factory.DaoFactory;
import com.fendou.goods.dao.GoodsDao;

public class GoodsListShow extends HttpServlet {

	
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
		DaoFactory daoFactory = DaoFactory.getfactory();
		GoodsDao goodsDao = (GoodsDao)daoFactory.getDaoImpl("goodsdao");
		String subTypeCode = request.getParameter("subTypeCode");
		ArrayList al = goodsDao.selectGoods(subTypeCode);
		ArrayList superTypeal = goodsDao.indexSeach();
		ArrayList all = goodsDao.selectGoodsType();
		BillDao billDao = (BillDao)daoFactory.getDaoImpl("billdao");
		int count = 5;
		ArrayList ala = billDao.selectAdIndex(count);
		request.setAttribute("alAd",ala);
		request.setAttribute("goodsType",all);
		request.setAttribute("superTypeal", superTypeal);
		request.setAttribute("goodsListShow", al);
		request.setAttribute("superName",goodsDao.superNameShow(subTypeCode));
		request.setAttribute("subName",goodsDao.subNameShow(subTypeCode));
		request.getRequestDispatcher("WEB-INF/show/type_show.jsp").forward(request,response);
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
