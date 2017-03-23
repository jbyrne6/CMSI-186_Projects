/*
TO DO:
-Make a method that checks the distance between the center of n number of balls and with the center of the flag pole.
-Method that checks for if the balls are out of bounds.
?Ask Johnson how to work with multiple ball objects in SoccerSim ex: Ball1 radius compared to Ball2 compared to Ball3.
?Can my time slice always be 1 seconds and not need to have user input for that paramater?
-Make validate arg methods for xPosition, yPosition, direction, and velocity.
-Make a to string method that converts the total seconds to hours,minutes,and seconds like that in Clock.
*/
public class Ball{
	private static final double ballRadius = 4.45; //Radius in inches
	private static final double defaultSlice = 1; //In seconds, this is the constant time slice. The user doesn't input a time slice.
	
	private double xPosition;
	private double yPosition;
	private double velocity; //In feet per seconds
	private double direction; //Angle in degrees between 0 and 360
	private double totalSeconds = 0;
	private double[] positionArray; //Array with ball x position in index 0 and ball y position in index 1.
	private double polexPosition = 0;
	private double poleyPosition = 0;
	private double poleRadius = 4.5;
	private double fieldxDimension = 300; //in feet
	private double fieldyDimension = 300; //in feet
	public double seconds = 0;
    public double minutes = 0;
    public double hours = 0;
	
	public Ball(double xPosition,double yPosition,double direction,double velocity){
		xPosition = xPosition;
		yPosition = yPosition;
		direction = direction;
		velocity = velocity;
		positionArray = positionArray;
	}
	
	public double updateVelocity(){ //if velocity < (1/12) that ball has stopped
		velocity = velocity - velocity*(.01);
		return velocity;
	}
	
	public double tick(){
		totalSeconds += defaultSlice;
		return totalSeconds;
	}
	//REMEMBER TO CONVERT TO RADIANS WITH Math.toRadians() TO USE Math.sin AND Math.cos
	public void updatePosition(){
		double cLength = velocity; //Hypotenuse in feet
		double cAngle = 90;
		double bAngle;
		if(direction < 90 && direction > 0){ //First quadrant
			bAngle = direction;
		}else if(direction < 180 && direction > 90){ //Seconds quadrant
			bAngle = (180-direction);
		}else if(direction < 270 && direction > 180){ //Third quadrant
			bAngle = (direction-180);
		}else if(direction < 360 && direction > 270){ //Fourth quadrant
			bAngle = (360-direction);
		}else{
			bAngle = 0;
		}		
		double aAngle = 180 - (90+bAngle);
		double bLength = (cLength/Math.toRadians(Math.sin(cAngle)))*Math.toRadians(Math.sin(bAngle));
		double aLength = (cLength/Math.toRadians(Math.sin(cAngle)))*Math.toRadians(Math.sin(aAngle));
		xPosition += aLength;
		yPosition += bLength;
	}
	
	public double[] positionArray(){
		positionArray = new double[2];
		positionArray[0] = xPosition;
		positionArray[1] = yPosition;
		// index 0 is x position and index 1 is y position
		return positionArray;
	}
	
	public boolean isOutOfBounds(){
		if(fieldxDimension/2 > (xPosition-ballRadius) || fieldyDimension/2 > (yPosition-ballRadius){
			return true
		}else{
			return false
		}
	}
	
	public String toSting(){
	    if(totalSeconds < 60){
		  seconds = totalSeconds;
	  }else{
		  seconds = Math.floor(totalSeconds%60);
	  }
	  if(totalSeconds < 3600){
		  minutes = Math.floor(totalSeconds/60);
	  }else{
		  minutes = Math.floor(totalSeconds%60);
	  }
	  if(totalSeconds < 43200){
		  hours = Math.floor(totalSeconds/3600);
	  }
      String timeString = Double.toString(hours)+":"+Double.toString(minutes)+":"+ Double.toString(seconds);
      return timeString;
	} 
}