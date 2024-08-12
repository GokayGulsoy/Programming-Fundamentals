public class Immigrant extends Applicant {

	 // we do not need specific insance variables to this subclass	
	
	   
	  // derived class Immigrant's constructor 
	  public Immigrant() {
		  super();
		  	  
	  }

	 // copy constructor of Immigrant class 
	 public Immigrant(Immigrant person) {
		 super(person);
			
		}
	
	 // methods related to application results  
	 
	 @Override
	 public String getApplication() {
		 return ("Applicant ID: " + getID() + ", " + "Name: " + getName() + ", " + "Visa Type: " + "Immigrant" 
		           + ", " + "Status: " + "Accepted" + ", " + "Visa Duration: " + getVisaDuration());		                             
			
		}
		
		
	 // overloaded version of the getApplication method in case of rejection
	 public String getApplication(String rejectionReason) {
			return ("Applicant ID: " + getID() + ", " + "Name: " + getName() + ", " + "Visa Type: " + "Immigrant" 
		            + ", " + "Status: " + "Rejected" + ", " + "Reason: " + rejectionReason);		                             
			
		}
		
}
