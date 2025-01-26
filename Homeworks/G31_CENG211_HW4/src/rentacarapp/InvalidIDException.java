package rentacarapp;

public class InvalidIDException extends Exception {

	private static final long serialVersionUID = 5879846778839991387L;

	// no-constructor of InvalidException class
	public InvalidIDException() {

		super("Invalid customer ID");

	}

	// parametirized constructor of InvalidException class
	public InvalidIDException(String exceptionMessage) {

		super(exceptionMessage);
	}

}