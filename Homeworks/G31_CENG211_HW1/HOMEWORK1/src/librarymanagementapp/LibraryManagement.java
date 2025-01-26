package librarymanagementapp;

public class LibraryManagement {

	// Issue array which holds the issues for three libraries
	private Issue[][] issue;

	// constructor for LibraryManagement class
	public LibraryManagement() {
		issue = new Issue[3][];
		// each column has different size
		issue[0] = new Issue[30];
		issue[1] = new Issue[13];
		issue[2] = new Issue[17];

	}

	// getter(accessor) for issue array that holds Issue objects
	public Issue[][] getArray() {
		return issue;

	}

}
