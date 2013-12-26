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
import com.fendou.member.po.User;

public class UserLogin extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		MemberDaoImpl memberDaoImpl = (MemberDaoImpl)DaoFactory.getfactory().getDaoImpl("memberDaoImpl");
		User user = memberDaoImpl.adminLogin(userName, userPassword);
		if(user != null) {
			out.println("<script>alert('登陆成功！');location.href='SelectMemberList'</script>");
			//session.setAttribute("memberID", user);
			session.setAttribute("userName", userName);
		} else {
			out.println("<script>alert('登入失败');history.back()</script>");
			return;
		}
	}

	

}
