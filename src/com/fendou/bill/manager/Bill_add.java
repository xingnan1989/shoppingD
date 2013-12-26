package com.fendou.bill.manager;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import sun.java2d.pipe.SpanShapeRenderer.Simple;




import com.fendou.bill.dao.BillDao;
import com.fendou.bill.impl.BillDaoImpl;
import com.fendou.bill.po.T_Bill;
import com.fendou.factory.DaoFactory;

public class Bill_add extends HttpServlet {

	String path;
	ArrayList al;
	public void init(ServletConfig config) throws ServletException {
		String root = config.getServletContext().getRealPath("/");
		path = root+"upLoad"+File.separator;
		//System.out.println(path);
		File file = new File(path); 
		if(!file.exists()) {
			file.mkdir();
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		boolean flag = false;
		String fileName = null;
		String fileNameUpload = null;
		al =new ArrayList();
		SimpleDateFormat dateFormate = new SimpleDateFormat("yyyyMMddHHmmss");
		fileNameUpload = dateFormate.format(Calendar.getInstance().getTime());
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart) {
			FileItemFactory factorty = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factorty);
			try {
				Iterator iters = upload.parseRequest(request).iterator();
				while(iters.hasNext()) {
					FileItem iter = (FileItem)iters.next();
					if(!iter.isFormField()) {
						String name = iter.getName();
						String picType = name.substring(name.lastIndexOf(".")+1,name.length());
						if(!"jpg".equalsIgnoreCase(picType)&&!"gif".equalsIgnoreCase(picType)) {
							out.println("<script>alert('您上传的图片格式不正确！');location.href='bill_add.jsp';</script>");
							out.flush();
							out.close();
						}else{
							flag = true;
						    fileName = name.substring(name.lastIndexOf("\\"),name.length());
							iter.write(new File(path+"//"+fileNameUpload));
						}
					} else {
						if(iter.getFieldName().equals("billOrder")||iter.getFieldName().equals("billStatus")) {
							String s =new String(iter.getString("UTF-8"));//使用同一字符编码
							al.add(s);
						}
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		if(flag) {
			T_Bill bill = new T_Bill();
			bill.setBillCreateUser((String)session.getAttribute("userName"));
			bill.setBillOrder(Integer.parseInt(al.get(0).toString()));
			bill.setBillStatus(al.get(1).toString());
			bill.setBillPicPath("upLoad/"+fileName);
			DaoFactory factory = DaoFactory.getfactory();
			BillDaoImpl billDao = (BillDaoImpl)factory.getDaoImpl("billdao");
			if(billDao.insert(bill) > 0 ) {
				request.getRequestDispatcher("SelectBill").forward(request,response);
			}
		}
	}
}
