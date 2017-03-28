/*
-Make a method that checks the distance between the center of n number of balls and with the center of the flag pole.
+Make an array that holds the ball objects
+Validate all input arguments
-Figure out what to put into the while loop.
	-Ball is out of bounds test
	-Ball is colliding with other ball test
	-Ball is colliding with pole test
	-tick
?How do you put ball objects into array?
*/
//first two arguments are field size, next five describe the ball object
public class SoccerSim{ 
    public static void main(String args[]){
		
	   Field field = new Field(Double.parseDouble(args[0]),Double.parseDouble(args[1]));
	   Pole pole = new Pole(Double.parseDouble(args[0]),Double.parseDouble(args[1]));
	   double numBalls = (args.length-3) / 4;
	   double[] ballArray = new double[numBalls];
	   boolean[] errorArray = new boolean[6]; //Making array so that user can see all different errors with input instead of just showing first one to be tripped.
	   //errorArray = [#args test,field test, bounds test, dir test, vel test, slice test]
	 
       //See if correct number of arguments initially
	   if((args.length-3)%4 != 0){
	       errorArray[0] = true;   
	   }else{
	       errorArray[0] = false;
	   }
	   
	   //See if field dimensions are negative
	   if(field.right <= 0 || field.left <= 0 || field.top <= 0 || field.bot <= 0){
		   errorArray[1] = true;
	   }else{
		   errorArray[1] = false;
	   }
	   
	   //See if ball is out of bounds initially
	   double startx = 2;
	   double starty = 3;
	   for(i=0;i<numBalls;i++){
	        if(field.isOutOfBounds(Double.parseDouble(args[startx]),Double.parseDouble(args[starty])) == true){
				errorArray[2] = true;
			}else{
				errorArray[2] = false;
			}
			startx += 4;
			starty += 4;
        }
		
		//See if initial direction is between 0 and 360 degrees
		double startd = 4;
		for(i=0;i< numBalls;i++){
	        if(Double.parseDouble(args[startd]) < 0 || Double.parseDouble(args[startd]) > 360){
				errorArray[3] = true;
			}else{
				errorArray[3] = false;
			}
			startd += 4;
        }
		
		//See if initial velocity is greater than 1 inch per second
		double startv = 5;
		for(i=0;i< numBalls;i++){
	        if((Double.parseDouble(args[startv])/12) <= 1){
				errorArray[4] = true;
				//System.out.print.ln("")
				//;
			}else{
				errorArray[4] = false;
			}
			startv += 4;
        }
		
		//See if time slice is negative
		if(Double.parseDouble(args[args.length-1]) <= 0){
			errorArray[5] = true;
		}else{
			errorArray[5] = false;
		}
		
		if(errorArray[0] == true){
			System.out.println("You must have two field size arguments and 5 arguments for each ball object.");
		}
		if(errorArray[1] == true){
			System.out.println("Your field dimensions must both be positive numbers.");
		}
		if(errorArray[2] == true){
			System.out.println("One of your balls is out of bounds initially.");
		}
		if(errorArray[3] == true){
			System.out.println("Your direction must be between 0 and 360.");
		}
		if(errorArray[4] == true){
			System.out.println("Your velocity must be between greater than (1/12) feet per second.");
		}
		if(errorArray[5] == true){
			System.out.println("Your slice must be a positive number.");
		}
		for(i=0;i<errorArray.length;i++){
			if(errorArray[i] == true){
				System.exit( 1 );
			}
		}
		
		double x = 2;
		double y = 3;
		double d = 4;
		double v = 5;
		double s = args.length-1;
	    for(i=0;i< numBalls;i++){
		    Ball ballArray[i] = new Ball(x,y,d,v,s);
			x += 4;
			y += 4;
			d += 4;
			v += 4;
		}
		
		//initial report
		double ballxPos = 2;
		double ballyPos = 3;
		double ballVelocity = 5;
		for(i=0;i< numBalls;i++){
			System.out.println("Ball " + (i+1) + " is at x = " + args[ballxPos] + ", y = " + args[ballyPos] + ", and velocity = " + args[ballVelocity] + ".");
			ballxPos += 4;
			ballyPos += 4;
			ballVelocity += 4;
		}
		
// Ball is out of bounds test
// Ball is stopped test
// Ball is colliding with other ball test
// Ball is colliding with pole test
// -only compare with balls that have a velocity > 
// tick
// make counter that incraments every tick to keep track of time that things happen
// -Time.totalSeconds += 1
		double totalSeconds = 0;
		while(true){
            if(totalSeconds % (Double.parseDouble(args[args.length-1])) == 0){
				for(i=0;i< numBalls;i++){
			        System.out.println("Ball " + (i+1) + " is at x = " + args[ballxPos] + ", y = " + args[ballyPos] + ", and velocity = " + args[ballVelocity] + ".");
			        ballxPos += 4;
			        ballyPos += 4;
			        ballVelocity += 4;
		        }
			}
			
			Time.totalSeconds = Time.tick();
			for(i=0;i<ballArray.length;i++){
				ballArray[i].velocity = ballArray[i].updateVelocity;
				ballArray[i].updatePosition()
			}
		}
	}
}
