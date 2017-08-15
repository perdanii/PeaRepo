package com.pea.tutorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring Tutorial: https://www.tutorialspoint.com/spring/index.htm
 */
public class MainApp {
   public static void main(String[] args) {
      AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
      HelloWorld objA = (HelloWorld)context.getBean("helloWorld");
      objA.getMessage1();
      objA.getMessage2();
      
      HelloIndia objB = (HelloIndia) context.getBean("helloIndia");
      objB.getMessage1();
      objB.getMessage2();
      objB.getMessage3();
      
      context.registerShutdownHook(); //ensure a graceful shutdown and call the relevant destroy methods.
   }
}
