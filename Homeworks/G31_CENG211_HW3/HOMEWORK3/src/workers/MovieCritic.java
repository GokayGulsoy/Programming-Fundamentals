package workers;

/**
 *
 * @author Gökay Gülsoy
 */
public class MovieCritic extends Worker {

    private boolean hasWatched;

    // constructor for MovieCritic class
    public MovieCritic(double opinion, int orderNumber) {
        super(opinion, orderNumber);
        this.hasWatched = false; // movie critic can watch only 1 movie in a day
    }

    // getter (accessor) for MovieCritic class
    public boolean getHasWatched() {
        return hasWatched;
    }

    // setter (mutator) for MovieCritic class
    public void setHasWatched(boolean hasWatched) {
        this.hasWatched = hasWatched;
    }

}
