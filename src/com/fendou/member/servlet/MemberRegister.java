package com.fendou.member.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fendou.member.impl.MemberDaoImpl;
import com.fendou.member.po.Member;
import com.fendou.member.po.MemberAddressBook;
import com.fendou.factory.*;


public class MemberRegister extends HttpServlet {

	
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
		
		/*注册会员信息*/
		String memberName = request.getParameter("memberName");
		String memberPassword = request.getParameter("memberPassword");
		String memberEmail = request.getParameter("memberEmail");
		String validateCode = request.getParameter("validateCode");
		String memberTrueName = request.getParameter("memberTrueName");
		String provinceCode = request.getParameter("province");
		String cityCode = request.getParameter("city");
		String areaCode = request.getParameter("area");
		String memberAddress = request.getParameter("memberAddress");
		String memberPostcode = request.getParameter("memberPostcode");
		String memberTelephone = request.getParameter("memberTelephone");
	
		/*注册信息*/
		String verifyCode = (String)request.getSession().getAttribute("validateCode");
		if(!validateCode.equalsIgnoreCase(verifyCode)) {
			out.print("<script>alert('验证码错误!');history.back()</script>");
		}
		
		/*设置Member基本信息*/
		Member member = new Member();
		member.setMemberName(memberName);
		member.setMemberPassword(memberPassword);
		member.setMemberEmail(memberEmail);
		//System.out.println("********************************");
		/*设置MemberAddressBook地址信息*/
		MemberAddressBook memberAddressBook = new MemberAddressBook();
		memberAddressBook.setMemberTrueName(memberTrueName);
		memberAddressBook.setMemberAddress(memberAddress);
		memberAddressBook.setProvinceCode(provinceCode);
		memberAddressBook.setCityCode(cityCode);
		memberAddressBook.setAreaCode(areaCode);
		memberAddressBook.setMemberPostcode(memberPostcode);
		memberAddressBook.setMemberTelephone(memberTelephone);
		
		MemberDaoImpl memberDaoImpl = (MemberDaoImpl)DaoFactory.getfactory().getDaoImpl("memberDaoImpl");
		
		//System.out.println("********************************");
		if(memberDaoImpl.addMember(member, memberAddressBook)) {
			//System.out.println("********************************");
			HttpSession session = request.getSession();
			session.setAttribute("memberName", memberName);
			session.setAttribute("memberID", memberDaoImpl.selectMemberID(memberName));
			out.println("<script>alert('注册成功！');location.href='index'</script>");
		} else {
			out.println("<script>alert('注册失败！');history.back()</script>");
		}
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
