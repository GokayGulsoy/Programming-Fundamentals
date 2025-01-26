package contents;

import workers.Worker;

/**
 * @author Gökay Gülsoy
 */
public class IndefiniteGame extends Game implements RatableContent {

    private int minimumEvaluationTime; // in hours

    // constructor for subclass
    public IndefiniteGame(String name, int arrivalDay, int contentType, double AverageRating, int remainingHours) {
        super(name, arrivalDay, contentType, AverageRating, remainingHours);
        this.minimumEvaluationTime = remainingHours;
    }

    // getters (accessors) for IndefiniteGame class
    public int getMinimumEvaluationTime() {
        return minimumEvaluationTime;
    }

    // rate calculation logic for IndefiniteGame class
    @Override
    public double rateContent(Worker critic) {
        return (getAverageRating() + ((10 - minimumEvaluationTime) * 0.25) + critic.getOpinion());
    }

}
