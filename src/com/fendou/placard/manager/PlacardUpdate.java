package com.fendou.placard.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fendou.factory.DaoFactory;
import com.fendou.placard.dao.PlacardDao;
import com.fendou.placard.po.Placard;

public class PlacardUpdate extends HttpServlet {

	public PlacardUpdate() {
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
		HttpSession session = request.getSession();
		long placardID=Long.parseLong(request.getParameter("placardID"));
		//System.out.println("placardID:"+placardID);
		String placardTitle=request.getParameter("title");//	获得所修改公告标题	Varchar(100)
		String placardContent=request.getParameter("content");//	获得其内容	Varchar(4000)
		String issueDate=request.getParameter("inputBirthday");//	开始有效时间	datetime
		String expireDate=request.getParameter("expireDate");//		开始失效时间datetime
		String updater=(String)session.getAttribute("userName");//	修改者名称	String
		//System.out.println("updater:"+updater);
		Placard placard=new Placard();
		placard.setPlacardID(placardID);
		placard.setPlacardTitle(placardTitle);
		placard.setPlacardContent(placardContent);
		placard.setIssueDate(issueDate);
		placard.setExpireDate(expireDate);
		placard.setUpdater(updater);
		//System.out.println("placardTitle:"+placardTitle+" placardContent:"+placardContent+" :issueDate"+issueDate+" expireDate:"+expireDate+" userName:"+updater);
		DaoFactory df=DaoFactory.getfactory();
		PlacardDao pd=(PlacardDao)df.getDaoImpl("placarddaoimpl");
		pd.updatePlacard(placard);
		request.getRequestDispatcher("PlacardSelect").forward(request, response);
		out.close();
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
