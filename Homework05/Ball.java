/*
TO DO:
-Make a method that checks the distance between the center of n number of balls and with the center of the flag pole.
+Method that checks for if the balls are out of bounds.
?Ask Johnson how to work with multiple ball objects in SoccerSim ex: Ball1 radius compared to Ball2 compared to Ball3.
	-make an array of ball objects
?Can my time slice always be 1 seconds and not need to have user input for that paramater? no,
?How many soccer balls? user decides
+Make validate arg methods for xPosition, yPosition, direction, and velocity.
+Make a to string method that converts the total seconds to hours,minutes,and seconds like that in Clock.
note: have a timeslice as an input
*/
public class Ball{
	public double radius = 4.45; //Radius in inches
	public double ballRadius = 4.45/12; //Radius in feet
	public double xPosition;
	public double yPosition;
	public double velocity; //In feet per seconds
	public double direction; //Angle in degrees between 0 and 360
	public boolean isStopped = false;

	public Ball(double xPos,double yPos,double d,double v,double s){
		xPosition = xPos;
		yPosition = yPos;
		direction = d;
		velocity = v;
		ballRadius = ballRadius;
		isStopped = isStopped;
	}

	public double updateVelocity(){ //if velocity < (1/12) that ball has stopped
		velocity = velocity - velocity*(.01);
		if(velocity < (1.0/12.0)){
			velocity = 0;
			isStopped = true;
		}
		return velocity;
	}

	public double getVelocity(){
		return velocity;
	}

	//REMEMBER TO CONVERT TO RADIANS WITH Math.toRadians() TO USE Math.sin AND Math.cos
	public void updatePosition(){
		double cLength = velocity; //Hypotenuse in feet
		double cAngle = 90;
		double bAngle;
		if(direction < 90 && direction > 0){ //First quadrant
			bAngle = direction;
			double aAngle = 180 - (cAngle+bAngle);
			double bLength = (cLength/Math.sin(Math.toRadians(cAngle))*Math.sin(Math.toRadians(bAngle)));
			double aLength = (cLength/Math.sin(Math.toRadians(cAngle))*Math.sin(Math.toRadians(aAngle)));
			xPosition += aLength;
			yPosition += bLength;
		}else if(direction < 180 && direction > 90){ //Seconds quadrant
			bAngle = (180-direction);
			double aAngle = 180 - (cAngle+bAngle);
			double bLength = (cLength/Math.sin(Math.toRadians(cAngle))*Math.sin(Math.toRadians(bAngle)));
			double aLength = (cLength/Math.sin(Math.toRadians(cAngle))*Math.sin(Math.toRadians(aAngle)));
			xPosition += aLength;
			yPosition += bLength;
		}else if(direction < 270 && direction > 180){ //Third quadrant
			bAngle = (direction-180);
			double aAngle = 180 - (cAngle+bAngle);
			double bLength = (cLength/Math.sin(Math.toRadians(cAngle))*Math.sin(Math.toRadians(bAngle)));
			double aLength = (cLength/Math.sin(Math.toRadians(cAngle))*Math.sin(Math.toRadians(aAngle)));
			xPosition += aLength;
			yPosition += bLength;
		}else if(direction < 360 && direction > 270){ //Fourth quadrant
			bAngle = (360-direction);
			double aAngle = 180 - (cAngle+bAngle);
			double bLength = (cLength/Math.sin(Math.toRadians(cAngle))*Math.sin(Math.toRadians(bAngle)));
			double aLength = (cLength/Math.sin(Math.toRadians(cAngle))*Math.sin(Math.toRadians(aAngle)));
			xPosition += aLength;
			yPosition += bLength;
		}else if(direction == 0 || direction == 360){
			xPosition += velocity;
		}else if(direction == 90){
			yPosition += velocity;
		}else if(direction == 180){
			xPosition -= velocity;
		}else if(direction == 270){
			yPosition -= velocity;
		}
	}

	public static boolean isCollided(double ballOnex,double ballOney, double ballTwox,double ballTwoy){
		if((Math.sqrt((ballTwox-ballOnex)*(ballTwox-ballOnex) + (ballTwoy-ballOney)*(ballTwoy-ballOney))) <= (8.9/12)){
			return true;
		}else{
			return false;
		}
	}

	public static void main( String args[] ) {
		Ball b1 = new Ball(10,10,80,100,10);
		System.out.println("Velocity");
		System.out.println(b1.getVelocity());
		System.out.println("Updated Velocity");
		System.out.println(b1.updateVelocity());
		System.out.println("Time String");
		System.out.println(b1.toString());
		System.out.println("");
		System.out.println("Velocity");
		System.out.println(b1.getVelocity());
		System.out.println("Updated Velocity");
		System.out.println(b1.updateVelocity());
		System.out.println("Time String");
        System.out.println(b1.toString());
	}
}
