package com.fendou.individuality.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fendou.factory.DaoFactory;
import com.fendou.individuality.dao.IndividualityDao;
import com.fendou.individuality.po.Favorits;
import com.fendou.order.po.Goods;

public class FavoritsSelectManager extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FavoritsSelectManager() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		DaoFactory df=DaoFactory.getfactory();
		IndividualityDao idd=(IndividualityDao)df.getDaoImpl("individualityimpl");
		long memberID=(Long)session.getAttribute("memberID");
		//System.out.println("memberID:"+memberID);
		ArrayList<Favorits> fal=idd.selectFavorits(memberID);//收藏商品
		ArrayList<Goods> goodsFavoritsal=new ArrayList();//�ղؼ��б���ʾ�ļ���
		Goods goods=null;
		for(int i=0;i<fal.size();i++){
			long goodsID=fal.get(i).getGoodsID();
			goods=idd.selectGoods(goodsID);
			//System.out.println("goodsPicture:"+goods.getGoodsPicture());
			goodsFavoritsal.add(goods);
		}
		request.setAttribute("goodsFavoritsal", goodsFavoritsal);
		request.getRequestDispatcher("/WEB-INF/show/favorite.jsp").forward(request, response);
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
