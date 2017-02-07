/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  StringStuffTester.java
 *  Purpose       :  A test harness file for testing out the methods in the "StringStuff.java" class
 *  Author        :  B.J. Johnson
 *  Date          :  2017-01-25
 *  Description   :  This file provides the "test harness" for checking out the methods which are part of
 *                   the homework02 assignment.  It also provides examples of proper documentation, and
 *                   uses the source file header template as specified in the "Greeter.java" template file
 *                   for use in CMSI 186, Spring 2017.
 *  Notes         :  TEMPLATE FILE ONLY: Your job is to fill in as many test cases as you think are needed
 *                   to thoroughly and completely test your StringStuff class.
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-25  B.J. Johnson  Initial writing and release
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
   }

  /**
   * test method to test out the operation of the oddsOnly method
   */
   public static void test_oddsOnly() {

   }

  /**
   * test method to test out the operation of the evensOnlyNoDupes method
   */
   public static void test_evensOnlyNoDupes() {

   }

  /**
   * test method to test out the operation of the oddsOnlyNoDupes method
   */
   public static void test_oddsOnlyNoDupes() {

   }

  /**
   * test method to test out the operation of the reverse method
   */
   public static void test_reverse() {

   }

}