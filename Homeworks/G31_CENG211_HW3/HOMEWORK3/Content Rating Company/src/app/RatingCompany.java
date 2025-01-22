package app;

import collections.ContentStack;
import collections.WorkerQueue;
import contents.CasualGame;
import contents.Content;
import contents.Game;
import contents.IndefiniteGame;
import contents.Movie;
import contents.StoryGame;
import java.util.ArrayList;
import workers.GameCritic;
import workers.MovieCritic;
import workers.Worker;

/**
 *
 * @author Gökay Gülsoy
 */
public class RatingCompany {

    private ArrayList<Content> contentRepo;
    private WorkerQueue<Worker> workerQueue;
    private ContentStack<Game> gameStack;
    private ContentStack<Movie> movieStack;
    private ArrayList<Movie> evaluatedMovies;
    private ArrayList<Game> evaluatedGames;
    private ArrayList<GameCritic> ongoingEvaluations;
    private ArrayList<GameCritic> completedEvaluations;
    private ArrayList<GameCritic> newEvaluators;
    private int ratingDay;
    private int evaluationHoursPassed;
    private int evaluationMinutesPassed;

    // contructor for RatingCompany class
    public RatingCompany() {
        contentRepo = new ArrayList<>();
        workerQueue = new WorkerQueue<>();
        gameStack = new ContentStack<>();
        movieStack = new ContentStack<>();
        evaluatedMovies = new ArrayList<>();
        evaluatedGames = new ArrayList<>();
        ongoingEvaluations = new ArrayList<>();
        completedEvaluations = new ArrayList<>();
        newEvaluators = new ArrayList<>();
        ratingDay = 1;
        evaluationHoursPassed = 0;
        evaluationMinutesPassed = 0;
    }

    // adds given content to contentRepo
    public void addContent(Content content) {
        contentRepo.add(content);
    }

    public void rateContents() {
        // start simulation
        initializeWorkerQueue();
        System.out.println(ratingDay + ".day: ");

        // evaluation process continue for 5 days
        while (ratingDay <= 5) {
            // order contents for current day
            orderContents();
            Worker worker = workerQueue.getFront();
            if (worker instanceof MovieCritic) {
                MovieCritic movieCritic = (MovieCritic) worker;
                if (movieCritic.getHasWatched()) {
                    // MovieCritic has already watched movie in a given day
                    workerQueue.dequeue();
                    workerQueue.enqueue(movieCritic);
                    continue;
                }

                worker = workerQueue.dequeue();
                if (!movieStack.isEmpty()) {
                    Movie movieUnderEvaluation = movieStack.pop();
                    evaluateMovie(movieUnderEvaluation, (MovieCritic) worker);
                }

                workerQueue.enqueue(worker);
            } else if (worker instanceof GameCritic) {
                GameCritic gameCritic = (GameCritic) worker;
                if (gameCritic.getTimeWorked() == 8) {
                    // GameCritic has already worked for 8 hours in a given day (cannot work more!)
                    workerQueue.enqueue(worker);
                    continue;
                }

                worker = workerQueue.dequeue();
                if (!gameStack.isEmpty()) {
                    Game gameUnderEvaluation = gameStack.pop();
                    evaluateGame(gameUnderEvaluation, (GameCritic) worker);
                } else { // if it is the turn of GameCritic but 
                    // there is no game to evaluate in gameStack
                    workerQueue.enqueue(worker);
                }

            }

            // after evaluation if fifth day is finished stop simulation
            if (ratingDay == 6) {
                break;
            }

            // evaluate ongoing evaluations after dequeue operation
            proceedOngoingEvaluations();

            // if all the contents are evaluated before 24 hours reached
            // advance to next day for new evaluations
            if (movieStack.isEmpty() && gameStack.isEmpty() && ongoingEvaluations.isEmpty()) {
                advanceNextDay();
                evaluationHoursPassed = 0;
                evaluationMinutesPassed = 0;
            }

        }

        // diplay ratings after evaluations are completed
        ContentSorter<Movie> movieSorter = new ContentSorter<>();
        ContentSorter<Game> gameSorter = new ContentSorter<>();
        movieSorter.sort(evaluatedMovies);
        gameSorter.sort(evaluatedGames);
        displayRatings();
    }

