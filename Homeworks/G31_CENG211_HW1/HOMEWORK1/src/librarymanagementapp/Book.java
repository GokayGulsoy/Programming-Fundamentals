package librarymanagementapp;

public class Book {

	// instance variables
	private String ID;
	private String title;
	private String author;
	private String publisher;
	private String edition;
	private String genre;
	private int quantity;

	// constructor for the Book class
	public Book(String ID, String title, String author, String publisher, String edition, String genre, int quantity) {
		// initalizing instance variables
		this.ID = ID;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.edition = edition;
		this.genre = genre;
		this.quantity = quantity;

	}

	// implementing the getters(accessors) for Book class
	public String getID() {
		return ID;

	}

	public String getTitle() {
		return title;

	}

	public String getAuthor() {
		return author;

	}

	public String getPublisher() {
		return publisher;

	}

	public String getEdition() {
		return edition;

	}

	public String getGenre() {
		return genre;

	}

	public int getQuantity() {
		return quantity;

	}

	// implementing setters(mutators) for Book class
	public void setID(String ID) {
		this.ID = ID;

	}

	public void setTitle(String title) {
		this.title = title;

	}

	public void setAuthor(String author) {
		this.author = author;

	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;

	}

	public void setEdition(String edition) {
		this.edition = edition;

	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;

	}

}
