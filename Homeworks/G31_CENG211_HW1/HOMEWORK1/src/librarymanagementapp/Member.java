package librarymanagementapp;

public class Member {

	// instance variables of Member class
	private String ID;
	private String name;
	private String email;
	private Member[] array;

	// constructor for Member class
	public Member(String ID, String name, String email) {
		this.ID = ID;
		this.name = name;
		this.email = email;
	}

	// no argument-constructor
	public Member() {
		this.array = new Member[5];

	}

	// getters(accessors) for Member class
	public String getID() {
		return ID;

	}

	public String getName() {
		return name;

	}

	public String getEmail() {
		return email;

	}

	public Member[] getArray() {
		return array;

	}

	// setters(mutators) for member class

	public void setID(String ID) {
		this.ID = ID;

	}

	public void setName(String name) {
		this.name = name;

	}

	public void setEmail(String email) {
		this.email = email;

	}

}
