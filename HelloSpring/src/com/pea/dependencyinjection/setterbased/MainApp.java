package com.pea.dependencyinjection.setterbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
	      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

	      TextEditor te = (TextEditor) context.getBean("textEditor2");
	      te.spellCheck();
	   }
}
