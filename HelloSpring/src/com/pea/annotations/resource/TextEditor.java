package com.pea.annotations.resource;

import javax.annotation.Resource;

public class TextEditor {
	   private SpellChecker spellChecker;

	   @Resource(name = "spellChecker4")
	   public void setSpellChecker( SpellChecker spellChecker ){
	      this.spellChecker = spellChecker;
	   }
	   public SpellChecker getSpellChecker(){
	      return spellChecker;
	   }
	   public void spellCheck(){
	      spellChecker.checkSpelling();
	   }
}
