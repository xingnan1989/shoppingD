package com.fendou.order.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fendou.factory.DaoFactory;
import com.fendou.order.dao.OrderDao;
import com.fendou.order.po.MemberAddressBook;

public class OrderAddressSave extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		String address=request.getParameter("address");
		//System.out.println(address);
		long memberID=(Long)session.getAttribute("memberID");
		String[] str=address.split(",");
		String memberTrueName=str[0];
		String memberAddress=str[1];
		String memberPostcode=str[2];
		String memberTelephone=str[3];
		//System.out.println(memberTrueName+" "+memberAddress+" "+memberPostcode+" "+memberTelephone);
		MemberAddressBook mab=new MemberAddressBook();
		mab.setMemberID(memberID);
		mab.setMemberTrueName(memberTrueName);
		mab.setMemberAddress(memberAddress);
		mab.setMemberPostcode(memberPostcode);
		mab.setMemberTelephone(memberTelephone);
		session.setAttribute("mab", mab);
		/*
		DaoFactory df=DaoFactory.getfactory();
		OrderDao od=(OrderDao)df.getDaoImpl("orderdaoimpl");
		od.updateMemberAddressBook(mab);
		*/
		out.print(address);
		out.close();
	}

}
