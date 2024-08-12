public class WorkerQueue {

	// Node inner class
	private class Node  {
		
		// instance variables for Node class
		private Worker worker;
		private Node link;
		
		// no-argument constructor for Node class
		public Node() {
			
			worker = null;
			link = null;
		}
		
		
		// full-argument constructor
		public Node(Worker newWorker,Node newLink) {
			
			worker = newWorker;
			link = newLink;
		}
		
		// end of inner class Node
		
	}
	
	
	// instance variables of Queue class
	private Node front;
	private Node back;
	
	// no-argument constructor for Queue class
	public WorkerQueue() {
		
		front = null;
		back = null;
	}
	
	
	/**
	 isEmpty method checks whether the queue is empty or not 
	*/
	public boolean isEmpty() {
		
		return (front == null);
	}
	
	
	/**
	clear method empties the queue 
	*/
	
	public void clear() {
		
		front = null;
		back = null;
	}
	
	
	/**
	  Returns the string in the front of the queue
	  returns nullif queue is empty 
	*/
	
	public Worker getNext() {
		
		if (front == null) {
			
			return null;
		}
		
		
		else {
			
			return front.worker;
		}
		
		
		
	}
	
	/**
	   Removes the String from the front of the the queue
	   ,returns false if queue is empty 
	*/
	
	public boolean removeFront() {
		
		if (front != null) {
			
			front = front.link;
			return true;
		}
		
		else {
			return false;
		}
		
	}
	
	/**
	   addToBack method adds item to the back of the queue 
	*/
	
	public void addToBack(Worker worker) {
		
		Node newNode = new Node(worker,null);
		
		if (front == null) {
			
			back = newNode;
			front = back;
		}
		
		else {
			
			back.link = newNode;
			back = back.link;
		}	


	}
	
	// end of the Queue class
	
}
