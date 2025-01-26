package contents;

import workers.Worker;

/**
 *
 * @author Gökay Gülsoy
 */
public class CasualGame extends Game implements RatableContent {

    private int matchDuration;

    // constructor for CasualGame class
    public CasualGame(String name, int arrivalDay, int contentType, double averageRating, int remainingHours) {
        super(name, arrivalDay, contentType, averageRating, remainingHours);
        this.matchDuration = remainingHours / 3;
    }

    // getter (accessor) for CasualGame class
    public int getMatchDuration() {
        return matchDuration;
    }

    //  rate calculation logic for CasualGame class
    @Override
    public double rateContent(Worker critic) {
        return (getAverageRating() + ((matchDuration - 3) * 3) + critic.getOpinion());
    }

}
