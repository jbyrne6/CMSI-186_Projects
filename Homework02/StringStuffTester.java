/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  StringStuff.java
 *  Purpose       :  A file full of stuff to do with the Java String class
 *  Author        :  Jimmy Byrne
 *  Date          :  2017-02-01
 *  Description   :  This file presents a bunch of String-style helper methods.  Although pretty much
 *                   any and every thing you'd want to do with Strings is already made for you in the
 *                   Jave String class, this exercise gives you a chance to do it yourself [DIY] for some
 *                   of it and get some experience with designing code that you can then check out using
 *                   the real Java String methods [if you want]
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-07  Jimmy Byrne  Uploaded partialally complete to github
 *  @version 1.1.0  2017-02-08  Jimmy Byrne Final product upload to github
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class StringStuffTester {

  /**
   * the main method which calls all of the test methods in the class
   * @param args String[] array containing command line parameters
   * @return void
   */
   public static void main ( String [] args ) {

      test_containsVowel();      // fill in how many tests
      test_isPalindrome();       // fill in how many tests
      test_evensOnly();          // fill in how many tests
      test_oddsOnly();           // fill in how many tests
      test_evensOnlyNoDupes();   // fill in how many tests
      test_oddsOnlyNoDupes();    // fill in how many tests
      test_reverse();            // fill in how many tests
   }

  /**
   * test method to test out the operation of the containsVowel method
   */
   public static void test_containsVowel() {
       System.out.println("\nTESTS FOR containsVowel():");
	   
	   System.out.print("   Test for Pineapple: ");
	   try{System.out.println(StringStuff.containsVowel("Pineapple") ? "true" : "false"); }
	   catch(Exception e) {System.out.println(false);}
	   
	   System.out.print("   Test for Palindrome: ");
	   try{System.out.println(StringStuff.containsVowel("Palindrome") ? "true" : "false"); }
	   catch(Exception e) {System.out.println(false);}
	   
	   System.out.print("   Test for Pineapple!: ");
	   try{System.out.println(StringStuff.containsVowel("Pineapple!") ? "true" : "false"); }
	   catch(Exception e) {System.out.println(false);}
	   
	   System.out.print("   Test for B: ");
	   try{System.out.println(StringStuff.containsVowel("B") ? "true" : "false"); }
	   catch(Exception e) {System.out.println(false);}
	   
	   System.out.print("   Test for !: ");
	   try{System.out.println(StringStuff.containsVowel("!") ? "true" : "false"); }
	   catch(Exception e) {System.out.println(false);}
   } 

  /**
   * test method to test out the operation of the isPalindrome method
   */
   public static void test_isPalindrome() {
    System.out.println("\nTESTS FOR isPalindrome():");
	
	 System.out.print("   Test for racecar: ");
	 try{System.out.println(StringStuff.isPalindrome("racecar") ? "true" : "false"); }
	 catch(Exception e) {System.out.println(false);}	
	 
	 System.out.print("   Test for ball: ");
	 try{System.out.println(StringStuff.isPalindrome("ball") ? "true" : "false"); }
	 catch(Exception e) {System.out.println(false);}	
	 
	 System.out.print("   Test for mom: ");
	 try{System.out.println(StringStuff.isPalindrome("mom") ? "true" : "false"); }
	 catch(Exception e) {System.out.println(false);}	
	 
	 System.out.print("   Test for Anna: ");
	 try{System.out.println(StringStuff.isPalindrome("Anna") ? "true" : "false"); }
	 catch(Exception e) {System.out.println(false);}	
	 
	 System.out.print("   Test for A Santa at Nasa: ");
	 try{System.out.println(StringStuff.isPalindrome("A Santa at Nasa") ? "true" : "false"); }
	 catch(Exception e) {System.out.println(false);}	
	 
	 System.out.print("   Test for not a palindrome: ");
	 try{System.out.println(StringStuff.isPalindrome("not a palindrome") ? "true" : "false"); }
	 catch(Exception e) {System.out.println(false);}	
   }

  /**
   * test method to test out the operation of the evensOnly method
   */
   public static void test_evensOnly() {
     System.out.println("\nTESTS FOR evensOnly():");
	 
	 System.out.print("   Test for Paul: ");
	 try{System.out.println(StringStuff.evensOnly("Paul").equals("pl") ? "pl" : "not working"); }
	 catch(Exception e) {System.out.println(false);}

	 System.out.print("   Test for Mongolia: ");
	 try{System.out.println(StringStuff.evensOnly("Mongolia").equals("nl") ? "nl" : "not working"); }
	 catch(Exception e) {System.out.println(false);}

     System.out.print("   Test for star wars: ");
	 try{System.out.println(StringStuff.evensOnly("star wars").equals("trr") ? "trr" : "not working"); }
	 catch(Exception e) {System.out.println(false);}		 
   }

  /**
   * test method to test out the operation of the oddsOnly method
   */
   public static void test_oddsOnly() {
     System.out.println("\nTESTS FOR oddsOnly():");
	 
	 System.out.print("   Test for Paul: ");
	 try{System.out.println(StringStuff.oddsOnly("Paul").equals("au") ? "au" : "not working"); }
	 catch(Exception e) {System.out.println(false);}
	 
	 System.out.print("   Test for Mongolia: ");
	 try{System.out.println(StringStuff.oddsOnly("Mongolia").equals("mogoia") ? "mogoia" : "not working"); }
	 catch(Exception e) {System.out.println(false);}

     System.out.print("   Test for star wars: ");
	 try{System.out.println(StringStuff.oddsOnly("star wars").equals("sawas") ? "sawas" : "not working"); }
	 catch(Exception e) {System.out.println(false);}
   }

  /**
   * test method to test out the operation of the evensOnlyNoDupes method
   */
   public static void test_evensOnlyNoDupes() {
     System.out.println("\nTESTS FOR evensOnlyNoDupes():");
	 
	 System.out.print("   Test for star wars: ");
	 try{System.out.println(StringStuff.evensOnlyNoDupes("star wars").equals("tr") ? "tr" : "not working"); }
	 catch(Exception e) {System.out.println(false);}
	 
	 System.out.print("   Test for baloon: ");
	 try{System.out.println(StringStuff.evensOnlyNoDupes("baloon").equals("bln") ? "bln" : "not working"); }
	 catch(Exception e) {System.out.println(false);}
	 
	 System.out.print("   Test for platypus: ");
	 try{System.out.println(StringStuff.evensOnlyNoDupes("platypus").equals("plt") ? "plt" : "not working"); }
	 catch(Exception e) {System.out.println(false);}
   }

  /**
   * test method to test out the operation of the oddsOnlyNoDupes method
   */
   public static void test_oddsOnlyNoDupes() {
     System.out.println("\nTESTS FOR oddsOnlyNoDupes():");
	 
	 System.out.print("   Test for balloon: ");
	 try{System.out.println(StringStuff.oddsOnlyNoDupes("balloon").equals("ao") ? "ao" : "not working"); }
	 catch(Exception e) {System.out.println(false);}
	 
	 System.out.print("   Test for Brian is the best.: ");
	 try{System.out.println(StringStuff.oddsOnlyNoDupes("Brian is the best.").equals("iase") ? "iase" : "not working"); }
	 catch(Exception e) {System.out.println(false);}
	 
	 System.out.print("   Test for I LIKE PANCAKES!: ");
	 try{System.out.println(StringStuff.oddsOnlyNoDupes("I LIKE PANCAKES!").equals("ikeacs") ? "ikeacs" : "not working"); }
	 catch(Exception e) {System.out.println(false);}
   }

  /**
   * test method to test out the operation of the reverse method
   */
   public static void test_reverse() {
     System.out.println("\nTESTS FOR reverse():");
	 
	 System.out.print("   Test for Jimmy: ");
	 try{System.out.println(StringStuff.reverse("Jimmy").equals("ymmiJ") ? "ymmiJ" : "not working"); }
	 catch(Exception e) {System.out.println(false);}
	 
	 System.out.print("   Test for This is not a palendrome.: ");
	 try{System.out.println(StringStuff.reverse("This is not a palendrome.").equals(".emordnelap a ton si sihT") ? ".emordnelap a ton si sihT" : "not working"); }
	 catch(Exception e) {System.out.println(false);}
	 
	 System.out.print("   Test for 123456: ");
	 try{System.out.println(StringStuff.reverse("123456").equals("654321") ? "654321" : "not working"); }
	 catch(Exception e) {System.out.println(false);}
   }

}