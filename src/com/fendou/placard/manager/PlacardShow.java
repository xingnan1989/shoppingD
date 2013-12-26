package com.fendou.placard.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fendou.factory.DaoFactory;
import com.fendou.order.dao.OrderDao;
import com.fendou.placard.dao.PlacardDao;
import com.fendou.placard.po.Placard;

public class PlacardShow extends HttpServlet {

	public PlacardShow() {
		super();
	}

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
		DaoFactory df=DaoFactory.getfactory();
		PlacardDao pd=(PlacardDao)df.getDaoImpl("placarddaoimpl");
		long placardID=Long.parseLong(request.getParameter("placardID"));
		Placard p=pd.selectPlacardToID(placardID);
		System.out.println(p.getCreateDate());
		request.setAttribute("p", p);
		request.getRequestDispatcher("/WEB-INF/show/placard_detail.jsp").forward(request, response);
		out.close();
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
