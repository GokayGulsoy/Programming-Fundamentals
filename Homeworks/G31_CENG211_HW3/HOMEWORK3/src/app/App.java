package app;

/**
 *
 * @author Gökay Gülsoy
 */
public class App {

    public static void main(String[] args) {
        RatingCompany ratingCompany = new RatingCompany();
        FileIO fileHandler = new FileIO();
        // reading contents from contents.csv file
        fileHandler.readContents(ratingCompany);
        // running simulation
        ratingCompany.rateContents();
    }

}
