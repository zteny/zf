package com.zhteny.framework.ioc.cfg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Configuration {
	private static Map<String, PackageConfig> pkgConfig;
	private static Map<String, ControllerConfig> ctlConfig;
	private static Configuration cfg;
	
	private Configuration(){}
	
	public static Configuration getInstance(){
		if(cfg == null){
			cfg = new Configuration();
			cfg.init();
		}
		return cfg;
	}
	
	// 先加载 controller.xml 再找到其下的一些xml文件，再把全部相关XML文件的package、controller加载进来
	public void init(){ 
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(this.getClass().getResourceAsStream("/controller.xml"));
			List<Element> files = document.selectNodes("//controller/include");
			List<Element> packs = document.selectNodes("//controller/package");
			
			for(Element e : files){
				Set<String> fileName = new HashSet<String>();
				fileName.add(e.attributeValue("file"));
				System.out.println(e.attributeValue("file"));
				
				Document doc = saxReader.read(this.getClass().getResourceAsStream(e.attributeValue("file")));
				packs.addAll(doc.selectNodes("//package"));
			}
			
			pkgConfig = getPackageConfig(packs);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	protected Map<String, PackageConfig> getPackageConfig(List<Element> packageConfigs){
		Map<String, PackageConfig> pkgConfig = new HashMap();
		
		for(Element pack : packageConfigs){
			pkgConfig.put(pack.attributeValue("namespace"), 
					new PackageConfig(pack.attributeValue("namespace"),
							pack.selectNodes("controller"))
			);
		}
		System.out.println(pkgConfig.size());
		return pkgConfig;
	}
	
	public Map<String, PackageConfig> getPackageConfig(){
		return this.pkgConfig;
	}

	public ControllerConfig getController(String uri) {
		int pos = uri.lastIndexOf("/");
		
		String namespace = uri.substring(0,uri.lastIndexOf("/"));
		String controller = uri.substring(pos+1);
		
		System.out.println(namespace + "\t" + controller);

		PackageConfig pkg = pkgConfig.get(namespace);
		return pkg.getControllerConfig(controller);
	}
	
	public static void main(String args[]){
		getInstance().getController("/testAction");
	}
}
