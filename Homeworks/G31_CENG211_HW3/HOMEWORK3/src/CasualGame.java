public class CasualGame extends Game {
    
	// instance variables peculiar to Casual game subclass
	private int matchDuration;
	
	// constructor for subclass CasualGame
	public CasualGame(String name,int arrivalDay,double averageRating,int matchDuration) {
	
		super(name,arrivalDay,averageRating);
		this.matchDuration = matchDuration;
	}
	
	
	// getter (accessor) for matchDuration
	public int getMatchDuration() {
		
		return matchDuration;
	}
	
	
	// setter for mactch duration
	
	public void setMatchDuration(int matchDuration) {
		
		this.matchDuration = matchDuration;
	}
	
	
	

}
