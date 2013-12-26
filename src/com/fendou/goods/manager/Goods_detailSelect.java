package com.fendou.goods.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fendou.factory.DaoFactory;
import com.fendou.goods.dao.GoodsDao;
import com.fendou.goods.po.T_Goods;

public class Goods_detailSelect extends HttpServlet {

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
		String goodsID = request.getParameter("goodsID");
		DaoFactory daoFactory = DaoFactory.getfactory();
		GoodsDao goodsDao = (GoodsDao)daoFactory.getDaoImpl("goodsdao");
		T_Goods goods = goodsDao.selectGoodsDetail(goodsID);
		request.setAttribute("goods",goods);
		request.getRequestDispatcher("goods_detail.jsp").forward(request,response);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
