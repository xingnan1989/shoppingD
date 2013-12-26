package com.fendou.member.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fendou.factory.DaoFactory;
import com.fendou.member.impl.MemberDaoImpl;
import com.fendou.member.po.MemberList;


/**
 * ��Ա����
 * @author Student
 *
 */
public class MemberSearchAgain extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String memberName = (String) request.getAttribute("memberName");
		//System.out.println("memberName:="+memberName);
		MemberDaoImpl memberDaoImpl = (MemberDaoImpl)DaoFactory.getfactory().getDaoImpl("memberDaoImpl");
		try {
			MemberList member = memberDaoImpl.SelectMemberByName(memberName);
			if(member!=null){
				request.setAttribute("member", member);
			}else{
				request.setAttribute("memberTip", "没有找到此会员的记录!");
			}
			request.getRequestDispatcher("/WEB-INF/manager/member_Search.jsp").forward(request, response);
		} catch (Exception e) {
		}	
	}

}
