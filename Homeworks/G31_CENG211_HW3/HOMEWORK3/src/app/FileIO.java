package app;

import contents.CasualGame;
import contents.IndefiniteGame;
import contents.Movie;
import contents.StoryGame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Gökay Gülsoy
 */
public class FileIO {

    public void readContents(RatingCompany ratingCompany) {

        try {
            File csvFile = new File("contents.csv");
            Scanner fileReader = new Scanner(csvFile);

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                int arrivalDay = Integer.parseInt(tokenizer.nextToken());
                int contentType = Integer.parseInt(tokenizer.nextToken());
                String name = tokenizer.nextToken();

                switch (contentType) {
                    case 0: {
                        // Movie
                        int year = Integer.parseInt(tokenizer.nextToken());
                        int duration = Integer.parseInt(tokenizer.nextToken());
                        double averageRating = Double.parseDouble(tokenizer.nextToken());
                        Movie movie = new Movie(name, arrivalDay, year, contentType, duration, averageRating);
                        ratingCompany.addContent(movie);
                        break;
                    }
                    case 1: {
                        // IndefiniteGame
                        int minimumEvaluationTime = Integer.parseInt(tokenizer.nextToken());
                        double averageRating = Double.parseDouble(tokenizer.nextToken());
                        IndefiniteGame indefiniteGame = new IndefiniteGame(name, arrivalDay, contentType, averageRating, minimumEvaluationTime);
                        ratingCompany.addContent(indefiniteGame);
                        break;
                    }
                    case 2: {
                        // StoryGame
                        int storyDuration = Integer.parseInt(tokenizer.nextToken());
                        double averageRating = Double.parseDouble(tokenizer.nextToken());
                        StoryGame storyGame = new StoryGame(name, arrivalDay, contentType, averageRating, storyDuration);
                        ratingCompany.addContent(storyGame);
                        break;
                    }
                    default: {
                        // CasualGame
                        int matchDuration = Integer.parseInt(tokenizer.nextToken());
                        double averageRating = Double.parseDouble(tokenizer.nextToken());
                        // CasualGames must be played for 3 matches for evaluation
                        CasualGame casualGame = new CasualGame(name, arrivalDay, contentType, averageRating, matchDuration * 3);
                        ratingCompany.addContent(casualGame);
                        break;
                    }
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("contents.csv file does not exist in the project root directory");
            System.exit(0);
        }

    }

}
