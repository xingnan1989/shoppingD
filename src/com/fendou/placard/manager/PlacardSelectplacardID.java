package com.fendou.placard.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fendou.factory.DaoFactory;
import com.fendou.placard.dao.PlacardDao;
import com.fendou.placard.po.Placard;

public class PlacardSelectplacardID extends HttpServlet {
	public PlacardSelectplacardID() {
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
		long placardID=Long.parseLong(request.getParameter("placardID"));
		//System.out.println("placardID:"+placardID);
		DaoFactory df=DaoFactory.getfactory();
		PlacardDao pd=(PlacardDao)df.getDaoImpl("placarddaoimpl");
		Placard placard=pd.selectPlacardToID(placardID);
		//System.out.println("PlacardContent:"+placard.getPlacardContent());
		
		request.setAttribute("placard",placard);
		request.getRequestDispatcher("/WEB-INF/manager/placard_modify.jsp").forward(request, response);
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
