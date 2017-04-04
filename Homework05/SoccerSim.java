/*****************************************************************************************************************************************************************************************************************************
File Name: SoccerSim.java
Author: James Byrne
Date Last Updated: 4/3/2017
Class: 186
Project Name: Soccer Simulator
Purpose: Simulate balls being kicked and see if they collide.
*****************************************************************************************************************************************************************************************************************************/

import java.text.DecimalFormat;

public class SoccerSim{
    public static void main(String args[]){

    DecimalFormat df1 = new DecimalFormat("#0.0000");
    DecimalFormat df2 = new DecimalFormat("#0");
    Field field = new Field(Double.parseDouble(args[0]),Double.parseDouble(args[1]));
	  Pole pole = new Pole(Double.parseDouble(args[0]),Double.parseDouble(args[1]));
	  Time time = new Time(Double.parseDouble(args[args.length-1]));
    double userTimeSlice = Double.parseDouble(args[args.length-1]);
    int numBalls = 0;
    if(((args.length-3)%4 == 0)){
	      numBalls = (args.length-3) / 4;
	  }else if((args.length-2)%4 == 0){
        numBalls = (args.length-2) / 4;
    }
	  Ball[] ballArray = new Ball[numBalls];
    boolean[] errorArray = new boolean[6]; //Making array so that user can see all different errors with input instead of just showing first one to be tripped.
    //errorArray = [#args test,field test, bounds test, dir test, vel test, slice test]
    //See if correct number of arguments initially

    if(((args.length-3)%4 != 0) && (args.length-2)%4 != 0 || args.length < 6){
       errorArray[0] = true;
    }else{
       errorArray[0] = false;
    }
    //See if field dimensions are negative
	  if(Double.parseDouble(args[0]) <= 0 || Double.parseDouble(args[1]) <= 0){
		    errorArray[1] = true;
	  }else{
	      errorArray[1] = false;
	  }

    //See if ball is out of bounds initially
	  double startx = 2;
	  double starty = 3;
	  for(int i=0;i<numBalls;i++){
	      if(field.isOutOfBounds(Double.parseDouble(args[(int)startx]),Double.parseDouble(args[(int)starty])) == true){
				    errorArray[2] = true;
		    }else{
				    errorArray[2] = false;
			  }
			  startx += 4;
			  starty += 4;
    }

    //See if initial direction is between 0 and 360 degrees
		double startd = 4;
		for(int i=0;i< numBalls;i++){
	      if(Double.parseDouble(args[(int)startd]) < 0 || Double.parseDouble(args[(int)startd]) > 360){
				    errorArray[3] = true;
		    }else{
				    errorArray[3] = false;
			  }
			  startd += 4;
    }

    //See if initial velocity is less than 1 inch per second or greater than 131 mph
		double startv = 5;
		for(int i=0;i< numBalls;i++){
	      if(((Double.parseDouble(args[(int)startv])) > 0.0833) && ((Double.parseDouble(args[(int)startv])) < 192.133)){
				  errorArray[4] = false;
			  }else{
				  errorArray[4] = true;
			  }
			  startv += 4;
    }

    //See if time slice is negative or less than 1
    if(((args.length-3)%4 == 0)){
      if(Double.parseDouble(args[args.length-1]) <= 0){
  		    errorArray[5] = true;
  		}else {
  			  errorArray[5] = false;
  		}
	  }

    if(errorArray[0] == true){
      System.out.println("\n\n\n\n\n");
      System.out.println("          ____________________________________________________________________________________________________\n");
      System.out.println("\t\t\t\t\t\t\tERROR MESSAGE\n");
      System.out.println("\t\t\tYou must have two field size arguments, 4 arguments for each ball object, ");
      System.out.println("\t\t\t\t   and have the option of an update frequency argument.\n\n\n\n\n");
    }
		if(errorArray[1] == true){
      System.out.println("\n\n\n\n\n");
      System.out.println("          ____________________________________________________________________________________________________\n");
      System.out.println("\t\t\t\t\t\t\tERROR MESSAGE\n");
			System.out.println("\t\t\t\t    Your field dimensions must both be positive numbers.\n\n\n\n\n");
		}
		if(errorArray[2] == true){
      System.out.println("\n\n\n\n\n");
      System.out.println("          ____________________________________________________________________________________________________\n");
      System.out.println("\t\t\t\t\t\t\tERROR MESSAGE\n");
			System.out.println("\t\t\t\t\tOne of your balls is out of bounds initially.\n\n\n\n\n");
		}
		if(errorArray[3] == true){
      System.out.println("\n\n\n\n\n");
      System.out.println("          ____________________________________________________________________________________________________\n");
      System.out.println("\t\t\t\t\t\t\tERROR MESSAGE\n");
			System.out.println("\t\t\t\t\tYour direction must be between 0 and 360.\n\n\n\n\n");
		}
		if(errorArray[4] == true){
      System.out.println("\n\n\n\n\n");
      System.out.println("          ____________________________________________________________________________________________________\n");
      System.out.println("\t\t\t\t\t\t\tERROR MESSAGE\n");
			System.out.println("\tYour velocity must be between greater than 0.0833 feet per second and less than 192.133 feet per second.\n\n\n\n\n");
		}
		if(errorArray[5] == true){
      System.out.println("\n\n\n\n\n");
      System.out.println("          ____________________________________________________________________________________________________\n");
      System.out.println("\t\t\t\t\t\t\tERROR MESSAGE\n");
			System.out.println("\t\t\t     Your slice must be a positive number greater than or equal to 0.\n\n\n\n\n");
		}
		for(int X=0;X<errorArray.length;X++){
			if(errorArray[X] == true){
				System.exit( 1 );
			}
		}

		double x = 2;
		double y = 3;
		double d = 4;
		double v = 5;
		double s = args.length-1;
	  for(int i=0;i< numBalls;i++){
		  ballArray[i] = new Ball(Double.parseDouble(args[(int)x]),Double.parseDouble(args[(int)y]),Double.parseDouble(args[(int)d]),Double.parseDouble(args[(int)v]),Double.parseDouble(args[(int)s]));
			x += 4;
		  y += 4;
			d += 4;
			v += 4;
		}

//initial report
		double ballxPos = 2;
		double ballyPos = 3;
		double ballVelocity = 5;
    System.out.println("\n\n\n\n\n\n\n");
    System.out.println("\t\t\t\t\t\t\tINITIAL STATUS\n");
		for(int i=0;i< numBalls;i++){
			  System.out.println("\t\t\t\tBall " + (i+1) + " starts at x = " + df1.format(Double.parseDouble(args[(int)ballxPos])) + ", y = " + df1.format(Double.parseDouble(args[(int)ballyPos])) + ", and has velocity = " + df1.format(Double.parseDouble(args[(int)ballVelocity])) + ".\n");
			  ballxPos += 4;
			  ballyPos += 4;
			  ballVelocity += 4;
		}
    System.out.println("\t\t\t\tThe pole is at x = " + df1.format(pole.xPos) + ", and y = " + df1.format(pole.yPos) + ".\n" );
    System.out.println("          ____________________________________________________________________________________________________\n");
    if(((args.length-3)%4 == 0)){
      if(Double.parseDouble(args[args.length-1]) == 1){
        System.out.println("\t\t\t\t\t\tSTATUS UPDATE EVERY " + args[args.length-1] + " SECOND\n" );
      }else{
	      System.out.println("\t\t\t\t\t\tSTATUS UPDATE EVERY " + args[args.length-1] + " SECONDS\n" );
      }
	  }else if((args.length-2)%4 == 0){
        System.out.println("\t\t\t\t\t\tSTATUS UPDATE EVERY 1 SECOND\n");
    }

		double totalSeconds = 0;
		boolean ballToPoleFlag = false;
		boolean ballToBallFlag = false;
	  double ballFlagTime = 0;
		double poleFlagTime = 0;
		double whichBall = 0;
		double whichBallOne = 0;
		double whichBallTwo = 0;
    double stopCounter = 0;

		while(true){
      if(userTimeSlice >= 1){
          if(((args.length-3)%4 == 0)){
            if(time.totalSeconds % (Double.parseDouble(args[args.length-1])) == 0 && time.totalSeconds != 0){
                System.out.println("\t\t\t\tCurrent time is " + time.toString());
                for(int o=0;o< numBalls;o++){
			              System.out.println("\t\t\t\tBall " + (o+1) + " is at x = " + df1.format(ballArray[o].xPosition) + ", y = " + df1.format(ballArray[o].yPosition) + ", and has velocity = " + df1.format(ballArray[o].velocity) + ".");
		            }
                System.out.println("\n");
			      }
          }else{
            if(time.totalSeconds % 1 == 0 && time.totalSeconds != 0){
                System.out.println("\t\t\t\tCurrent time is " + time.toString());
                for(int o=0;o< numBalls;o++){
			              System.out.println("\t\t\t\tBall " + (o+1) + " is at x = " + df1.format(ballArray[o].xPosition) + ", y = " + df1.format(ballArray[o].yPosition) + ", and has velocity = " + df1.format(ballArray[o].velocity) + ".");
		            }
                System.out.println("\n");
			      }
          }
      }else{
        System.out.println("\t\t\t\tCurrent time is " + time.toString());
        for(int o=0;o< numBalls;o++){
            System.out.println("\t\t\t\tBall " + (o+1) + " is at x = " + df1.format(ballArray[o].xPosition) + ", y = " + df1.format(ballArray[o].yPosition) + ", and has velocity = " + df1.format(ballArray[o].velocity) + ".");
        }
        System.out.println("\n");
      }
		    time.totalSeconds = time.tick();
        if(userTimeSlice < 1){
          time.totalSeconds -= 1-userTimeSlice;
        }

			  for(int i=0;i<ballArray.length;i++){
				    if(field.isOutOfBounds(ballArray[i].xPosition,ballArray[i].yPosition) == true){
					      ballArray[i].velocity = 0;
					      ballArray[i].xPosition = Math.random() * 3000000 + 1000000;
					      ballArray[i].yPosition = Math.random() * 3000000 + 1000000;
					      ballArray[i].isStopped = true;
// 	If isOutOfBounds is true stop that ball from being compared for collision
//If out of bounds set
// If out of bounds then set veocity = 0, set x & y to number outside of field size (set to a very big random number ex. btwm 1 and 2 million)
				    }

//compare pole with balls
				    if(Ball.isCollided(ballArray[i].xPosition,ballArray[i].yPosition,pole.xPos,pole.yPos) == true){
                ballToPoleFlag = true;
					      poleFlagTime = totalSeconds;
					      whichBall = i+1;
				    }

				    if(ballArray[i].velocity == 0){
					      ballArray[i].isStopped = true;
				    }
            if(userTimeSlice < 1){
              ballArray[i].velocity = ballArray[i].velocity-(ballArray[i].velocity*.01*userTimeSlice);
              ballArray[i].updatePosition(userTimeSlice);
            }
				    if(userTimeSlice >= 1){
              ballArray[i].updateVelocity();
              ballArray[i].updatePosition(userTimeSlice);
            }

            if(ballArray[i].isStopped == true){
				        stopCounter += 1;
			      }
				    if(stopCounter == numBalls){
                System.out.println("          ____________________________________________________________________________________________________\n");
                System.out.println("\t\t\t\t\t\tCOLLISION INFORMATION\n");
					      System.out.println("\t\t\t\t\t       There were no collisions.\n\n\n\n");
                System.exit( 1 );
				    }
			  }
			  //Compare ball positions
			  for(int I=0;I<(ballArray.length-1);I++){
				    for(int J=1+I;J<(ballArray.length);J++){
				        if(Ball.isCollided(ballArray[I].xPosition,ballArray[I].yPosition,ballArray[J].xPosition,ballArray[J].yPosition) == true){
					          ballToBallFlag = true;
					          ballFlagTime = totalSeconds;
					          whichBallOne = I+1;
                    whichBallOne = whichBallOne;
					          whichBallTwo = J+1;
                    whichBallTwo = whichBallTwo;
					      }
				    }
			  }
			  if(ballToBallFlag == true || ballToPoleFlag == true){
				    if(poleFlagTime < ballFlagTime){
                System.out.println("          ____________________________________________________________________________________________________\n");
                System.out.println("\t\t\t\t\t\tCOLLISION INFORMATION\n");
				        System.out.println("\t\t\t\t   At time " + time.toStringArgs(poleFlagTime) + ", ball " + df2.format(whichBall) + " collided with the pole.\n\n\n\n\n");
                System.exit( 1 );
			      }else{
                System.out.println("          ____________________________________________________________________________________________________\n");
                System.out.println("\t\t\t\t\t\t   COLLISION INFORMATION\n");
				        System.out.println("\t\t\t\t   At time " + time.toStringArgs(ballFlagTime) + ", ball " + df2.format(whichBallOne) + " collided with ball " + df2.format(whichBallTwo) + ".\n\n\n\n\n");
                System.exit( 1 );
				    }
			  }
		}
	}
}
