/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  MainProgLoopDemo.java
 *  Purpose       :  Demonstrates the use of input from a command line for use with Yahtzee
 *  Author        :  B.J. Johnson
 *  Date          :  2017-02-14
 *  Description   :  
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-14  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighRoller{
private static DiceSet ds = null;
 private static  int dsSum = 0;
 private static int HighScore = 0;
   public static void main( String args[] ) {
      System.out.println( "\n   Welcome to the HighRoller!!\n" );
      System.out.println( "1.    Specify die characteristics(option number,# die,# sides)." );
       
     // This line uses the two classes to assemble an "input stream" for the user to type
     // text into the program
      BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
      while( true ) {
         System.out.print( ">>" );
         String inputLine = null;
         try {
            inputLine = input.readLine();
            if( 0 == inputLine.length() ) {
               System.out.println("enter some text!:");
			   continue;
            }
			if( '1' == inputLine.charAt(0)){
				String[] parts = inputLine.split(",");
				if(parts.length != 3){
					System.out.println("You must use 3 arguments.");
				}else{
					parts[1] = parts[1].replace(" ","");
				    parts[2] = parts[2].replace(" ","");
				    ds = new DiceSet(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));
				    System.out.println("You have selected " + parts[1] + " dice with " + parts[2] + " sides each."); 
				}
				
			}    
			if( '2' == inputLine.charAt(0)){
				if(inputLine.length() != 1){
					System.out.println("You must use 1 argument.");
				}else{
					ds.roll();
				    System.out.println(ds.toString());
				}
			}
			if( '3' == inputLine.charAt(0)){
				String[] parts = inputLine.split(",");
				if(parts.length != 3){
					System.out.println("You must use 3 arguments.");
				}else{
					parts[1] = parts[1].replace(" ","");
				    ds.rollIndividual(Integer.parseInt(parts[1])-1);
				    System.out.println("\n" + ds.toString());
				}
			}
			if( '4' == inputLine.charAt(0)){
				if(inputLine.length() != 1){
					System.out.println("You must use 1 argument.");
				}else{
					dsSum = ds.sum();
				    System.out.println(dsSum);
				}
			}
			if( '5' == inputLine.charAt(0)){
				if(inputLine.length() != 1){
					System.out.println("You must use 1 argument.");
				}else{
					HighScore = ds.sum();
				}
			}
			if( '6' == inputLine.charAt(0)){
				if(inputLine.length() != 1){
					System.out.println("You must use 1 argument.");
				}else{
					System.out.println(HighScore);
				}
			}
			if( '7' == inputLine.charAt(0)){
				if(inputLine.length() != 1){
					System.out.println("You must use 1 argument.");
				}else{
					System.out.println(ds.toString());
				}
			}
			if( 'q' == inputLine.charAt(0) ) {
               if(inputLine.length() != 1){
				   System.out.println("You must use 1 argument.");
			   }else{
				 break;  
			   }
            }
            System.out.println( "\n1.    Specify die characteristics(option number,# die,# sides)." );
			System.out.println( "2.    Roll all the dice(option number)." );
			System.out.println( "3.    Roll a single die(option number, die place number (1-# die specified))." );
			System.out.println( "4.    Calculate the score for this set(option number)." );
			System.out.println( "5.    Save this score as high score(option number)." );
			System.out.println( "6.    Display the high score(option number)." );
			System.out.println( "7.    Display your current dice(option number)." );
			System.out.println( "q.    Enter q to quit the program.\n" );
			}
         catch( IOException ioe ) {
            System.out.println( "Caught IOException" );
         }
      }
   }
}