 package com.fendou.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fendou.bill.dao.BillDao;
import com.fendou.factory.DaoFactory;
import com.fendou.goods.dao.GoodsDao;
import com.fendou.goods.po.T_Goods;
import com.fendou.goods.po.T_GoodsType;
import com.fendou.placard.dao.PlacardDao;
import com.fendou.placard.po.Placard;
import com.fendou.statistic.dao.StatisticDao;
import com.fendou.statistic.po.Goods;

public class IndexSelect extends HttpServlet {
	public IndexSelect() {
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
		HttpSession session=request.getSession();
		

		
		//首页显示
		/*
  		long memberID=2;
  		session.setAttribute("memberID",memberID);
  		session.setAttribute("memberName","q464610036");
  		session.setAttribute("memberTrueName","huangzhen");
		*/
		/*首页信息显示*/
		//公告信息
		DaoFactory df=DaoFactory.getfactory();
		PlacardDao pd=(PlacardDao)df.getDaoImpl("placarddaoimpl");
		ArrayList<Placard> pdal=pd.selectPlacardShow();
		for(int i=0;i<pdal.size();i++){
			Placard p=pdal.get(i);
			//System.out.println(p.getCreateDate());
		}
		//System.out.println("公告长度："+pdal.size());
		session.setAttribute("pdal", pdal);
		//已经购买的商品信息类表
		StatisticDao sd=(StatisticDao)df.getDaoImpl("statisticdaoimpl");
		ArrayList<Goods> goodsal=sd.selectGoodsStatistic();
		session.setAttribute("goodsal",goodsal);
		/*公告信息*/	
		
		
		/*实例化商品管理类*/
		GoodsDao goodsDao = (GoodsDao)df.getDaoImpl("goodsdao");
		//商品信息
		int count = 2;//显示特价商品的个数
		ArrayList alTejia = goodsDao.indexTejiaGoods(count);
		if(alTejia != null && alTejia.size() > 0) {
			T_Goods goodsTejia1 = (T_Goods)alTejia.get(0);
			T_Goods goodsTejia2 = (T_Goods)alTejia.get(1);
			//System.out.println("goodsTejia1");
			request.setAttribute("goodsTejia1", goodsTejia1);
			request.setAttribute("goodsTejia2", goodsTejia2);
		}
		//在特价商品页显示特价商品个数
		count = 4;
		ArrayList alNewGoods = goodsDao.indexNewGoods(count);
		if(alNewGoods != null && alNewGoods.size() > 0) {
			request.setAttribute("alNewGoods",alNewGoods);
		}
		
		//广告信息5条显示
		BillDao billDao = (BillDao)df.getDaoImpl("billdao");
		count = 5;
		ArrayList al = billDao.selectAdIndex(count);
		if(al != null && al.size() > 0) {
			request.setAttribute("alAd",al);
		}
		//大类名称索引
		ArrayList superTypeal = goodsDao.indexSeach();
		if(superTypeal != null && superTypeal.size()>0) {
			request.setAttribute("superTypeal", superTypeal);
		}
		
		//显示所有大类
		ArrayList all = goodsDao.selectGoodsType();
		if(all!= null && all.size()>0) {
			request.setAttribute("goodsType",all);
		}
		
		/*使用forward页面跳转*/
		
		request.getRequestDispatcher("/WEB-INF/show/index.jsp").forward(request,response);
		//request.getRequestDispatcher("index.jsp").forward(request,response);
		out.close();
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
