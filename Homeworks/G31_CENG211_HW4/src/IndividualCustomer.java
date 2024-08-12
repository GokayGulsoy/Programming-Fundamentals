public class IndividualCustomer<T> extends Customer {

	  // instance variables 
	  private int numberOfDays;
	  private T ID;
	
	
      // no-argument constructor
	  public IndividualCustomer() {
		  
		  super();
		  numberOfDays = 0;
	  }
	  
	  // getters (accessors)
	  
	  public int getNumberOfDays() {
		  
		  return numberOfDays;
	  }
	  
	  public T getID() {
		  
		  return ID;
	  }
	  
	  // setters (mutators)
	  
	  public void setNumberOfDays(int numberOfDays) {
		  
		  this.numberOfDays = numberOfDays;
	  }
	
	  public void setID(T ID) {
		  
		  this.ID = ID;
	  }
	  
	  
	  
	  
	  
	  
	
}
