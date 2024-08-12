public class Passport {
       
	// instance variables of the  Passport class
	private String passportNumber;
	private String expirationDate;
		
	// constructor for passport class
	public Passport(String passportNumber,String expirationDate) {
		
		this.passportNumber = passportNumber;
		this.expirationDate = expirationDate;
		
	}
	
	// copy constructor for Passport class
	public Passport(Passport otherPassport) {
		
		if (otherPassport == null) {
			System.out.println("Fatal error object is null");
			System.exit(0);
		}
		
		else {
			
			passportNumber = otherPassport.passportNumber;
			expirationDate = otherPassport.expirationDate;
					
		}
		
		
	}
	
	
	// getters (accessors) for Passport class
	
	public String getPassportNumber() {
		return passportNumber;
		
	}
	
	public String getExpirationDate() {
		return expirationDate;
		
	}
	
	// setters (mutators) for Passport class
	
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
		
	}
	
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
		
	}
	
}
