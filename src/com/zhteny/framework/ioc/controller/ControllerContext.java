package com.zhteny.framework.ioc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhteny.framework.ioc.cfg.ControllerConfig;
import com.zhteny.framework.ioc.container.Container;

public class ControllerContext {
	private static final ThreadLocal<ControllerContext> threadContext = new ThreadLocal<ControllerContext>();
	private static Container container;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Controller controller;
	private ControllerProxy proxy;
	
	private ControllerContext(){}
	
	public static Container getContainer() {
		return container;
	}

	public static void setContainer(Container container) {
		ControllerContext.container = container;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public ControllerProxy getProxy() {
		return proxy;
	}

	public void setProxy(ControllerProxy proxy) {
		this.proxy = proxy;
	}

	public static ControllerContext getInstance(){
		if(threadContext.get() == null){
			threadContext.set(new ControllerContext());
		}
		return threadContext.get();
	}
	
	public ControllerContext init(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
		controller = Container.getInstance().findController(request.getRequestURI());
		proxy =controller.newControllerProxy();
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
