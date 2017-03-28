public class Time{
	public static final double defaultSlice = 1; //In seconds, this is the constant time slice. The user doesn't input a time slice.
	double totalSeconds = 0;
	
	public Time(double slice){
		totalSeconds = totalSeconds;
		slice = slice; // the time that the user wants to output information
	}
	
    public String toString(){
	    double seconds = 0;
        double minutes = 0;
        double hours = 0;
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

	public double tick(){
		totalSeconds += defaultSlice;
		return totalSeconds;
	}	
	
}