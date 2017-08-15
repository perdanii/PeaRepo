package com.pea.autowiring.byconstructor;

public class TextEditor {
	   private SpellCheckerByConstructor6 spellChecker;
	   private String name;
	   
	   public TextEditor( SpellCheckerByConstructor6 spellChecker, String name ) {
		      System.out.println("Inside TextEditor 6 (by constructor) constructor." );
		      this.spellChecker = spellChecker;
		      this.name = name;
	   }
	   public SpellCheckerByConstructor6 getSpellChecker() {
	      return spellChecker;
	   }
	   public void setName(String name) {
	      this.name = name;
	   }
	   public String getName() {
	      return name;
	   }
	   public void spellCheck() {
	      spellChecker.checkSpelling();
	   }
}
