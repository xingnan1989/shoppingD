package com.fendou.statistic.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fendou.factory.DaoFactory;
import com.fendou.statistic.dao.StatisticDao;
import com.fendou.statistic.po.Goods;

public class StatisticSelectShow extends HttpServlet {

	public StatisticSelectShow() {
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
		PrintWriter out = response.getWriter();
		long goodsID=Long.parseLong(request.getParameter("goodsID"));
		System.out.println("goodsID:"+goodsID);
		DaoFactory df=DaoFactory.getfactory();
		StatisticDao sd=(StatisticDao)df.getDaoImpl("statisticdaoimpl");
		Goods goods=sd.selectGoodstoID(goodsID);
		request.setAttribute("goods", goods);
		out.close();
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
