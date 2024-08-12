public class Movie {

	// instance variables for Movie class
	private String name;
	private int arrivalDay;
	private int year;
	private int duration;  // in minutes
	private double averageRating;
	private double ratingValue; // value assigned by movieCritics to movie
	
	
	// constructor for movie class
	public Movie(String name,int arrivalDay,int year,int duration,double averageRating) {
		
		this.name = name;
		this.arrivalDay = arrivalDay;
		this.year = year;
		this.duration = duration;
		this.averageRating = averageRating;
	    this.ratingValue = 0; // ratingValue is initialized as 0 later it will be assigned by movie critics
	}
	
	
	// getters (accessors) for movie class
	public String getName() {
		
		return name;
	}
	
	
	public int getArrivalDay() {
		
		return arrivalDay;
	}
	
	
	
	public int getYear() {
		
		return year;
	}
	
	
	public int getDuration() {
		
		return duration;
	}
	
	
	public double getAverageRating() {
		
		return averageRating;
	}
	
	
	public double getRatingValue() {
		
		return ratingValue;
	}
	
	// setter (mutator) for Movie class
	
    public void setRatingValue(double ratingValue) {
    	
    	this.ratingValue = ratingValue;
    }
	
	
	
}
