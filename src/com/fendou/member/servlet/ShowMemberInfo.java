package com.fendou.member.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fendou.factory.DaoFactory;
import com.fendou.member.impl.MemberDaoImpl;
import com.fendou.member.impl.ProvinceDaoImpl;
import com.fendou.member.po.AreaList;
import com.fendou.member.po.Member;
import com.fendou.member.po.MemberAddressBook;
import com.fendou.order.dao.OrderDao;
import com.fendou.order.po.Province;

public class ShowMemberInfo extends HttpServlet {

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
		HttpSession session = request.getSession();
		String memberName = (String) session.getAttribute("memberName");
		MemberDaoImpl memberDaoImpl = (MemberDaoImpl)DaoFactory.getfactory().getDaoImpl("memberDaoImpl");
		ProvinceDaoImpl provinceDaoImpl = (ProvinceDaoImpl)DaoFactory.getfactory().getDaoImpl("provinceDaoImpl");
		long memberID = memberDaoImpl.queryMemberID(memberName);
		MemberAddressBook memberAddressBook = null;
		if(memberID != 0) {
			Member member = memberDaoImpl.queryMember(memberID);
			memberAddressBook = memberDaoImpl.queryMemberAddress(memberID);
			AreaList areaList = provinceDaoImpl.getAreaList(memberAddressBook.getProvinceCode(),
					memberAddressBook.getCityCode(), memberAddressBook.getAreaCode());
			request.setAttribute("member", member);
			request.setAttribute("memberAddressBook", memberAddressBook);
			request.setAttribute("areaList",areaList);
			
			
			//System.out.println("Address:"+memberAddressBook.getMemberAddress());
			//地址详细信息
			DaoFactory df=DaoFactory.getfactory();
			OrderDao od=(OrderDao)df.getDaoImpl("orderdaoimpl");
			
			//System.out.println(mab.getProvinceCode());
			String province=od.selectProvinceCode(memberAddressBook.getProvinceCode());
			request.setAttribute("province", province);
			request.setAttribute("provinceCode", memberAddressBook.getProvinceCode());
			//System.out.println(province);

			String city=od.selectCityCode(memberAddressBook.getCityCode());
			//System.out.println(mab.getCityCode());
			request.setAttribute("city", city);
			request.setAttribute("cityCode", memberAddressBook.getCityCode());
			
			String area=od.selectAreaCode(memberAddressBook.getAreaCode());
			request.setAttribute("area", area);
			request.setAttribute("areaCode", memberAddressBook.getAreaCode());
			
			
			
			//地址
			
			ArrayList<Province> p_al=od.selectProvince();
			String prvoince="";
			for(int i=0;i<p_al.size();i++){
				Province p=p_al.get(i);
				prvoince+="|"+p.getProvinceCode()+","+p.getProvince();
				
			}
			session.setAttribute("p_al2",p_al);
		}
		
		request.getRequestDispatcher("/WEB-INF/show/member.jsp").forward(request,response);
	}


}
