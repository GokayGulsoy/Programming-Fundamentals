import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.StringTokenizer;

public class FileIO {

	
	 // method that reads movies to MovieStackADT
	 public MovieStackADT readMovies() {
		 
		 // we hold movies in a stack
		 MovieStackADT movieStack = new MovieStackADT();
		 
		 Scanner inputStream = null;
		 
		 try {
			 inputStream = new Scanner(new FileInputStream("contents.csv"));
			 
		 }
		 
		 catch (FileNotFoundException e) {
			 
			 System.out.println("File not found");
			 System.exit(0);
		 }
		 
		 
		 int count = 0;
		 
		 /*
		    As there are 15 movies we will iterate 15 times  
		    to form all movies and add them to movieStack 
		 */
		  
		 while (count < 15) {
			 
			 String line = inputStream.nextLine();
			 
			 StringTokenizer tokenizer = new StringTokenizer(line,",");
			 
			 // tokenizing each line for movies to form movie objects
			 String arrival = tokenizer.nextToken();
			 int arrivalDay = Integer.parseInt(arrival);
			 
			 /* 
			  second item in a line is not important because zero(0) indicates
			  that object is a movie so we need to consume it 
			 */
			 
			 tokenizer.nextToken();
			 
			 String name = tokenizer.nextToken();
			 String yearString = tokenizer.nextToken();
			 int year = Integer.parseInt(yearString);
			 String durationString = tokenizer.nextToken();
			 int duration = Integer.parseInt(durationString);
			 String averageRatingString =  tokenizer.nextToken();
			 double averageRating = Double.parseDouble(averageRatingString);
			 
			 // forming the movie object and adding it to stack
			 movieStack.push(new Movie(name,arrivalDay,year,duration,averageRating));
			 
			 count++;
			 
		 }
		 
		 // at the end of the while loop moviesStack will contain Movie objects
		 return movieStack;
	 }
	 
	 
	 
	 public GameStackADT readGames() {
		 
		 GameStackADT gameStack = new GameStackADT();
		 
		 Scanner inputStream = null;
		 
		 try {
			 
			 inputStream = new Scanner(new FileInputStream("contents.csv"));
		 }
		 
		 catch (FileNotFoundException e) {
			 
			 System.out.println("File not found");
			 System.exit(0);
			 
		 }
		 
		 while (inputStream.hasNext()) {
			 
			 String line = inputStream.nextLine();
	
			 StringTokenizer tokenizer = new StringTokenizer(line,",");
			 
			 String arrivalDayString = tokenizer.nextToken();
			 int arrivalDay = Integer.parseInt(arrivalDayString);
			 
			 // itemNo number that indicates movie or game
			 String itemNo = tokenizer.nextToken();
			 String name = tokenizer.nextToken();
			 
		
			 // case in which game is indefiniteGame
			 if (itemNo.equals("1")) {
				 
				 String minimumEvaluationTimeString = tokenizer.nextToken();
				 int minimumEvaluationTime = Integer.parseInt(minimumEvaluationTimeString);
				 String averageRatingString = tokenizer.nextToken();
				 double averageRating = Double.parseDouble(averageRatingString);
				 
				 gameStack.push(new IndefiniteGame(name,arrivalDay,averageRating,minimumEvaluationTime));
				 
			 }
			 
			 // case in which game is StoryGame
			 else if (itemNo.equals("2")) {
				
				 String storyDurationString = tokenizer.nextToken();
				 int storyDuration = Integer.parseInt(storyDurationString);
				 String averageRatingString = tokenizer.nextToken();
				 double averageRating = Double.parseDouble(averageRatingString);
				 
				 gameStack.push(new StoryGame(name,arrivalDay,averageRating,storyDuration));
				 
			 }
			 
			 
			 // case in which game is CasualGame
			 else if (itemNo.equals("3")) {
				 
				 String matchDurationString = tokenizer.nextToken();
				 int matchDuration = Integer.parseInt(matchDurationString);
				 String averageRatingString = tokenizer.nextToken();
			     double averageRating = Double.parseDouble(averageRatingString); 
				 
				 gameStack.push(new CasualGame(name,arrivalDay,averageRating,matchDuration));
			     
			 } 
			 
		 }
		 
		 return gameStack;
	 }
	 
     
      // formWorkerQueue mehtod creates objects of critics,adds them to queue and returns the queue 
	  public WorkerQueue formWorkerQueue() {
		  
		  WorkerQueue workerQueue = new WorkerQueue();
		  
		  // creating 3 movieCritic objects
		  
		  MovieCritic movieCritic1 = new MovieCritic(0.1,"1.");
		  MovieCritic movieCritic2 = new MovieCritic(-0.2,"2.");
		  MovieCritic movieCritic3 = new MovieCritic(0.3,"3.");
		  
		  // adding movie critics to queue 
		  
		  workerQueue.addToBack(movieCritic1);
		  workerQueue.addToBack(movieCritic2);
		  workerQueue.addToBack(movieCritic3);
		  
		  // creating 5 game critic objects 
		  GameCritic gameCritic1 = new GameCritic(5,"1.");
		  GameCritic gameCritic2 = new GameCritic(9,"2.");
		  GameCritic gameCritic3 = new GameCritic(-3,"3.");
		  GameCritic gameCritic4 = new GameCritic(2,"4.");
		  GameCritic gameCritic5 = new GameCritic(-7,"5.");
		  
		  // adding game critics to queue
		  workerQueue.addToBack(gameCritic1);
		  workerQueue.addToBack(gameCritic2);
		  workerQueue.addToBack(gameCritic3);
		  workerQueue.addToBack(gameCritic4);
		  workerQueue.addToBack(gameCritic5);
		  
		  // finally we return the worker queue
		  return workerQueue;	 
	  }
	 
	
}
