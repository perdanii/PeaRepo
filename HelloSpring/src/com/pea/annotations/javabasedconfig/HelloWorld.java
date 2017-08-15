package com.pea.annotations.javabasedconfig;

public class HelloWorld {
	private String message1;
	private String message2;
	
	public void setMessage1(String message1){
		this.message1  = message1;
	}
	public void setMessage2(String message2){
		this.message2  = message2;
	}
	
	public void getMessage1(){
		System.out.println("World2 Message1 : " + message1);
	}
	public void getMessage2(){
		System.out.println("World2 Message2 : " + message2);
	}
	
	public void init(){
		System.out.println("HelloWorld2 Bean is going through init.");
	}
	
	public void destroy() {
		System.out.println("HelloWorld2 Bean will destroy now.");
	}
}
