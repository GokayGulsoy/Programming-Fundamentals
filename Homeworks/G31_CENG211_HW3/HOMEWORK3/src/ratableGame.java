public interface ratableGame {

	 /*  interface for a game critic that contains 
	     methods rateIndefiniteGame, rateStoryGame, rateCasualGame
	 */
	
	
	/**
	 rateIndefiniteGame calculates rate for Indefinite games
    */
	public double rateIndefiniteGame(IndefiniteGame game);
	
	
	/**
	rateStoryGame calculates rate for Story games
    */
	
	public double rateStoryGame(StoryGame game);
	
	/**
	rateCasualGame calculates rate for Casual games
    */
	
	public double rateCasualGame(CasualGame game);
		
}


