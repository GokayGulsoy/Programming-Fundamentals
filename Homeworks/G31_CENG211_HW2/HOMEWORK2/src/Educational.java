public class Educational extends Applicant {

	 // we do not need specific insance variables to this subclass	
	
	 
	 // derived class Educational's constructor
	 public Educational() {
		 super();
		 
		 
	 }
	
	 // copy constructor for Educational class
	 public Educational(Educational person) {
			super(person);
			
		}
	 
	// methods related to application results 
	 
	@Override
	public String getApplication() {
		return ("Applicant ID: " + getID() + ", " + "Name: " + getName() + ", " + "Visa Type: " + "Educational" 
		          + ", " + "Status: " + "Accepted" + ", " + "Visa Duration: " + getVisaDuration());		                             
			
		}
		
		
	// overloaded version of the getApplication method in case of rejection
	public String getApplication(String rejectionReason) {
		return ("Applicant ID: " + getID() + ", " + "Name: " + getName() + ", " + "Visa Type: " + "Educational" 
		         + ", " + "Status: " + "Rejected" + ", " + "Reason: " + rejectionReason);		                             
			
	}
		
	

	
}
