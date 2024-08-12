public class StoryGame extends Game {

	// instance variable peculiar to StroyGame subclass
	private int storyDuration;
	
	
	// constructor for subclass StoryGame
	public StoryGame(String name,int arrivalDay,double averageRating,int storyDuration) {
		
		super(name,arrivalDay,averageRating);
		this.storyDuration = storyDuration;
	}

	// getter (accessor) for storyDuration 
	public int getStoryDuration() {
		
		return storyDuration;
	}
	
	
	public void setStoryDuration(int storyDuration) {
		
		this.storyDuration = storyDuration;
	}
	
	
	
}
