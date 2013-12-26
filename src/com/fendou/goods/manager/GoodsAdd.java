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

public class GoodsAdd extends HttpServlet {
	
	String realPath;
	public void init(ServletConfig config) throws ServletException {
		String path = config.getServletContext().getRealPath("/");
		realPath = path+"/upLoad";
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdir();
		}
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		ArrayList al = new ArrayList();
		String fileName = "";
		String update=(String)session.getAttribute("userName");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				Iterator items = upload.parseRequest(request).iterator();
				while(items.hasNext()) {
					FileItem item = (FileItem)items.next();
					if(!item.isFormField()) {
						String filePath = item.getName();
						fileName = filePath.substring(filePath.lastIndexOf("\\"),filePath.length());
						item.write(new File(realPath+fileName));
					} else {
						if(item.getFieldName().equals("supertype")||item.getFieldName().equals("typeID")||item.getFieldName().equals("goodsName")||item.getFieldName().equals("markprice")||item.getFieldName().equals("memberprice")||item.getFieldName().equals("rebate")||item.getFieldName().equals("sale")||item.getFieldName().equals("introduce")) {
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
			T_Goods goods = new T_Goods();
			goods.setUpdater(update);
			goods.setCreater(update);
			goods.setGoodsIntroduce(al.get(7).toString());
			goods.setGoodsMemberPrice(Float.valueOf(al.get(4).toString()));
			goods.setGoodsName(al.get(2).toString());
			goods.setGoodsNormalPrice(Float.valueOf(al.get(3).toString()));
			goods.setIsSale(al.get(6).toString());
			goods.setGoodsPicture("upLoad/"+fileName);
			System.out.println("upLoad"+fileName);
			goods.setTypeCode(al.get(1).toString());
			goods.setGoodsRebate(Float.valueOf(al.get(5).toString()));
			DaoFactory daoFactory = DaoFactory.getfactory();
			GoodsDao goodsDao = (GoodsDao)daoFactory.getDaoImpl("goodsdao");
			if(goodsDao.insertGoods(goods) > 0) {
				request.getRequestDispatcher("SelectGoods").forward(request,response);
			} else {
				out.print("<script>alert('添加失败')</script>");
			}
		}
		out.flush();
		out.close();
	}

	
	

}
