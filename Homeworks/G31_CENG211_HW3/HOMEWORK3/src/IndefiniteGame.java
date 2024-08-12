public class IndefiniteGame extends Game {

	// instance variables peculiar to this subclass
	private int minimumEvaluationTime;
	private int remainingHours; // instance variable that hold the remaining play time from indefinite game 
	
	// constructor for subclass IndefiniteGame
	public IndefiniteGame(String name,int arrivalDay,double averageRating,int minimumEvaluationTime) {
		
		super(name,arrivalDay,averageRating);
		this.minimumEvaluationTime = minimumEvaluationTime;
		remainingHours = 4;
	}
	
	
	// getter (accessor) for minimumEvaluationTime
	public int getMinimumEvaluationTime() {
		
		return minimumEvaluationTime;
	}
	
	
	public int getRemainingHours() {

		return remainingHours;
	}

	
	
	// setter (mutator) for minimumEvaluationTime
	
	public void setMinimumEvaluationTime(int playedTime) {
		
         minimumEvaluationTime = playedTime;
	}

	public void setRemainingHours(int remainingHours) {
		
		this.remainingHours = remainingHours;
	}
	
	
	
	
	
	
}
