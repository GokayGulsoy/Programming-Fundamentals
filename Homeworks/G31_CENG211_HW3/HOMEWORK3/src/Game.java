public abstract class Game {

	  // instance variables of abstract class
      private String name;
      private int arrivalDay;
      private double averageRating;
      private double ratingValue; // value assigned by game critics to game
      private String Checker; // instance variable that is used to indicate that game is already checked by any other game critic
      
      
      // constructor for abstract class
      public Game(String name,int arrivalDay,double averageRating) {
    	  
    	  this.name = name;
    	  this.arrivalDay = arrivalDay;
    	  this.averageRating = averageRating;
    	  this.ratingValue = 0; //  rating value is initialized as 0,latter it will be assigned by game critics
    	  setChecker("");
      }
      
      // getters (accessors) for abstract class Game
      
      public String getName() {
    	  
    	  return name;
      }
       
      
      public int getArrivalDay() {
    	  
    	  return arrivalDay;
      }
      
      
      public double getAverageRating() {
    	  
    	  return averageRating;
      }

      
      public double getRatingValue() {
    	  
    	return ratingValue;
      }
      
      
  	 public String getChecker() {
		
  		 return Checker;
	 }

      
      // setter (mutator) for Game class
      
      public void setRatingValue(double ratingValue) {
    	  
         this.ratingValue = ratingValue;   
      }


	  public void setChecker(String checker) {
		 
		 Checker = checker;
	  }
      
      
      
	
}  

