package com.pea.autowiring.byname;

public class TextEditor {
	   private SpellChecker spellChecker;
	   private String name;
	   
	   public void setSpellCheckerByName4( SpellChecker spellChecker ){
		  System.out.println("Inside setSpellChecker 4 (by name)." );
	      this.spellChecker = spellChecker;
	   }
	   public SpellChecker getSpellCheckerByName4() {
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
