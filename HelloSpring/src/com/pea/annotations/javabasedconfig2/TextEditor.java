package com.pea.annotations.javabasedconfig2;

public class TextEditor {
	   private SpellChecker spellChecker;

	   public TextEditor(SpellChecker spellChecker){
	      System.out.println("Inside TextEditor constructor (with java-based config)." );
	      this.spellChecker = spellChecker;
	   }
	   public void spellCheck(){
	      spellChecker.checkSpelling();
	   }
}
