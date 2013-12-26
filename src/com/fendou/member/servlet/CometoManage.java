package com.fendou.member.servlet;
/*ǰ̨管理员登陆跳转*/
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CometoManage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		PrintWriter out = response.getWriter();
		//response.sendRedirect("adminLogin.jsp");
		request.getRequestDispatcher("/WEB-INF/manager/adminLogin.jsp").forward(request, response);
	}

	

}
