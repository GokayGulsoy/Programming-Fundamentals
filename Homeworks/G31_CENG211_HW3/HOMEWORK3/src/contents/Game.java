package contents;

/**
 * @author Gökay Gülsoy
 */
public abstract class Game extends Content {

    private int remainingHours; // holds the remaining time for game

    // constructor for abstract class
    public Game(String name, int arrivalDay, int contentType, double averageRating, int remainingHours) {
        super(name, arrivalDay, contentType, averageRating);
        this.remainingHours = remainingHours;
    }

    // getters (accessors) for abstract class Game
    public int getRemainingHours() {
        return remainingHours;
    }

    public void setRemainingHours(int remainingHours) {
        this.remainingHours = remainingHours;
    }

    @Override
    public String toString() {
        return getName() + "," + String.format("%.2f", getRatingValue());
    }
}
