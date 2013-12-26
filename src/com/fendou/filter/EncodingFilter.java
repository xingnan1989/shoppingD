package com.fendou.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{
	private String Encoding;
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//System.out.println("Encoding"+Encoding);
		request.setCharacterEncoding(Encoding);
		response.setCharacterEncoding(Encoding);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		Encoding=config.getInitParameter("Encoding");
		
	}

}
