package com.pea.java8;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Following are the important points to be considered in the above example.
 * - Lambda expressions are used primarily to define inline implementation of 
 * a functional interface, i.e., an interface with a single method only. 
 * In the above example, we've used various types of lambda expressions to 
 * define the operation method of MathOperation interface. Then we have defined 
 * the implementation of sayMessage of GreetingService.
 * 
 * - Lambda expression eliminates the need of anonymous class and gives a very 
 * simple yet powerful functional programming capability to Java.
 */
public class LambdaStreamExample {

	public static void main(String[] args) {
		getRabatt();
		try { case1(); }catch(RuntimeException e){}
		try { case2(); }catch(RuntimeException e){}
		try { case3(); }catch(RuntimeException e){}
	}

	public static void getRabatt() {
		List<Integer> prices = Arrays.asList(10, 20, 30, 40, 50, 60, 70);
		double result = prices.stream()               // interne Iteration
		  .filter(price -> price >= 42)      // Filter
		  .mapToDouble(price -> price * 0.9) // Map: Rabatt 
		  .sum();                            // Reduce: Gesamtsumme
		
		System.out.println("Rabatt: "+result);
	}
	
	/**
	 * Fall 1: Eine Exception wird geworfen und nicht mit try-catch behandelt. 
	 * Dieses Beispiel gibt nur ein a aus. Denn der zweite String defgh ist zu lang und 
	 * löst die RuntimeException aus, was die Stream-Verarbeitung beendet. 
	 * Der letzte String ijk wird nicht mehr behandelt.
	 * --> Ausgabe: "a,"
	 */
	public static void case1(){
		System.out.println("\nstart case 1...");
		String[] test = { "abc", "defgh", "ijk" };
		// Stream wird aufgebaut
		Stream<Character> s = Arrays.stream(test).
		map(t -> {
		// gezielte Exception fuer alle Strings mit Laenge > 3
		if (t.length()>3) throw new RuntimeException("error");
		return t.charAt(0);
		});
		// Stream wird konsumiert
		s.forEach( c -> System.out.print(c.charValue() + ",") );
	}
		
	/**
	 * Fall 2: Eine Ausnahme wird geworfen, aber explizit in der intermediären Operation 
	 * mit try-catch behandelt. Das nachstehende Beispiel gibt also das erste Zeichen 
	 * aller Strings aus:
	 *  --> Ausgabe: "a,i,"
	 */
	public static void case2(){
		System.out.println("\nstart case 2...");
		String[] test = { "abc", "defgh", "ijk" };
		// Stream wird aufgebaut
		Stream<Character> s = Arrays.stream(test).
		map(t -> {
		// gezielte Exception fuer alle Strings mit Laenge > 3
		try {
		if (t.length()>3) throw new RuntimeException("error");
		} catch (Exception ex) { return null; }
		return t.charAt(0);
		});
		// Stream wird konsumiert
		s.forEach( c -> 
		{ if (c!=null) System.out.print(c.charValue() + ","); } );
	}
		
	/**
	 * Fall 3: Eine Ausnahme wird geworfen, aber erst in der terminalen Operation 
	 * mit try-catch behandelt:
	 * Hier werden (vielleicht überraschend) nicht alle Strings behandelt: 
	 * Wie im ersten Fall wird die Stream-Verarbeitung durch den zu langen String 
	 * defgh beendet. Die Behandlung der Ausnahme in der terminalen Operation 
	 * hilft also zum Wiederaufsetzen nach dem Fehler nicht.
	 *  --> Ausgabe: "a,"
	 */
	public static void case3(){
		System.out.println("\nstart case 3...");
		String[] test = { "abc", "defgh", "ijk" };
		// Stream wird aufgebaut
		Stream<Character> s = Arrays.stream(test).
		map(t -> {
		// gezielte Exception fuer alle Strings mit Laenge > 3
		if (t.length()>3) throw new RuntimeException("error");
		return t.charAt(0);
		});
		// Stream wird konsumiert
		s.forEach( c -> 
		{ try {
		System.out.print(c.charValue() + ",");
		} catch (Exception e) { e.printStackTrace(System.err); }} );
	}
}
