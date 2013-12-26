package com.fendou.member.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fendou.factory.DaoFactory;
import com.fendou.member.dao.MemberDao;
import com.fendou.member.po.Member;
import com.fendou.order.dao.OrderDao;

public class ValidUsername extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ValidUsername() {
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
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//out.print("111");
		//用户名是否有效
		String memberName=request.getParameter("memberName");
		DaoFactory df=DaoFactory.getfactory();
		MemberDao md=(MemberDao)df.getDaoImpl("memberDaoImpl");
		ArrayList<Member> mal=md.selectMember();
		boolean falg=false;
		if(mal != null){
			for(int i=0;i<mal.size();i++){
				if(mal.get(i).getMemberName().equals(memberName)){
					out.print("N");
					falg=true;
					break;
				}
			}
			if(falg==false){
				out.print("Y");
			}
			
		}		
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
