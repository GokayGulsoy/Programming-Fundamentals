public class GameCritic extends Worker implements ratableGame{

	// instance variables peculiar to GameCritic subclass
	private int workTime; // maximum value for work time is 8 hours for game critic
	private int casualMatches; // one game critic can play at most 3 casual matches

	// constructor for GameCrtic class
	public GameCritic(double opinion,String order) {
		
		super(opinion,order);
		setWorkTime(0);
		setCasualMatches(0);
	}
	
	public double rateIndefiniteGame(IndefiniteGame game) {
		
		
		return game.getAverageRating() + ((10 - game.getMinimumEvaluationTime())*0.25) + super.getOpinion();
	}
	
	public double rateStoryGame(StoryGame game) {
		
		
		return game.getAverageRating() + (game.getStoryDuration()*0.25) + super.getOpinion();  
	}

	
	public double rateCasualGame(CasualGame game) {
	
	   return game.getAverageRating() + ((game.getMatchDuration()-3)*3) + super.getOpinion();
	}

	// getters (accessors) for gameCritic subclass
	
	public int getWorkTime() {
		
		return workTime;
	}
		

	public int getCasualMatches() {
		
		return casualMatches;
	}
	

	// setters (mutators) for gameCritic subclass
	
	public void setWorkTime(int workTime) {
		
		this.workTime = workTime;
	}

	
	public void setCasualMatches(int casualMatches) {
		
		this.casualMatches = casualMatches;
	}




	
	
}
