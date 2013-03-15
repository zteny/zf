package com.zhteny.framework.ioc.controller;

import com.zhteny.framework.ioc.cfg.ControllerConfig;

public class Controller {
	private ControllerConfig ctlConfig;
	private ControllerProxy proxy;

	public static void main(String[] args) {

	}
	
	public ControllerProxy newControllerProxy(){
		return null;
	}
	
	public ControllerConfig getControllerConfig(){
		return ctlConfig;
	}
}
