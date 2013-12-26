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

import com.fendou.bill.impl.BillDaoImpl;
import com.fendou.bill.po.T_Bill;
import com.fendou.factory.DaoFactory;

public class UpdataBill extends HttpServlet {


	String path;
	ArrayList al;
	public void init(ServletConfig config) throws ServletException {
		String root = config.getServletContext().getRealPath("/");
		path = root+"upLoad";
		File file = new File(path); 
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
		PrintWriter out =response.getWriter();
		HttpSession session = request.getSession();
		T_Bill bill = new T_Bill();
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
						if(name!=null&&name!="") {
							String picType = name.substring(name.lastIndexOf(".")+1,name.length());
							if(!"jpg".equalsIgnoreCase(picType)&&!"gif".equalsIgnoreCase(picType)) {
								out.println("<script>alert('上传图片格式不正确！');location.href='bill_modify.jsp';</script>");
								out.flush();
								out.close();
								break;
							}else{
									fileName = name.substring(name.lastIndexOf("\\"),name.length()); 
									iter.write(new File(path+"\\"+fileNameUpload));
									al.add(name);
								}
						}
					} else {
						if(iter.getFieldName().equals("billOrder")||iter.getFieldName().equals("billStatus")||iter.getFieldName().equals("hidd")) {
							String s =new String(iter.getString("UTF-8"));
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
		DaoFactory factory = DaoFactory.getfactory();
		BillDaoImpl billDao = (BillDaoImpl)factory.getDaoImpl("billdao");
		if(al.size() == 4) {
			for(int i=0;i<al.size();i++) {
			}
			bill.setBillCreateUser((String)session.getAttribute("userName"));
			bill.setBillOrder(Integer.parseInt(al.get(1).toString()));
			bill.setBillStatus(al.get(2)+"");
			bill.setBillPicPath("upLoad/"+fileName);
			bill.setBillId(Integer.parseInt(al.get(3).toString()));	
			if(billDao.update(bill) > 0) {
				request.getRequestDispatcher("SelectBill").forward(request,response);
			}
		}
		if(al.size() == 3) {
			bill.setBillCreateUser((String)session.getAttribute("userName"));
			bill.setBillOrder(Integer.parseInt(al.get(0).toString()));
			bill.setBillStatus(al.get(1)+"");
			bill.setBillId(Integer.parseInt(al.get(2).toString()));	
			if(billDao.updateThree(bill) > 0) {
				request.getRequestDispatcher("SelectBill").forward(request,response);
			}
		}
	}

	
	

}
