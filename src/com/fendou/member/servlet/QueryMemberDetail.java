package com.fendou.member.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fendou.factory.DaoFactory;
import com.fendou.member.impl.MemberDaoImpl;
import com.fendou.member.impl.ProvinceDaoImpl;
import com.fendou.member.po.AreaList;
import com.fendou.member.po.Member;
import com.fendou.member.po.MemberAddressBook;


/**
 *显示会员详细信息
 * @author Student
 *
 */
public class QueryMemberDetail extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String path="";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		long MemberID=Long.parseLong(request.getParameter("memberid"));
		//System.out.println("MemberID"+MemberID);
		MemberDaoImpl memberDaoImpl = (MemberDaoImpl)DaoFactory.getfactory().getDaoImpl("memberDaoImpl");
		ProvinceDaoImpl provinceDaoImpl = (ProvinceDaoImpl)DaoFactory.getfactory().getDaoImpl("provinceDaoImpl");
		try {
			Member member=memberDaoImpl.queryMember(MemberID);
			MemberAddressBook memberAddressBook = memberDaoImpl.queryMemberAddress(MemberID);
			AreaList areaList = provinceDaoImpl.getAreaList(memberAddressBook.getProvinceCode(),
					memberAddressBook.getCityCode(), memberAddressBook.getAreaCode());
			//System.out.println(memberAddressBook.getCityCode() + "|" +memberAddressBook.getAreaCode());
			//System.out.println(areaList.getProvinceName()+"|"+areaList.getCityName()+"|"+areaList.getAreaName());
			request.setAttribute("member", member);
			request.setAttribute("memberAddressBook", memberAddressBook);
			request.setAttribute("areaList",areaList);
			path="/WEB-INF/manager/member_detail.jsp";
		} catch (Exception e) {
		}
		
		request.getRequestDispatcher(path).forward(request,response);
		
	}

}
