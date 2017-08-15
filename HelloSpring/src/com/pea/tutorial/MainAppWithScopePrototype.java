package com.pea.tutorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppWithScopePrototype {
   public static void main(String[] args) {
      AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
      HelloWorld objA = (HelloWorld)context.getBean("helloWorld");
      objA.getMessage1();

      objA.setMessage1("I'm object A.");
      objA.getMessage1();
      
      HelloWorld objB = (HelloWorld)context.getBean("helloWorld");
      objB.getMessage1();
   }
}
