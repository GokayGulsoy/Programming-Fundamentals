public class MovieCritic extends Worker implements ratableMovie {

	  // instance variable for MovieCritic subclass
	  private int amountWatched;
	
	  // constructor for MovieCritic subclass
	  public MovieCritic(double opinion,String order) {
		   
		  super(opinion,order);
		  amountWatched = 0; // amount of watched movies in day  
	  }

	 
	  // getter (accessor) for amountWatched instance variable
	  public int getAmountWatched() {
		  
		  return amountWatched;
	  }
	  
	  // setter (mutator) for amountWatched instance variable
	  public void setAmountWatched(int amountWatched) {
		  
		  this.amountWatched = amountWatched;
	  }
	  
	  
	 // ratMovie method calculates the rating for a movie
	 public double rateMovie(Movie movie) {
	
		 return movie.getAverageRating() + ((movie.getDuration()-150)*0.01) - ((2021-movie.getYear())*0.01) + super.getOpinion();
	 }
	   
	 
	 
	 
}
