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

public class FavoritsInsert extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FavoritsInsert() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		DaoFactory df=DaoFactory.getfactory();
		IndividualityDao idd=(IndividualityDao)df.getDaoImpl("individualityimpl");
		long goodsID=Long.parseLong(request.getParameter("goodsID"));
		long memberID=(Long)session.getAttribute("memberID");
		//查询商品收藏夹中是否存在该商品
		ArrayList<Favorits> fal=idd.selectFavoritsToMemberID(memberID);;
		//添加商品到收藏夹
		boolean falg=false;
		//System.out.println("fal:"+fal.size());
		//System.out.println("goodsID:"+goodsID);
		if(fal.size()==0){
			//System.out.println("fal为空");
			out.print("添加到收藏夹中成功！");
			idd.insertFavorits(goodsID,memberID);
		}else{
			//System.out.println("fal��Ϊ��");
			for(int i=0;i<fal.size();i++){
				if(fal.get(i).getGoodsID()==goodsID){
					out.print("您已经添加过此商品了");
					break;
				}
				if(i==fal.size()-1){
					falg=true;
				}
			}
			if(falg==true){
				out.print("添加到收藏夹中成功！");
				idd.insertFavorits(goodsID,memberID);
			}
		}
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
