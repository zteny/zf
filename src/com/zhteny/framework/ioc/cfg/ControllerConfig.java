package com.zhteny.framework.ioc.cfg;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.dom4j.Element;

public class ControllerConfig {
	private String name;
	private String method;
	private String className;
	private Set<ResultConfig> resultCfg = new HashSet();
	
	public ControllerConfig(String name, String method, String className, List<Element> resultConfig){
		this.name = name;
		this.method = method;
		this.className = className;
		
		for(Element e : resultConfig){
			this.resultCfg.add(new ResultConfig(e.attributeValue("type"),e.getText()));
		}
	}
	
	public String getName(){
		return name;
	}
	public String getMethod(){
		return method;
	}
	public String getClassName(){
		return className;
	}
}
