package com.pea.autowiring.bytype;

public class TextEditor {
	   private SpellCheckerByType5 spellChecker;
	   private String name;
	   
	   public void setSpellChecker( SpellCheckerByType5 spellChecker ){
		  System.out.println("Inside setSpellChecker 5 (by type)." );
	      this.spellChecker = spellChecker;
	   }
	   public SpellCheckerByType5 getSpellChecker() {
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
