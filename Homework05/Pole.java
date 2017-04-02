// How to generate either positive or negative one

public class Pole{
	public double xPos;
	public double yPos;
	private double poleRadius = 4.45/12;
	private double x = 1;

	public Pole(double fieldx,double fieldy){
		if(0 == Math.round(Math.random())){
			x = -1;
		}
		xPos = (x * (((Math.random() * fieldx) - (fieldx/2)) + 1));
		yPos = (x * (((Math.random() * fieldy) - (fieldy/2)) + 1));
	}
}
