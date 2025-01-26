package librarymanagementapp;

public class Library {

	// class type array for holding the book objects
	private Book[] book;

	// constructor for the Library class
	public Library() {
		book = new Book[43];

	}

	// getter(accessor) for Book array
	public Book[] getArray() {
		return book;

	}

}
