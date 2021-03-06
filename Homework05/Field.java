/*****************************************************************************************************************************************************************************************************************************
File Name: Field.java
Author: James Byrne
Date: 4/2/2017
Class: 186
Project Name: Soccer Simulator
Purpose: Simulate balls being kicked and see if they collide.
*****************************************************************************************************************************************************************************************************************************/

public class Field{
	double right;
	double left;
	double top;
	double bot;
	double radius  = 4.45/12;

	public Field(double fx,double fy){
		right = (fx / 2) - radius;
	    left = right * (-1);
	    top = (fy / 2) - radius;
	    bot = top * (-1);
	}

	public boolean isOutOfBounds(double ballxPos, double ballyPos){
	    return !(ballxPos < right && ballxPos > left && ballyPos < top && ballyPos > bot);
		// returns true if ball is out of bounds
		// returns false if ball is in bounds
	}
}
