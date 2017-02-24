/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  HighRoller.java
 *  Purpose       :  Demonstrates the use of input from a command line for use with Yahtzee
 *  Author        :  James Byrne
 *  Date          :  2017-02-23
 *  Description   :  
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-23  James Byrne  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighRoller{
private static DiceSet ds = null;
 private static  int dsSum = 0;
 private static int HighScore = 0;
   public static void main( String args[] ) {
      System.out.println( "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n   \t\t\t\t\t\tWelcome to the HighRoller!!\n\n" );
	  System.out.println( "\n\t\tNOTE: input desired selection as seen in brackets, not including the brackets.\n");
      System.out.println( "\t\t1.    Specify die characteristics [list option number,# die,# sides].\n" );
       
     // This line uses the two classes to assemble an "input stream" for the user to type
     // text into the program
      BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
      while( true ) {
         System.out.print( "\n\t\t>>" );
         String inputLine = null;
         try {
            inputLine = input.readLine();
            if(0 == inputLine.length()) {
               System.out.println("\n\t\tPlease enter some text:");
			   continue;
            }
			if( '1' == inputLine.charAt(0)){
				String[] parts = inputLine.split(",");
				if(parts.length != 3){
					System.out.println("\n\t\tYou must use 3 arguments.");
				}else if(Integer.parseInt(parts[1]) < 1 || Integer.parseInt(parts[2]) < 4){
					System.out.println("\n\t\tYou must have at least 1 die and 4 sides.");
				}
				else{
					parts[1] = parts[1].replace(" ","");
				    parts[2] = parts[2].replace(" ","");
				    ds = new DiceSet(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));
					ds.roll();
				    System.out.println("\n\t\tYou have selected " + parts[1] + " dice with " + parts[2] + " sides each."); 
				}
				
			}    
			if( '2' == inputLine.charAt(0)){
				if(inputLine.length() != 1){
					System.out.println("\n\t\tYou must use 1 argument.");
				}else{
					ds.roll();
				    System.out.println("\n\t\t" + ds.toString());
				}
			}
			if( '3' == inputLine.charAt(0)){
				String[] parts = inputLine.split(",");
				if(parts.length != 2){
					System.out.println("\n\t\tYou must use 2 arguments.");
				}else{
					parts[1] = parts[1].replace(" ","");
				    ds.rollIndividual(Integer.parseInt(parts[1])-1);
				    System.out.println("\n\t\t" + ds.toString());
				}
			}
			if( '4' == inputLine.charAt(0)){
				if(inputLine.length() != 1){
					System.out.println("\n\t\tYou must use 1 argument.");
				}else{
					dsSum = ds.sum();
				    System.out.println("\n\t\tYour current score is: " + dsSum + ".");
				}
			}
			if( '5' == inputLine.charAt(0)){
				if(inputLine.length() != 1){
					System.out.println("\n\t\tYou must use 1 argument.");
				}else{
					HighScore = ds.sum();
					System.out.println("\n\t\tYour new high score is: " + HighScore + ".");
				}
			}
			if( '6' == inputLine.charAt(0)){
				if(inputLine.length() != 1){
					System.out.println("\n\t\tYou must use 1 argument.");
				}else{
					System.out.println("\n\t\tYour high score is: " + HighScore + ".");
				}
			}
			if( '7' == inputLine.charAt(0)){
				if(inputLine.length() != 1){
					System.out.println("\n\t\tYou must use 1 argument.");
				}else{
					System.out.println("\n\t\t" + ds.toString());
				}
			}
			if( 'q' == inputLine.charAt(0) ) {
               if(inputLine.length() != 1){
				   System.out.println("\n\t\tYou must use 1 argument.");
			   }else{
				 break;  
			   }
            }
            System.out.println( "\n\t\t1.    Specify die characteristics [option number,# die,# sides]." );
			System.out.println( "\n\t\t2.    Roll all the dice [option number]." );
			System.out.println( "\n\t\t3.    Roll a single die [option number, die place number (1-# die specified)]." );
			System.out.println( "\n\t\t4.    Calculate the score for this set [option number]." );
			System.out.println( "\n\t\t5.    Save this score as high score [option number]." );
			System.out.println( "\n\t\t6.    Display the high score [option number]." );
			System.out.println( "\n\t\t7.    Display your current dice [option number]." );
			System.out.println( "\n\t\tq.    Enter q to quit the program." );
			}
         catch( IOException ioe ) {
            System.out.println( "\n\t\tCaught IOException" );
         }
      }
   }
}