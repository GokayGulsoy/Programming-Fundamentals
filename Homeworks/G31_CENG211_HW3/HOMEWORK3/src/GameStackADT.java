import java.util.NoSuchElementException;

public class GameStackADT {
     
	private class Node {
		
		// instance variables of Node inner class
		private Game game;
		private Node link;
		
		// no-argument constructor for Node inner class
		
		public Node() {
			
			game = null;
			link = null; 
			
		}
		
		public Node(Game newGame,Node newLink) {
			
			game = newGame;
			link = newLink;
		}
		
	}
	
	// end of the Node inner class

	// head instance variable of stack class
	private Node head;
	
	// no-argument constructor
	public GameStackADT() {
		
		head = null;
	}

	
	/**
	This method adds items to the stack 
	*/
	
	public void push(Game game) {
		
		head = new Node(game,head);
	}
	
	
	/**
	 This method  returns the value popped from stack
	*/
	
	public Game pop() {
		
		if (head == null) {
			
			throw new NoSuchElementException();
		}
		
		else {
			
			Game returnedItem = head.game;
			head = head.link;
			return returnedItem;
		}
		
	}
	
	
	/**
	   isEmpty method checks whether the stack is empty or not  
	*/
	
	 public boolean isEmpty() {
		 
		 return (head == null);
	 }
	
	// End of the stack class
	
}
