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
import com.fendou.pagination.po.Pagination;
import com.fendou.placard.dao.PlacardDao;

public class OrderShopcarPagination extends HttpServlet {

	public OrderShopcarPagination() {
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
		ArrayList car=(ArrayList)session.getAttribute("car");
		//System.out.println("car:"+car);
		if(car != null  ){
			if(car.size()!=0){
				Pagination page = new Pagination();
				int totalRecord = car.size();
				//System.out.println("car:"+totalRecord);
				page.setTotalRecord(totalRecord);
				int currentPage = 1;
				if(request.getParameter("page")!=null) {
					currentPage = Integer.parseInt(request.getParameter("page"));
				}
				//System.out.println("currentPage:"+currentPage);
				page.setCurrentPage(currentPage);
				int currentPageRecord = 10;
				page.setCurrentPageRecord(currentPageRecord);
				page.setTotalPage(currentPageRecord);
				//System.out.println("totalPage:"+totalPage);
				//������������ҳ������ʾ
				ArrayList car2=new ArrayList();;
				
				int carlength=0;
				//System.out.println("currentPageRecord:"+currentPageRecord);
				for(int i=0;i<currentPageRecord;i++){
					
					carlength++;
					//System.out.println("carlength:"+carlength);
					car2.add(car.get(currentPage*currentPageRecord+i-currentPageRecord));
					//System.out.println("��"+(currentPage*currentPageRecord+i-currentPageRecord)+"����Ʒ");
					
					if(carlength==car.size()-(currentPage*currentPageRecord-currentPageRecord)){
						break;
					}
				}
				//System.out.println("------------------------");
				//System.out.println("car2:"+car2.size());
				session.setAttribute("car2", car2);
				session.setAttribute("page", page);
			}
		}
		
		request.getRequestDispatcher("/WEB-INF/show/cart_add.jsp").forward(request,response);
		out.close();
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
