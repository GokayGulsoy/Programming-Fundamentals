package workers;

import contents.Game;

/**
 *
 * @author Gökay Gülsoy
 */
public class GameCritic extends Worker {

    private int timeWorked;
    private int casualMatchesPlayed;
    private Game assignedGame;

    // constructor for GameCritic class
    public GameCritic(double opinion, int orderNumber) {
        super(opinion, orderNumber);
        this.timeWorked = 0;
        this.casualMatchesPlayed = 0;
        this.assignedGame = null;
    }

    // getters (accessors) for GameCritic class
    public int getTimeWorked() {
        return timeWorked;
    }

    public int getCasualMatchesPlayed() {
        return casualMatchesPlayed;
    }

    public Game getAssignedGame() {
        return assignedGame;
    }

    // setters (mutators) for GameCritic class
    public void setTimeWorked(int timeWorked) {
        this.timeWorked = timeWorked;
    }

    public void setCasualMatchesPlayed(int casualMatchesPlayed) {
        this.casualMatchesPlayed = casualMatchesPlayed;
    }

    public void setAssignedGame(Game assignedGame) {
        this.assignedGame = assignedGame;
    }

}
