package com.pea.annotations.javabasedconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
   public static void main(String[] args) {
	   ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
	   
	   HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
	   helloWorld.setMessage1("Hello World with java-based config!");
	   helloWorld.getMessage1();
   }
}
