import java.util.NoSuchElementException;

public class MovieStackADT {

		private class Node {
			
			// instance variables of Node inner class
			private Movie movie;
			private Node link;
			
			// no-argument constructor for Node inner class
			
			public Node() {
				
				movie = null;
				link = null; 
				
			}
			
			public Node(Movie newMovie,Node newLink) {
				
				movie = newMovie;
				link = newLink;
			}
			
		}
		
		// end of the Node inner class

		// head instance variable of stack class
		private Node head;
		
		// no-argument constructor
		public MovieStackADT() {
			
			head = null;
		}

		
		/**
		This method adds items to the stack 
		*/
		
		
		public void push(Movie movie) {
			
			head = new Node(movie,head);
		}
		
		
		/**
		 This method  returns the value popped from stack
		*/
		
		public Movie pop() {
			
			if (head == null) {
				
				throw new NoSuchElementException();
			}
			
			else {
				
				Movie returnedItem = head.movie;
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
		
		// End of the MovieStackADT class
	}
