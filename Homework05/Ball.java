/*****************************************************************************************************************************************************************************************************************************
File Name: Ball.java
Author: James Byrne
Date Last Updated: 4/3/2017
Class: 186
Project Name: Soccer Simulator
Purpose: Simulate balls being kicked and see if they collide.
*****************************************************************************************************************************************************************************************************************************/

public class Ball{
	public double radius = 4.45; //Radius in inches
	public double ballRadius = 4.45/12; //Radius in feet
	public static double colDist = 8.9/12;
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
	public void updatePosition(double ts){
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
			if(ts < 1){
			  xPosition += velocity*ts;
		  }else{
			  xPosition += velocity;
		  }
		}else if(direction == 90){
			if(ts < 1){
			  yPosition += velocity*ts;
		  }else{
			  yPosition += velocity;
		  }
		}else if(direction == 180){
			if(ts < 1){
			  xPosition -= velocity*ts;
		  }else{
			  xPosition -= velocity;
		  }
		}else if(direction == 270){
			if(ts < 1){
			  yPosition -= velocity*ts;
		  }else{
			  yPosition -= velocity;
		  }
		}
	}

	public static boolean isCollided(double ballOnex,double ballOney, double ballTwox,double ballTwoy){
		if((Math.sqrt((ballTwox-ballOnex)*(ballTwox-ballOnex) + (ballTwoy-ballOney)*(ballTwoy-ballOney))) <= colDist){
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
