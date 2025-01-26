package contents;

import workers.Worker;

/**
 *
 * @author Gökay Gülsoy
 */
public class Movie extends Content implements RatableContent {

    private int year;
    private int duration;

    // constructor for Movie class
    public Movie(String name, int arrivalDay, int year, int contentType, int duration, double averageRating) {
        super(name, arrivalDay, contentType, averageRating);
        this.year = year;
        this.duration = duration;
    }

    // getters (accessors) for Movie class
    public int getYear() {
        return year;
    }

    public int getDuration() {
        return duration;
    }

    // rate calculation logic for Movie class
    @Override
    public double rateContent(Worker critic) {
        return (getAverageRating() + ((duration - 150) * 0.01) - ((2021 - year) * 0.01) + critic.getOpinion());
    }

    @Override
    public String toString() {
        return getName() + "(" + year + ")," + String.format("%.2f", getRatingValue());
    }
}
