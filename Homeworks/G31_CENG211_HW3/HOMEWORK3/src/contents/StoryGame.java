package contents;

import workers.Worker;

/**
 * @author Gökay Gülsoy
 */
public class StoryGame extends Game implements RatableContent {

    private int storyDuration;

    // constructor for subclass StoryGame
    public StoryGame(String name, int arrivalDay, int contentType, double averageRating, int remainingHours) {
        super(name, arrivalDay, contentType, averageRating, remainingHours);
        this.storyDuration = remainingHours;
    }

    //getter (accessor) for StoryGame class
    public int getStoryDuration() {
        return storyDuration;
    }

    //  rate calculation logic for StoryGame class
    @Override
    public double rateContent(Worker critic) {
        return (getAverageRating() + (storyDuration * 0.25) + critic.getOpinion());
    }

}
