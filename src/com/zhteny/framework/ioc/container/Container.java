package com.zhteny.framework.ioc.container;

import java.util.concurrent.CopyOnWriteArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhteny.framework.ioc.cfg.Configuration;
import com.zhteny.framework.ioc.cfg.ControllerConfig;
import com.zhteny.framework.ioc.controller.Controller;
import com.zhteny.framework.ioc.controller.ControllerContext;
import com.zhteny.framework.ioc.controller.ControllerProxy;

/**
 * package configuration information 
 * 
 * @author Teny Zh
 *
 */
public class Container {
//	private static CopyOnWriteArrayList<ControllerConfig> pkgConfig = null;
	
	private static Container container;
	private static Configuration cfg;

	private Container(){}
	
	public static Container getInstance(){
		if(container == null){
			container = new Container();
			container.init();
		}
		return container;
	}
	
	public void init(){
		cfg = Configuration.getInstance();
	}
	
	public ControllerProxy controllerService(HttpServletRequest request, HttpServletResponse response){
		Controller
		ControllerContext context = ControllerContext.getInstance().init(request,response);
		
		
		return null;
	}
	
	public Controller findController(String uri){
		cfg.getController(uri);
		return null;
	}
}
