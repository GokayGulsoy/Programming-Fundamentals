package visacontrolapp;

public class Tourist extends Applicant {

	// we do not need specific insance variables to this subclass

	// derived Tourist class's constructor
	public Tourist() {
		super();

	}

	// copy constructor of Tourist class
	public Tourist(Tourist person) {
		super(person);

	}

	// methods related to application results

	@Override
	public String getApplication() {
		return ("Applicant ID: " + getID() + ", " + "Name: " + getName() + ", " + "Visa Type: " + "Toursit" + ", "
				+ "Status: " + "Accepted" + ", " + "Visa Duration: " + getVisaDuration());

	}

	// overloaded version of the getApplication method in case of rejection
	public String getApplication(String rejectionReason) {
		return ("Applicant ID: " + getID() + ", " + "Name: " + getName() + ", " + "Visa Type: " + "Toursit" + ", "
				+ "Status: " + "Rejected" + ", " + "Reason: " + rejectionReason);

	}

}
