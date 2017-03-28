// How to generate either positive or negative one

public class Pole{
	private double xPos;
	private double yPos;
	private double poleRadius = 4.45;
	
	public Pole(double fieldx,double fieldy){
		xPos = (Math.random()*2 -1) * (((Math.random() * fieldx) - (fieldx/2)) + 1);
		yPos = (Math.random()*2 -1) * (((Math.random() * fieldy) - (fieldy/2)) + 1);
	}
}