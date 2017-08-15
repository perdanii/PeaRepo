package com.pea.annotations.jsr250;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	   public static void main(String[] args) {
		      AbstractApplicationContext context = new ClassPathXmlApplicationContext("BeansWithAnnotations.xml");

		      HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		      obj.getMessage();
		      context.registerShutdownHook();
		   }
}
