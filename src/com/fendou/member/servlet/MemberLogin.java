package com.fendou.member.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fendou.factory.DaoFactory;
import com.fendou.member.impl.MemberDaoImpl;
import com.fendou.member.po.Member;

public class MemberLogin extends HttpServlet {
	
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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String memberName = request.getParameter("memberName");
		String memberPassword = request.getParameter("memberPassword");
		MemberDaoImpl memberDaoImpl = (MemberDaoImpl)DaoFactory.getfactory().getDaoImpl("memberDaoImpl");
		Member member = memberDaoImpl.userLogin(memberName, memberPassword);
		if(member != null) {
			session.setAttribute("memberID", member.getMemberID());
			session.setAttribute("memberName", member.getMemberName());
			session.setAttribute("memberEmail", member.getMemberEmail());
			out.println("<script>alert('登录成功!');history.back()</script>");
			System.out.println(member.getMemberID());
		} else {
			out.println("<script>alert('登录失败!');history.back()</script>");
			return;
		}
		//request.getRequestDispatcher("index").forward(request, response);
		response.sendRedirect("index");
	}


}
