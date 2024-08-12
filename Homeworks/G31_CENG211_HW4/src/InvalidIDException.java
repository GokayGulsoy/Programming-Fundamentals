public class InvalidIDException extends Exception {

	 // no-constructor of InvalidException class
	 public InvalidIDException() {
		 
		 super("Invalid customer ID");
		 
	 }
 	 	 
	 // parametirized constructor of InvalidException class
	 public InvalidIDException(String exceptionMessage) {
		 
		  super(exceptionMessage);
	 }
	

	 
	 
	 
}