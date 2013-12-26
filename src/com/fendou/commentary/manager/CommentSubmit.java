package com.fendou.commentary.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fendou.commentary.dao.CommentaryDao;
import com.fendou.commentary.po.Comment;
import com.fendou.factory.DaoFactory;

public class CommentSubmit extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CommentSubmit() {
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
		HttpSession session=request.getSession();
		String commentContent=request.getParameter("commentContent");
		//System.out.println("commentContent:"+commentContent);
		long goodsID=Long.parseLong(request.getParameter("goodsID"));
		String memberName=null;
		if(session.getAttribute("memberName")==null){
			//System.out.println("12122");
			memberName="游客";
		}else{
			memberName=(String)session.getAttribute("memberName");
		}
		//System.out.println("goodsID:"+goodsID);
		//out.print(commentContent);
		//提交留言
		DaoFactory df=DaoFactory.getfactory();
		CommentaryDao cd=(CommentaryDao)df.getDaoImpl("commentarydaoimpl");
		Comment comment=new Comment();
		comment.setCommentUserName(memberName);
		comment.setCommentRank(1);
		comment.setCommentContent(commentContent);
		comment.setGoodsID(goodsID);
		cd.insertComment(comment);
		response.sendRedirect("CommentSelect?goodsID="+goodsID);
		//request.getRequestDispatcher("CommentSelect?goodsID="+goodsID).forward(request,response);
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