    // initializes queue of workers with movie and game critics
    private void initializeWorkerQueue() {
        // initializing MovieCritic objects
        MovieCritic movieCritic1 = new MovieCritic(0.1, 1);
        MovieCritic movieCritic2 = new MovieCritic(-0.2, 2);
        MovieCritic movieCritic3 = new MovieCritic(0.3, 3);

        // initializing GameCritic objects
        GameCritic gameCritic1 = new GameCritic(5, 1);
        GameCritic gameCritic2 = new GameCritic(9, 2);
        GameCritic gameCritic3 = new GameCritic(-3, 3);
        GameCritic gameCritic4 = new GameCritic(2, 4);
        GameCritic gameCritic5 = new GameCritic(-7, 5);

        // adding Workers to workerQueue
        workerQueue.enqueue(movieCritic1);
        workerQueue.enqueue(movieCritic2);
        workerQueue.enqueue(movieCritic3);
        workerQueue.enqueue(gameCritic1);
        workerQueue.enqueue(gameCritic2);
        workerQueue.enqueue(gameCritic3);
        workerQueue.enqueue(gameCritic4);
        workerQueue.enqueue(gameCritic5);
    }

    // pushes new contents for which arrivalDay is reached to stacks
    private void orderContents() {
        ArrayList<Content> contentsToBeRemoved = new ArrayList<>();
        for (Content content : contentRepo) {
            if (content.getArrivalDay() == ratingDay) {
                if (content.getContentType() == 0) { //Movie
                    movieStack.push((Movie) content);
                } else { // Game
                    gameStack.push((Game) content);
                }

                contentsToBeRemoved.add(content);
            }
        }

        // remove all contents which have arrived
        contentRepo.removeAll(contentsToBeRemoved);
    }

    // evaluates movie by assigned MovieCritic object
    private void evaluateMovie(Movie movie, MovieCritic movieCritic) {

        int hoursPassed = movie.getDuration() / 60;
        int minutesPassed = movie.getDuration() % 60;

        evaluationHoursPassed += hoursPassed;
        evaluationMinutesPassed += minutesPassed;

        double rating = movie.rateContent(movieCritic);
        movie.setRatingValue(rating);
        evaluatedMovies.add(movie);
        displayEvaluationMessage(movieCritic, "movie critic evaluated", movie);

        advanceNextHour(evaluationMinutesPassed);
        if (evaluationHoursPassed >= 24) {
            evaluationHoursPassed %= 24;
            advanceNextDay();
        }

    }

    // evaluates game by assigned GameCritic object
    private void evaluateGame(Game game, GameCritic gameCritic) {
        if (gameCritic.getTimeWorked() == 8) {
            return;
        }

        // evaluation criteria for game depends on game type
        if (game instanceof IndefiniteGame) {
            int availableHoursToWork = 8 - gameCritic.getTimeWorked();
            if (availableHoursToWork >= 4) {
                if (game.getRemainingHours() <= 4) {
                    // IndefiniteGame can be evaluated
                    completeEvaluation(game, availableHoursToWork, gameCritic);
                } else {
                    availableHoursToWork -= 4;
                    int remainingHours = game.getRemainingHours();
                    game.setRemainingHours(remainingHours - 4);
                    gameCritic.setTimeWorked(8 - availableHoursToWork);
                    gameCritic.setAssignedGame(game);
                    evaluationHoursPassed += 4;

                    if (!ongoingEvaluations.contains(gameCritic)) {
                        newEvaluators.add(gameCritic);
                        displayEvaluationMessage(gameCritic, "game critic works on", game);
                    }

                }
            } else { // case where availableHoursToWork < 4
                if (game.getRemainingHours() <= availableHoursToWork) {
                    completeEvaluation(game, availableHoursToWork, gameCritic);
                } else {
                    continueEvaluation(game, availableHoursToWork, gameCritic);
                }

            }

        } // we handle CasualGame and StoryGame inside same else if block as 
        // their logic for time calculations are same
        else if (game instanceof CasualGame || game instanceof StoryGame) {
            int availableHoursToWork = 8 - gameCritic.getTimeWorked();
            //case in which GameCritic can complete CasualGame or StoryGame
            if (availableHoursToWork >= game.getRemainingHours()) {
                completeEvaluation(game, availableHoursToWork, gameCritic);
            } else { // case where availableHoursToWork < game.getRemainingHours()
                continueEvaluation(game, availableHoursToWork, gameCritic);
            }

        }

        if (!newEvaluators.isEmpty()) {
            // add new GameCritics who are working on evaluation
            ongoingEvaluations.addAll(newEvaluators);
            newEvaluators.clear();
        }

        if (evaluationHoursPassed >= 24) {
            evaluationHoursPassed %= 24;
            advanceNextDay();
        }
    }

    // advances to next day
    private void advanceNextDay() {
        ratingDay++;
        if (ratingDay != 6) {
            System.out.println(ratingDay + ".day: ");
            updateWorkingAndWatchingConditions();
        }
    }

    // advances next hour if evaluationMinutes >= 60
    private void advanceNextHour(int minutesPassed) {
        if (minutesPassed >= 60) {
            evaluationHoursPassed += minutesPassed / 60;
            evaluationMinutesPassed = minutesPassed % 60;
        }
    }

