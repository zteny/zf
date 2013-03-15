package com.zhteny.framework.ioc.controller;

import java.lang.reflect.Method;

import com.zhteny.framework.ioc.cfg.ControllerConfig;
import com.zhteny.framework.ioc.cfg.ResultConfig;
import com.zhteny.framework.ioc.container.Container;

public class ControllerProxy {
	private ControllerConfig config;
	private ResultConfig result;
	private Method method;
	private Class clazz;
	private Controller controller;
	
	public ControllerProxy(){
		ControllerContext context = ControllerContext.getInstance();
		controller = context.getController();
		config = controller.getControllerConfig();
	}
	
	private void initProxy(ControllerContext context){
		this.config = config;
		config.getClassName();
		config.getMethod();
	}
	
	public ResultConfig execute(){
		return null;
	}
	
	public Controller getController(){
		return controller;
	}
	public String getControllerName(){
		return config.getName();
	}
	public ResultConfig getResult(){
		return result;
	}
	public Class getControllerClass(){
		return null;
	}
}
