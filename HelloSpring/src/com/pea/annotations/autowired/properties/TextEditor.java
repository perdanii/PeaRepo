package com.pea.annotations.autowired.properties;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
   @Autowired
   private SpellChecker2Properties spellChecker;

   public TextEditor() {
	      System.out.println("Inside TextEditor 2 constructor." );
   }
   
   public SpellChecker2Properties getSpellChecker( ) {
      return spellChecker;
   }
   public void spellCheck() {
      spellChecker.checkSpelling();
   }
}
