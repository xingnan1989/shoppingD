package com.fendou.order.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fendou.factory.DaoFactory;
import com.fendou.order.dao.OrderDao;
import com.fendou.order.po.MemberAddressBook;
import com.fendou.order.po.OrderCarryMode;
import com.fendou.order.po.OrderCarryTime;
import com.fendou.order.po.OrderPayMode;
import com.fendou.order.po.Province;

public class OrderShopcarCheckout extends HttpServlet {

	public OrderShopcarCheckout() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		DaoFactory df=DaoFactory.getfactory();
		OrderDao od=(OrderDao)df.getDaoImpl("orderdaoimpl");
		//int memberID=session.getAttribute("memberID");
		long memberID=(Long)session.getAttribute("memberID");
		MemberAddressBook mab=(MemberAddressBook)od.selectMemberAddressBook(memberID);
		session.setAttribute("mab", mab);//地址
		//System.out.println(mab.getMemberAddress());
		
		//获得该用户的住址
		//System.out.println(mab.getProvinceCode());
		String province=od.selectProvinceCode(mab.getProvinceCode());
		request.setAttribute("province", province);
		request.setAttribute("provinceCode", mab.getProvinceCode());
		//System.out.println(province);

		String city=od.selectCityCode(mab.getCityCode());
		//System.out.println(mab.getCityCode());
		request.setAttribute("city", city);
		request.setAttribute("cityCode", mab.getCityCode());
		
		String area=od.selectAreaCode(mab.getAreaCode());
		request.setAttribute("area", area);
		request.setAttribute("areaCode", mab.getAreaCode());		

		//获得省份等地址
		ArrayList<Province> p_al=od.selectProvince();
		String prvoince="";
		for(int i=0;i<p_al.size();i++){
			Province p=p_al.get(i);
			prvoince+="|"+p.getProvinceCode()+","+p.getProvince();
			
		}
		//System.out.println("prvoince省"+prvoince);
		//System.out.println("size="+p_al.size());
		session.setAttribute("p_al",p_al);
		//System.out.println(mab.getProvinceCode());
		
		//支付手段，默认为第一种
		OrderPayMode opm=od.selectOrderPayMode_id("1");
		session.setAttribute("opm",opm);
		
		//订单类型，默认为1
		OrderCarryMode ocm=od.selectOrderCarryMode_id("1");
		session.setAttribute("ocm", ocm);
		
		//获得订单时间OrderCarryTime
		ArrayList<OrderCarryTime> octal=od.selectOrderCarryTime();
		session.setAttribute("octal", octal);
			
		request.getRequestDispatcher("/WEB-INF/show/cart_checkout.jsp").forward(request,response);
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
