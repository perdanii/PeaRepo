package com.pea.annotations.autowired.constructor;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
   private SpellChecker3Constructor spellChecker;

   @Autowired
   public TextEditor(SpellChecker3Constructor spellChecker){
      System.out.println("Inside TextEditor 3 constructor." );
      this.spellChecker = spellChecker;
   }
   
   public void spellCheck() {
      spellChecker.checkSpelling();
   }
}
