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
import com.fendou.member.po.MemberAddressBook;

public class ModifyAddress extends HttpServlet {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String memberName = (String) session.getAttribute("memberName");
		String memberTrueName = request.getParameter("memberTrueName");
		String memberAddress = request.getParameter("memberAddress");
		String provinceCode = request.getParameter("province");
		String cityCode = request.getParameter("city");
		String areaCode = request.getParameter("area");
//		System.out.println("province:"+provinceCode);
//		System.out.println("cityCode:"+cityCode);
//		System.out.println("areaCode:"+areaCode);
		String memberPostcode = request.getParameter("memberPostcode");
		String memberTelephone = request.getParameter("memberTelephone");
		
		MemberAddressBook memberAddressBook = new MemberAddressBook();
		memberAddressBook.setMemberTrueName(memberTrueName);
		memberAddressBook.setMemberAddress(memberAddress);
		memberAddressBook.setProvinceCode(provinceCode);
		memberAddressBook.setCityCode(cityCode);
		memberAddressBook.setAreaCode(areaCode);
		memberAddressBook.setMemberPostcode(memberPostcode);
		memberAddressBook.setMemberTelephone(memberTelephone);
		
		MemberDaoImpl memberDaoImpl = (MemberDaoImpl)DaoFactory.getfactory().getDaoImpl("memberDaoImpl");
		long memberID = memberDaoImpl.selectMemberID(memberName);
		if(memberDaoImpl.modifyMemberAddress(memberAddressBook, memberID)) {
			out.println("<script>alert('资料修改成功!');location.href='ShowMemberInfo'</script>");
		} else {
			out.println("<script>alert('资料修改失败,请重试!');history.back()</script>");
		}
	}

}
