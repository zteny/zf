package com.zhteny.framework.ioc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhteny.framework.ioc.cfg.ControllerConfig;

public class ControllerContext {
	private static final ThreadLocal<ControllerContext> threadContext = new ThreadLocal<ControllerContext>();
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ControllerConfig ctlConfig;
	
	private ControllerContext(){}
	
	public static ControllerContext getInstance(){
		if(threadContext.get() == null){
			threadContext.set(new ControllerContext());
		}
		return threadContext.get();
	}
	
	public ControllerContext init(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
		
		
		return null;
	}
	
	public void cleanup(){
		threadContext.set(null);
	}
	
	public ControllerContext getThreadContext(){
		return threadContext.get();
	}
	
	public static void main(String[] args) {
	}

}
