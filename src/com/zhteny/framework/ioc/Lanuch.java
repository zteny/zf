package com.zhteny.framework.ioc;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Lanuch extends HttpServlet implements Filter {
	

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain arg2) throws IOException, ServletException {
		
		HttpServletRequest requst = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
//		container.findController();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// init container, init configuration
	}

}
