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

public class PlacardInsert extends HttpServlet {

	public PlacardInsert() {
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
		HttpSession session=request.getSession();
		DaoFactory df=DaoFactory.getfactory();
		PlacardDao pd=(PlacardDao)df.getDaoImpl("placarddaoimpl");
//		private long placardID;//	公告ID	bigint
//		private String placardTitle;//	公告标题	Varchar(100)
//		private String placardContent;//	公告内容	Varchar(4000)
//		private String issueDate;//	开始有效时间	datetime
//		private String expireDate;//过期时间	datetime
//		private String creater;//	发公告者	String
//		private String createDate;//发表确定时间		datetime
//		private String updater;//	修改者	String
//		private String updateDate;//	修改时间	datetime
		String placardTitle=request.getParameter("title");
		String placardContent=request.getParameter("content");
		String issueDate=request.getParameter("inputBirthday");
		String expireDate=request.getParameter("expireDate");
		String creater=(String)session.getAttribute("userName");
		String updater=(String)session.getAttribute("userName");
		//System.out.println(updater);
		Placard p=new Placard();
		p.setPlacardTitle(placardTitle);
		p.setPlacardContent(placardContent);
		p.setIssueDate(issueDate);
		p.setExpireDate(expireDate);
		p.setCreater(creater);
		p.setUpdater(updater);
		pd.insertPlacard(p);
		response.sendRedirect("PlacardSelect");
		//request.getRequestDispatcher("PlacardSelect").forward(request,response);
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
