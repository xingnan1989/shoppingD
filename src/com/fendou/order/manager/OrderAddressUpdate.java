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

public class OrderAddressUpdate extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		MemberAddressBook mab=(MemberAddressBook)session.getAttribute("mab");
		String str=mab.getMemberTrueName()+","+mab.getMemberAddress()+","+mab.getMemberPostcode()+","+mab.getMemberTelephone();
		//System.out.println(str);
		out.print(str);
		out.close();
	}

}
