package com.fendou.order.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fendou.factory.DaoFactory;
import com.fendou.order.dao.OrderDao;
import com.fendou.order.po.OrderPayMode;

public class OrderPayModeUpdate extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		DaoFactory df=(DaoFactory)DaoFactory.getfactory();
		OrderDao od=(OrderDao)df.getDaoImpl("orderdaoimpl");
		ArrayList<OrderPayMode> al_opm=(ArrayList)od.selectOrderPayMode();
		OrderPayMode opm=null;
		String str="0,请选择";
		for(int i=0;i<al_opm.size();i++){
			opm=al_opm.get(i);
			str+=opm.getPayID()+","+opm.getPayContent()+"|";
		}
		out.print(str);
		out.close();
	}

}
