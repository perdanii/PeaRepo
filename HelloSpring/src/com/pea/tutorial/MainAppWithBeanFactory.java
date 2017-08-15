package com.pea.tutorial;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class MainAppWithBeanFactory {
	public static void main(String[] args) { 
		// BeanFactory can still be used for lightweight applications 
		// like mobile devices or applet-based applications
	      XmlBeanFactory factory = new XmlBeanFactory (new ClassPathResource("Beans.xml")); 
	      HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");    
	      obj.getMessage1();    
	   }
}
