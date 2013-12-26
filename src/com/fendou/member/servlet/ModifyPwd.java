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

public class ModifyPwd extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String memberName = (String) session.getAttribute("memberName");
		String oldpwd = request.getParameter("oldpwd");
		String newpwd = request.getParameter("newpwd");
		MemberDaoImpl memberDaoImpl = (MemberDaoImpl) DaoFactory.getfactory()
				.getDaoImpl("memberDaoImpl");
		if (memberDaoImpl.validMemberPassword(memberName, oldpwd)) {
			if (newpwd.length() < 6 || newpwd.length() > 16) {
				out.print("<script>alert('请输入6-16长的密码！');history.back()</script>");
			} else {
				if (memberDaoImpl.modifyMemberPassword(memberName, newpwd)) {
					out.print("<script>alert('修改成功！');location.href='ShowMemberInfo'</script>");
				} else {
					out.print("<script>alert('修改失败！');history.back()</script>");
				}
			}
		} else {
			out.print("<script>alert('修改密码失败，请重新修改！');history.back()</script>");
		}

	}

}