    // if next day is advanced set hasWatched field of each
    // MovieCritic object to false if it was true (already watched movie in a given day) 
    // previously. If next day is advanced set TimeWorked field of each
    // GameCritic object in workerQueue and ongoingEvaluations
    // to 0 as working hours reset
    private void updateWorkingAndWatchingConditions() {
        ArrayList<Worker> queueEntries = new ArrayList<>();

        // reseting working hours of GameCritics in workerQueue
        while (!workerQueue.isEmpty()) {
            Worker worker = workerQueue.dequeue();
            if (worker instanceof GameCritic) {
                GameCritic gameCritic = (GameCritic) worker;
                gameCritic.setTimeWorked(0);
            } else if (worker instanceof MovieCritic) {
                MovieCritic movieCritic = (MovieCritic) worker;
                if (movieCritic.getHasWatched()) {
                    movieCritic.setHasWatched(false);
                }

            }

            queueEntries.add(worker);
        }

        // add all entries to workerQueue again
        for (Worker worker : queueEntries) {
            workerQueue.enqueue(worker);
        }

        queueEntries.clear();

        // reseting working hours of GameCritics in ongoingEvaluations list
        for (GameCritic gameCritic : ongoingEvaluations) {
            gameCritic.setTimeWorked(0);
        }

    }

    // Add completed games to completedEvaluations list 
    // in order to remove the gameCritic from ongoingEvaluations list
    private void addToCompletedEvaluations(GameCritic gameCritic) {
        for (int i = 0; i < ongoingEvaluations.size(); i++) {
            if (ongoingEvaluations.get(i).getOrderNumber() == gameCritic.getOrderNumber()) {
                completedEvaluations.add(gameCritic);
            }
        }
    }

    // evaluate ongoing evaluations after each dequeue
    // operation from workerQueue
    private void proceedOngoingEvaluations() {
        // if there exists completed evaluations
        // remove them from ongoingEvaluations before
        // checking ongoing evaluations
        if (!completedEvaluations.isEmpty()) {
            ongoingEvaluations.removeAll(completedEvaluations);
            completedEvaluations.clear();
        }

        // continue each ongoing evaluation
        for (GameCritic gameCritic : ongoingEvaluations) {
            evaluateGame(gameCritic.getAssignedGame(), gameCritic);
        }
    }

    // complete the evaluation of game
    private void completeEvaluation(Game game, int availableHoursToWork, GameCritic gameCritic) {
        availableHoursToWork -= game.getRemainingHours();
        evaluationHoursPassed += game.getRemainingHours();
        game.setRemainingHours(0);
        double rating = 0;

        if (game instanceof IndefiniteGame) {
            IndefiniteGame indefiniteGame = (IndefiniteGame) game;
            rating = indefiniteGame.rateContent(gameCritic);
            indefiniteGame.setRatingValue(rating);

        } else if (game instanceof StoryGame) {
            StoryGame storyGame = (StoryGame) game;
            rating = storyGame.rateContent(gameCritic);
            storyGame.setRatingValue(rating);
        } else if (game instanceof CasualGame) {
            CasualGame casualGame = (CasualGame) game;
            rating = casualGame.rateContent(gameCritic);
            casualGame.setRatingValue(rating);
        }

        evaluatedGames.add(game);
        gameCritic.setAssignedGame(null);
        addToCompletedEvaluations(gameCritic);
        gameCritic.setTimeWorked(8 - availableHoursToWork);
        workerQueue.enqueue(gameCritic);
        displayEvaluationMessage(gameCritic, "game critic evaluated", game);
    }

    // continue evaluation of game
    private void continueEvaluation(Game game, int availableHoursToWork, GameCritic gameCritic) {
        int remainigHours = game.getRemainingHours();
        game.setRemainingHours(remainigHours - availableHoursToWork);
        gameCritic.setAssignedGame(game);
        gameCritic.setTimeWorked(8);
        evaluationHoursPassed += availableHoursToWork;

        if (!ongoingEvaluations.contains(gameCritic)) {
            newEvaluators.add(gameCritic);
            displayEvaluationMessage(gameCritic, "game critic works on", game);
        }

    }

    // display evaluation message according to state of evaluation
    private void displayEvaluationMessage(Worker gameCritic, String message, Content game) {
        System.out.println("\t" + gameCritic.getOrderNumber() + "." + message + "(" + game.getName() + ")");
    }

    // display ratings with Content names
    private void displayRatings() {
        System.out.println("Ratings:");
        for (Movie movie : evaluatedMovies) {
            System.out.println("\t" + movie.toString());
        }

        for (Game game : evaluatedGames) {
            System.out.println("\t" + game.toString());
        }

    }

}
