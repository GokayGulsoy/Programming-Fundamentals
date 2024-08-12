import java.util.ArrayList;

public interface IRentable {
       
	   /**
	     simulation method that is called in main method to
	     simulate renting company
	    */
	    public void simulateRentingCompany();
	    
	    /**
	      method that is used to generate 7 digit random 
	      rental code for rach rental
	     @return ArrayList<Customer>
	     */
	
	    public ArrayList<Customer> generateRentalCode();
	   
	    /**
	       method calculates total Rental price 
	       for each rental
	      @return
	     */
	    
	    public ArrayList<Customer> calculatePriceOfRentals();
	    
	    /**
	       method that calculates modelYearRatio 
	       of the given car model
	      @param carModelYear
	      @return double modelYearRatio
	     */
	    
	    public double determineModelYearRatio(int carModelYear);
	     
	    /**
	      this method calculates daily price of rental
	      for a given customer
	     * @param customer
	     * @return double dailyPrice
	     */
	
	    public double calculateDailyPrice(Customer customer);
	    
	    /**
	     this method calculates the amount of
	     discount for a given Commercial customer
	     * @param customer
	     * @return double dicount 
	     */
	    
	    public double determineDiscount(CommercialCustomer customer);
	    
	    /**
	     this method prints out new commercial customer types 
         if company adds later
	     * @param list
	     */
	    
	    public void printOtherCommercialCustomers(ArrayList<Customer> list);
	    
	    /**
	     this method searches for an specific customer in an ArrayList
	     returns true if it is found or ArrayList is empty, and returns 
	     false if it is already found in an ArrayList
	     * @param customerList
	     * @param customer
	     * @return boolean 
 	     */
	    	    
	    public boolean linearSearch(ArrayList<CommercialCustomer> customerList,CommercialCustomer customer);
	    
	    /**
	     this method adds new commercial customer to company with the 
	     taken infomation from user
	     * @return CommercialCustomer
	     */
	    
	    public CommercialCustomer addNewCommercialCustomer(); 
	    
}
