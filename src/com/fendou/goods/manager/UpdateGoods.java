package com.fendou.goods.manager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fendou.factory.DaoFactory;
import com.fendou.goods.dao.GoodsDao;
import com.fendou.goods.po.T_Goods;

public class UpdateGoods extends HttpServlet {

	String filePath;
	public void init(ServletConfig config) {
		String root = config.getServletContext().getRealPath("/");
		filePath = root+"/upLoad";
		File file = new File(filePath); 
		if(!file.exists()) {
			file.mkdir();
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		String create=(String)session.getAttribute("userName");
		//System.out.println("create:"+create);
		ArrayList al = new ArrayList();
		String fileName="";
		boolean isMulitpart = ServletFileUpload.isMultipartContent(request);
		
		if(isMulitpart) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				Iterator items = upload.parseRequest(request).iterator();
				while(items.hasNext()) {
					FileItem item = (FileItem)items.next();
					if(!item.isFormField()) {
						String path = item.getName();
						if(path!=null&&path!="") {
							fileName = path.substring(path.lastIndexOf("\\"), path.length());
							al.add("upLoad"+fileName);
							item.write(new File(filePath+fileName));
						}				
					} else {
						if(item.getFieldName().equals("supertype")||item.getFieldName().equals("typeID")||item.getFieldName().equals("goodsName")||item.getFieldName().equals("markprice")||item.getFieldName().equals("memberprice")||item.getFieldName().equals("rebate")||item.getFieldName().equals("sale")||item.getFieldName().equals("introduce")){
							String str = item.getString("UTF-8");
							al.add(str);
						}
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		T_Goods goods = new T_Goods();	
		if(al.size() == 8) {
			goods.setUpdater(create);
			goods.setGoodsIntroduce(al.get(7).toString());
			/*
			for(int i=0;i<al.size();i++){
				System.out.println("Introduce18:"+al.get(i).toString());
			}*/
			goods.setGoodsMemberPrice(Float.valueOf(al.get(4).toString()));
			goods.setGoodsName(al.get(2).toString());
			goods.setGoodsNormalPrice(Float.valueOf(al.get(3).toString()));
			goods.setIsSale(al.get(6).toString());
			goods.setTypeCode(al.get(1).toString());
			goods.setGoodsRebate(Float.valueOf(al.get(5).toString()));
			goods.setGoodsID(Integer.parseInt(request.getParameter("goodsID")));
			DaoFactory daoFactory = DaoFactory.getfactory();
			GoodsDao goodsDao = (GoodsDao)daoFactory.getDaoImpl("goodsdao");
			String currentPage = request.getParameter("currentPage");
			request.setAttribute("currentPage1", currentPage);
			//System.out.println(currentPage+"!!!!!!!");
			if(goodsDao.updateGoods1(goods) > 0) {
				request.getRequestDispatcher("SelectGoods").forward(request,response);
			}
		} else if(al.size() == 9) {
			goods.setUpdater(create);
			goods.setGoodsIntroduce(al.get(8).toString());
			//System.out.println("Introduce1:"+al.get(2).toString());
			/*
			for(int i=0;i<al.size();i++){
				System.out.println("Introduce1"+i+":"+al.get(i).toString());
			}
			*/
			goods.setGoodsMemberPrice(Float.valueOf(al.get(4).toString()));
			goods.setGoodsName(al.get(2).toString());
			goods.setGoodsNormalPrice(Float.valueOf(al.get(3).toString()));
			goods.setIsSale(al.get(6).toString());
			goods.setGoodsPicture(al.get(7).toString());
			goods.setTypeCode(al.get(1).toString());
			goods.setGoodsRebate(Float.valueOf(al.get(5).toString()));
			goods.setGoodsID(Integer.parseInt(request.getParameter("goodsID")));
			DaoFactory daoFactory = DaoFactory.getfactory();
			String currentPage = request.getParameter("currentPage");
			request.setAttribute("currentPage1", currentPage);
			GoodsDao goodsDao = (GoodsDao)daoFactory.getDaoImpl("goodsdao");
			if(goodsDao.updateGoods(goods) > 0) {
				request.getRequestDispatcher("SelectGoods").forward(request,response);
			}
		}
		out.flush();
		out.close();
	}

}
