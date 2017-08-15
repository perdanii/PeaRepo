package com.pea.java8;

/**
 * https://www.tutorialspoint.com/java8/java8_lambda_expressions.htm
 * 
 * Using lambda expression, you can refer to final variable or effectively final variable 
 * (which is assigned only once). Lambda expression throws a compilation error, 
 * if a variable is assigned a value the second time. 
 */
public class LambdaFinalVariable {
	   final static String salutation = "Hello! ";
	   
	   public static void main(String args[]){
	      GreetingService greetService1 = message -> 
	      System.out.println(salutation + message);
	      greetService1.sayMessage("Mahesh");
	   }
		
	   interface GreetingService {
	      void sayMessage(String message);
	   }
}
