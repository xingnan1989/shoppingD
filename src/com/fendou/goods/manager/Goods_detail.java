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
import com.fendou.goods.po.T_Goods;

public class Goods_detail extends HttpServlet {


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
		String goodsID = request.getParameter("goodsID");
		//System.out.println("goodsID:"+goodsID);
		T_Goods goods = goodsDao.selectGoodsDetail(goodsID);
		ArrayList superTypeal = goodsDao.indexSeach();
		request.setAttribute("superTypeal", superTypeal);
		request.setAttribute("goodsdetail",goods);
		request.setAttribute("id", goodsID);
		request.getRequestDispatcher("WEB-INF/show/goodsdetail.jsp").forward(request,response);
		out.flush();
		out.close();
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
