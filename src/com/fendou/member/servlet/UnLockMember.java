package com.fendou.member.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fendou.factory.DaoFactory;
import com.fendou.member.impl.MemberDaoImpl;
import com.fendou.member.po.Member;


/**
 * 
 * @author Student
 *
 */
public class UnLockMember extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//解锁用户ID
		long memberID=Long.parseLong(request.getParameter("memberid"));
		MemberDaoImpl memberDaoImpl = (MemberDaoImpl)DaoFactory.getfactory().getDaoImpl("memberDaoImpl");
			Member member = memberDaoImpl.unlockMember(memberID);
		request.setAttribute("member", member);
		request.getRequestDispatcher("SelectMemberList").forward(request,response);
		
	}

}
