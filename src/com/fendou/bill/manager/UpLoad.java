package com.fendou.bill.manager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

public class UpLoad extends HttpServlet {

	String path;
	public void init(ServletConfig config) throws ServletException {
		String root = config.getServletContext().getRealPath("/");
		path = root+"/upLoad";
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
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		String fileName = null;
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
						//System.out.println(name);
						fileName = name.substring(name.lastIndexOf("\\"),name.length()); 
						//System.out.println(fileName);
						iter.write(new File(path+fileName));
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(request.getParameter("sub"));
		//System.out.println(""+root+"upLoad"+fileName); 
		session.setAttribute("file", "upLoad"+fileName);
		//request.getRequestDispatcher("bill_add.jsp").forward(request, response);
		out.flush();
		out.close();
	}

	
}
