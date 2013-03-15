package com.zhteny.framework.ioc.cfg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

public class PackageConfig {
	private String namespace;
	private Map<String,ControllerConfig> ctlCfg = new HashMap();
	
	public PackageConfig(String namespace, List<Element> controller) {
		this.namespace = namespace;
		
		for(Element e : controller){
			System.out.println(e.selectNodes("result"));
			ctlCfg.put(e.attributeValue("name"), new ControllerConfig(
					e.attributeValue("name"),
					e.attributeValue("method"),
					e.attributeValue("class"),
					e.selectNodes("result"))
			);
		}
	}
	public ControllerConfig getControllerConfig(String name){
		return ctlCfg.get(name);
	}
}
