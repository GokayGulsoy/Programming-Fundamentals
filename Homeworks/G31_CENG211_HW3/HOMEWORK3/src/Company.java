import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Company {

	 public void simulateRatingCompany() {
		 
		 FileIO reader = new FileIO();
		 
		 // creating queue of workers 
		 WorkerQueue workerQueue = reader.formWorkerQueue();
         
		 // creating ArrayLists that will hold the rated movies and games 
		 ArrayList<Movie> movieList = new ArrayList<Movie>();
		 ArrayList<Game> gameList = new ArrayList<Game>();
		 		 
		 // creating ArrayList that will hold the popped movies from stack
		 // so that they can be added to movieStack again for futher evalutation
		 ArrayList<Movie> poppedMovies = new ArrayList<Movie>();
		 
		 
		 // creating ArrayList that will hold the popped games from stack
		 // so that they can be added to gameStack again for futher evalutation 	 
		 ArrayList<Game> poppedGames = new ArrayList<Game>();
		 
		 // creating an instance of movieStackADT
		 MovieStackADT movieStack = reader.readMovies();
		 
		 // creating an instance of gameStackADT
		 GameStackADT gameStack = reader.readGames();
		 	 	 
		 // day varibale is used to keep track of days
		 int day = 1;
		 	 
		 while (day <= 5) {
			 // dayLenght variable isused to keep track of 1 day length
			 double dayLength = 0;
			 System.out.println(day+".day");
			 
			 while (dayLength <= 24) { // as one day is 24 hour
				 
				 
				 // adding popped movies to movieStack again
				 addPoppedMoviesToStack(poppedMovies,movieStack);
				 addPoppedGamesToStack(poppedGames,gameStack);
				 
				 // refreshing poppedGames and poppedMovies ArrayList at each iteration
				 poppedMovies.removeAll(poppedMovies);
				 poppedGames.removeAll(poppedGames);
				 
				// printStack(movieStack);
				 Worker worker = workerQueue.getNext();
				 
				 
				 if (worker instanceof MovieCritic) {
					 
					 workerQueue.removeFront();
					      
					 MovieCritic movCritic = (MovieCritic) worker;
					 
					 Movie movie = movieStack.pop();
					 
					 // setting flag value for while loop
					 boolean flag = true;
					 
					 while (flag) {
						 
						 
						 if (movie.getArrivalDay() == day) {
							 
							 if (dayLength > 24) {  // this is not a require if block 
								day++; 
								flag = false;
								// as new day starts amountWatched is refreshed
								resetWorkingHoursAndMoviesWatched(workerQueue);
								workerQueue.addToBack(movCritic);
								break;
								
							 }
							 
						      else if  (movCritic.getAmountWatched() == 0 ) {
								   double rating = movCritic.rateMovie(movie);
								   movie.setRatingValue(rating);
								   dayLength += movie.getDuration() / (double)60;
								   movieList.add(movie);
								   movCritic.setAmountWatched(1);
								   workerQueue.addToBack(movCritic);
								   System.out.println("\t" + movCritic.getOrder() + "moviecritic evaluated "+"(#"+movie.getName()+")");
								   
								   if (dayLength > 24) {
									   resetWorkingHoursAndMoviesWatched(workerQueue);
									   day++;
								   }
								   
								   flag = false;
							 }
							 
							 
						      else {
									 
									 // previous critic was not relevant for evaluation looking for a new one
									 workerQueue.addToBack(movCritic);
									 break;
								 }					 
						 }
						 
						 else {
							 
							 // case in which the arrival day is not the current day
														
							 try {
								 
								 poppedMovies.add(movie);
								 
								 boolean notValid = true;
								 
                                 while (notValid) {
                                	 
                                	 movie = movieStack.pop();
    								 
    								 if (movie.getArrivalDay() != day) {
    								     poppedMovies.add(movie);
    								    
    								 } 
    								 
    								 else {
    									 
    									 notValid = false;
    								 }
                                	                           	 
                                 }
								 
							 }
							 
							 catch (NoSuchElementException e) {				                     
									 
									 flag = false;
								 
						         // when movieStack run out of movies 
							 }
							 
							 
				 
						 }
					  
					 }  // end of the while loop with flag
					  
				 } // end of the if statement with getclass
				 
				 
				 else if (worker instanceof GameCritic) { // case in which worker is game critic
	
					 workerQueue.removeFront();
					 
					 Game game = gameStack.pop();
					 
					 GameCritic gameCritic = (GameCritic) worker;
					 
					 boolean flag2 = true;
					 
					 					 
					while (flag2) { 
												 
						 if (game.getArrivalDay() == day)  {					
                              
							 if (game instanceof IndefiniteGame) {
								 
								 IndefiniteGame indefiniteGame = (IndefiniteGame) game;
								 boolean isChecked = game.getChecker().equals(gameCritic.getOrder()) || game.getChecker().equals("");
								 
								 
								 if (8 - gameCritic.getWorkTime() >= 4 && isChecked) {
									 
									 // setting rating of the game
									 double rating = gameCritic.rateIndefiniteGame(indefiniteGame);
									 
									 indefiniteGame.setRatingValue(rating);
									 
									 dayLength += 4;
									 
									 
									 int currentWorkTime = gameCritic.getWorkTime();
									
									 // adding game to ArrayList 
									 gameList.add(indefiniteGame);
                                     gameCritic.setWorkTime(4 + currentWorkTime);
									 
									 workerQueue.addToBack(gameCritic);
									 
									 // printing out the game critic with evaluated game name
									 System.out.println("\t" + gameCritic.getOrder() + "gamecritic evaluated " + "(#" + indefiniteGame.getName() + ")");
									 
									 if (dayLength > 24) {
										 resetWorkingHoursAndMoviesWatched(workerQueue);
										 day++;
										 
									 }
									 
									 flag2 = false;	
									
									 	 
								 }
								 
								 // case in which the indefinite game was played previously, that was not completed 
								 // but now it can be completed and rated
								 else if (indefiniteGame.getRemainingHours() != 4 && isChecked && 8-  gameCritic.getWorkTime() >= indefiniteGame.getRemainingHours()) {
									 
								            double rating = gameCritic.rateIndefiniteGame(indefiniteGame);
								            
								            indefiniteGame.setRatingValue(rating);
								            
								            dayLength += indefiniteGame.getRemainingHours();
									 
									        int currentWorkTime = gameCritic.getWorkTime();
									        
									        gameCritic.setWorkTime(currentWorkTime + indefiniteGame.getRemainingHours());
									         
									        System.out.println("\t" + gameCritic.getOrder() + "gamecritic evaluated " + "(#" + indefiniteGame.getName() + ")");
									        
									        if (day > 24) {
									        	resetWorkingHoursAndMoviesWatched(workerQueue);
									        	day++;
									        }
									 	    
									        flag2 = false;	
									        
								 }
								 
								 							 
								 else {
								       // case in which workTime of gameCritic is not sufficient for 4 hours
									   // gameCritic plays the game for remainig time from workTime
									if (isChecked && indefiniteGame.getRemainingHours() == 4) {
										
								   	    int playedHour = 4 - (8 - gameCritic.getWorkTime());
									    
									   
									    System.out.println("\t" + gameCritic.getOrder() + "gamecritic works on" + "(#" + indefiniteGame.getName() + ")");
									    
									    dayLength += playedHour;
 									   
									    gameCritic.setWorkTime(8);
 									   
									    indefiniteGame.setRemainingHours(4-playedHour);
 									    
 									    workerQueue.addToBack(gameCritic);
 									   
 									    indefiniteGame.setChecker(gameCritic.getOrder());
 									    
 									    // as the game's evaluation has not yet finished
 									    gameStack.push(indefiniteGame);
 									   						    									    
 									    if (dayLength > 24) {
 									    	resetWorkingHoursAndMoviesWatched(workerQueue);
 											 day++;
 										}
 									    
 									   flag2 = false;	
 									    
									}    
 									   
								 }
												 	 
							 }
							 
							 else if (game instanceof StoryGame) {
								 								 
								  StoryGame storyGame = (StoryGame) game;
								  
								  boolean isChecked = game.getChecker().equals(gameCritic.getOrder()) || game.getChecker().equals("");
								  
								  if (storyGame.getStoryDuration() <= 8 && 8 - gameCritic.getWorkTime() > storyGame.getStoryDuration() && isChecked) {
									  
									    double rating = gameCritic.rateStoryGame(storyGame);
									    storyGame.setRatingValue(rating);
									    
									    dayLength += storyGame.getStoryDuration();
									    
									    gameList.add(storyGame);
									    
									    int currentWorkTime = gameCritic.getWorkTime();
									    gameCritic.setWorkTime(currentWorkTime + storyGame.getStoryDuration());
									  
									    workerQueue.addToBack(gameCritic);
									    
									    System.out.println("\t" + gameCritic.getOrder() + "gamecritic evaluated" + "(#" + storyGame.getName() + ")");
									    
									    if (dayLength > 24) {
									    	 resetWorkingHoursAndMoviesWatched(workerQueue);
											 day++;
										 }
									    		
									    
								  }
								  
								  
								  
							  else { // if storyGame cannot be finished 
									  
									  
									 if (isChecked) {

									   int currentStoryDuration = storyGame.getStoryDuration();
									   storyGame.setStoryDuration(currentStoryDuration - (8-gameCritic.getWorkTime()));
									   								
									   dayLength += 8 - gameCritic.getWorkTime();
									  
									   System.out.println("\t" + gameCritic.getOrder() + "gamecritic works on " + "(#" + storyGame.getName() + ")");
									  
									   gameCritic.setWorkTime(8); // game critic completed his/her working  time ( 8 hours in a day)
									   workerQueue.addToBack(gameCritic);
									  
									   storyGame.setChecker(gameCritic.getOrder());
									   
									   gameStack.push(storyGame);
									   
									   if (dayLength > 24) {
										     resetWorkingHoursAndMoviesWatched(workerQueue);
											 day++;
										 }
									    					 
				
									   flag2 = false;
									}  
									   
								  }
								  								  		 								 
							 }  // end of the else if statement game instanceof StoryGame
							 
													 
							 else if (game instanceof CasualGame) {
								 
								 CasualGame casualGame = (CasualGame) game;
								 
								 boolean isChecked = game.getChecker().equals(gameCritic.getOrder()) || game.getChecker().equals("");
								 
								// case in which game critic can complete whole casual game 
								if (gameCritic.getCasualMatches() == 0 && (8-gameCritic.getWorkTime()) > casualGame.getMatchDuration()*3 && isChecked) {
								        
									   double rating = gameCritic.rateCasualGame(casualGame); 
								       casualGame.setRatingValue(rating);
								        
								        dayLength += casualGame.getMatchDuration()*3;
									    gameList.add(casualGame);
									    
									    int currentWorkTime = gameCritic.getWorkTime();
									    gameCritic.setWorkTime(currentWorkTime + casualGame.getMatchDuration()*3);
									    
									    workerQueue.addToBack(gameCritic);
									    
									    // assigning another game
									    System.out.println("\t" + gameCritic.getOrder() + "gameCritic evaluated" + "(#" + casualGame.getName() + ")");
									    
									    if (dayLength > 24) {
									    	 resetWorkingHoursAndMoviesWatched(workerQueue);
											 day++;
										 }
									    
									    flag2 = false; 
									    
								}
								
								else {  // case in which casualGame  cannot be completed 
									   //  maximum work time for game critic is exceeded (8 hours) or previosuly uncompleted game is completed
									
								  if (gameCritic.getCasualMatches() == -1 && 8 - gameCritic.getWorkTime() >= casualGame.getMatchDuration()) {
									
									  double rating = gameCritic.rateCasualGame(casualGame);
									
									  casualGame.setRatingValue(rating);
									
									  dayLength += casualGame.getMatchDuration();
									
									  gameList.add(casualGame);
									  
									  int currentWorkingTime = gameCritic.getWorkTime();
									
									  gameCritic.setWorkTime(currentWorkingTime + casualGame.getMatchDuration());
									
									  workerQueue.addToBack(gameCritic);
									
									  System.out.println("\t" + gameCritic.getOrder() + "gamecritic evaluated" + "(#" + casualGame.getName() +")");
									
									
									  if (day  > 24) {
										  resetWorkingHoursAndMoviesWatched(workerQueue);
										  day++;
									  }
									
									  flag2 = false;
									  
									
								  }
								
								  else if (8 - gameCritic.getWorkTime() < casualGame.getMatchDuration()*3 && isChecked)  {
										
										   // case in which evaluation time for a given casual game is not sufficient
										   int playedHour = 8 - gameCritic.getWorkTime();
										   
										   int currentMatchDuration = casualGame.getMatchDuration()*3;
										 
										   // setting remaining time for casual game
										   casualGame.setMatchDuration(currentMatchDuration - playedHour);
										 
										   gameCritic.setCasualMatches(-1);
										
										   dayLength += playedHour;
										   
										   casualGame.setChecker(gameCritic.getOrder());
										   
										   gameStack.push(casualGame);
										 
										   gameCritic.setWorkTime(gameCritic.getWorkTime() + playedHour);
										   workerQueue.addToBack(gameCritic);
										    		 
										 
										   if (dayLength > 24) {
											   resetWorkingHoursAndMoviesWatched(workerQueue);
											   day++;
										   }
										 
										   flag2 = false;
										   	
										  
									  } 
																			
								 }
								
										 
							 } // end of the else if statement game instanceof Casual game
							 
			 
						 } // end of the initial if statement that starts with game.getArrivalDay
			
					
						 else {
						       
						    	try {
						    							    		
						            poppedGames.add(game);  
						    							    		
						            boolean notValid = true;
						            while (notValid) {
						            	
						            	game = gameStack.pop();
						           
															            	
						            	if (game.getArrivalDay() != day) { 
							    		   poppedGames.add(game);
						                   
						            	}
						            	
						            	else {
						            		
						            		if (game.getChecker().equals(gameCritic.getOrder()) || game.getChecker().equals("")) {
						            			
						            			notValid = false;
						        
						            		}
						            		
						            		else {
						            		
						            		 poppedGames.add(game);
						            		
						            		}
						            		 
						            	}
						            	
						            	
						            	
						            }
						            
						    		
						    	}
						    	
						    	catch (NoSuchElementException e) {  
						    		   return;
						    							    		    												 
						    		
						    		 // case in which gameStack is ran out off games
						    	}
						    	
						    	
						    	
						    }
						     								 	 				
					    }
						 	
					 }
					  			 
				 }
				 	 			 
		    }	 		 
	    }
	 
	 
	 // helper method that adds movies to stack that has not been evaluated yet. 	 
	 private void addPoppedMoviesToStack(ArrayList<Movie> movieList,MovieStackADT movieStack) {
		 if (movieList.size() != 0) {
		   for (int i = movieList.size()-1; i >= 0; i--) {
			   Movie searchedMovie = movieList.get(i);
			   movieStack.push(searchedMovie);
			   
		   }
		 
	     }
	 }
	 
	 
	 // helper method that adds games to Stack that has not been evaluated yet.
	 private void addPoppedGamesToStack(ArrayList<Game> gameList,GameStackADT gameStack) {
	   if (gameList.size() != 0) {	   
		 for (int i = gameList.size()-1; i >= 0;i--) {
			 Game searchedGame = gameList.get(i);
			 gameStack.push(searchedGame);
			 
		     }		 
	   }	 
		 
	 }
	 
	 
	 // helper method that resets the watched movie amount (1 for movieCritics) and working time (8 hours for gameCritics)
	 // at the end of the day
	 private void resetWorkingHoursAndMoviesWatched(WorkerQueue workerQueue) {
		           
		 int count = 0;
		 
		 while  (count < 8) {
			  
			Worker worker =  workerQueue.getNext();
			 
			workerQueue.removeFront();
			
			if (worker instanceof MovieCritic) {
				
				MovieCritic movCritic = (MovieCritic) worker;
				
				movCritic.setAmountWatched(0);
				
				workerQueue.addToBack(movCritic);
			}
			
			else {
				
				GameCritic gameCritic = (GameCritic) worker;
				
				gameCritic.setWorkTime(0);
				
				workerQueue.addToBack(gameCritic);
			}
			
			
			count++;
		 
		 }	 
	 }
	 
	 
	// end of the Company class	 
}
