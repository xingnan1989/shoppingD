package com.fendou.goods.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fendou.factory.DaoFactory;
import com.fendou.goods.dao.GoodsDao;

public class RepairAjax extends HttpServlet {

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
		String repair = request.getParameter("repair");
		String goodsID = request.getParameter("goodsID");
		String goodsNumberHidden = request.getParameter("goodsNumberHidden");
		int updateGoodsNumber = Integer.parseInt(repair)+Integer.parseInt(goodsNumberHidden);
		if(goodsDao.repairGoods(updateGoodsNumber, goodsID) > 0) {
			String goodsGrade = goodsDao.repairGoods(goodsID);
			out.print("succeed|"+goodsGrade);	
		}
		out.flush();
		out.close();
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
