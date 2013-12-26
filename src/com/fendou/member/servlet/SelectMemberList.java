package com.fendou.member.servlet;

import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fendou.factory.DaoFactory;
import com.fendou.member.impl.MemberDaoImpl;
import com.fendou.member.po.MemberList;
import com.fendou.util.FPageBean;

public class SelectMemberList extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String path="";
	private String memberTip="";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageSize = 1;
		MemberDaoImpl memberDaoImpl = (MemberDaoImpl)DaoFactory.getfactory().getDaoImpl("memberDaoImpl");
		
		try {
			//�õ���Ա�ܼ�¼��
			int totalCount=memberDaoImpl.getMemberTotleCount();
			FPageBean fpage=new FPageBean();
			//�����ܼ�¼��
			fpage.setReportTotal(totalCount);
			// ���õ�ǰҳ����
			fpage.setPageSize(pageSize);
			// ����ÿҳ��ʾ������
			fpage.setPageNumber(5);
			// �����ܵ�ҳ����
			fpage.setPageTotal();
			// �����Ƿ�����/��һҳ
			fpage.setNext();
			fpage.setUp();
			
			List<MemberList> memberList=memberDaoImpl.selectMemberList(fpage);
			if(memberList!=null && memberList.size()>0){
				request.setAttribute("memberList", memberList);
				request.setAttribute("page", fpage);
			}else{
				memberTip="会员管理!";
				request.setAttribute("memberTip", memberTip);
			}
			path="/WEB-INF/manager/memberManage.jsp";
		} catch (Exception e) {
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
