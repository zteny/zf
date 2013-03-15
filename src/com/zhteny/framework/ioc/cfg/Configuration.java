package com.zhteny.framework.ioc.cfg;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Configuration {
	private static Map<String, PackageConfig> pkgConfig;
	private static Map<String, ControllerConfig> ctlConfig;
	
	private Configuration(){}
	
	// 先加载 controller.xml 再找到其下的一些xml文件，再把全部相关XML文件的package、controller加载进来
	public void init(){ 
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(this.getClass().getResourceAsStream("/controller.xml"));
			List<Element> list = document.selectNodes("//controller/include");
			List<Element> pack = document.selectNodes("//controller/package");
			
			for(Element e : list){
				System.out.println(e.attributeValue("file"));
			}
			
			for(Element e : pack){
				
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	protected List<Element> getPackageConfig(List<Element> fileList){
		return new ArrayList();
	}
	
	protected List<ControllerConfig> getControllerConfig(List<Element> packageConfig){
		return new ArrayList();
	}
	
	public static void main(String[] args){
		Configuration cfg = new Configuration();
		cfg.init();
	}
}
