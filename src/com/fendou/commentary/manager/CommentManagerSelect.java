package com.fendou.commentary.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fendou.commentary.dao.CommentaryDao;
import com.fendou.commentary.po.Comment;
import com.fendou.factory.DaoFactory;
import com.fendou.pagination.po.Pagination;

public class CommentManagerSelect extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CommentManagerSelect() {
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
		DaoFactory df=DaoFactory.getfactory();
		CommentaryDao cd=(CommentaryDao)df.getDaoImpl("commentarydaoimpl");
		long goodsID=Long.parseLong(request.getParameter("goodsID"));
		//System.out.println("select   goodsID:"+goodsID);
		ArrayList<Comment> commental=cd.selectComment(goodsID);
		//System.out.println("commental:"+commental);
		/*
		for(int i=0;i<commental.size();i++){
			Comment comment=commental.get(i);
			System.out.println("content:"+comment.getCommentContent()+"  GoodsID:"+comment.getGoodsID());
		}
		*/
		if(commental !=null){
			if(commental.size() !=0){
				//·ÖÒ³
				Pagination page = new Pagination();
				int totalRecord = commental.size();
				page.setTotalRecord(totalRecord);
				int currentPage = 1;
				if(request.getParameter("page")!=null) {
					currentPage = Integer.parseInt(request.getParameter("page"));
				}
				page.setCurrentPage(currentPage);
				int currentPageRecord = 4;
				page.setCurrentPageRecord(currentPageRecord);
				page.setTotalPage(currentPageRecord);
				
				ArrayList<Comment> alPagination = cd.selectCommentPagination(page,goodsID);
				request.setAttribute("commental", alPagination);
				//System.out.println("commental:"+commental);
				//System.out.println("length:"+commental.size());
				request.setAttribute("page", page);
			}else{
				request.setAttribute("falg", 0);
			}
		}
		
		request.getRequestDispatcher("Goods_detailSelect").forward(request, response);
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
