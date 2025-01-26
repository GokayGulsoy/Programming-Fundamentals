package librarymanagementapp;

public class Issue {

	// instance variables
	private String ID;
	private String member;
	private String book;
	private String issue_date;
	private String return_date;

	// constructor for Issue class
	public Issue(String ID, String member, String book, String issue_date, String return_date) {
		this.ID = ID;
		this.member = member;
		this.book = book;
		this.issue_date = issue_date;
		this.return_date = return_date;

	}

	// implementing getters(accessors) for Issue class

	public String getID() {
		return ID;

	}

	public String getMember() {
		return member;

	}

	public String getBook() {
		return book;

	}

	public String getIssuedate() {
		return issue_date;

	}

	public String getReturndate() {
		return return_date;

	}

	// implementing setters(mutators) for Issue class

	public void setID(String ID) {
		this.ID = ID;

	}

	public void setMember(String member) {
		this.member = member;

	}

	public void setIssuedate(String issue_date) {
		this.issue_date = issue_date;

	}

	public void setReturndate(String return_date) {
		this.return_date = return_date;

	}

}
