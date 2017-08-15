package com.pea.dependencyinjection.setterbased;

public class TextEditor {
	  private SpellChecker spellChecker;

	   // a setter method to inject the dependency.
	   public void setSpellChecker(SpellChecker spellChecker) {
	      System.out.println("Inside setSpellChecker 2." );
	      this.spellChecker = spellChecker;
	   }
	   // a getter method to return spellChecker
	   public SpellChecker getSpellChecker() {
	      return spellChecker;
	   }
	   public void spellCheck() {
	      spellChecker.checkSpelling();
	   }
}
