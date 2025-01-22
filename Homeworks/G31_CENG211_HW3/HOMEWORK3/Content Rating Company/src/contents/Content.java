package contents;

/**
 *
 * @author Gökay Gülsoy
 */
public abstract class Content implements Comparable {

    private String name;
    private int arrivalDay;
    private int contentType;
    private double averageRating;
    private double ratingValue; // value assigned by critic to content

    // constructor for Content abstract class
    public Content(String name, int arrivalDay, int contentType, double averageRating) {
        this.name = name;
        this.arrivalDay = arrivalDay;
        this.contentType = contentType;
        this.averageRating = averageRating;
        this.ratingValue = 0; // rating value is initialized as 0, latter it will be assigned by critics
    }

    // getters (accessors) for Content abstract class 
    public String getName() {
        return name;
    }

    public int getArrivalDay() {
        return arrivalDay;
    }

    public int getContentType() {
        return contentType;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public double getRatingValue() {
        return ratingValue;
    }

    // setters (mutators) for Content abstract class 
    public void setRatingValue(double ratingValue) {
        this.ratingValue = ratingValue;
    }

    @Override
    public int compareTo(Object otherObject) {
        Content otherContent = (Content) otherObject;
        if (name.compareTo(otherContent.getName()) < 0) {
            return -1;
        } else if (name.compareTo(otherContent.getName()) > 0) {
            return 1;
        } else { // name.compareTo(otherContent.getName()) == 0
            return 0;
        }
    }

}
