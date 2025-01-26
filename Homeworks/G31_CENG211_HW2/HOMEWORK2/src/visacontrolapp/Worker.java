package visacontrolapp;

public class Worker extends Applicant {

	// we do not need specific insance variables to this subclass

	// derived class Worker's constructor
	public Worker() {
		super();

	}

	// copy constructor for Worker class
	public Worker(Worker person) {
		super(person);

	}

	// methods related to application results

	@Override
	public String getApplication() {
		return ("Applicant ID: " + getID() + ", " + "Name: " + getName() + ", " + "Visa Type: " + "Worker" + ", "
				+ "Status: " + "Accepted" + ", " + "Visa Duration: " + getVisaDuration());

	}

	// overloaded version of the getApplication method in case of rejection
	public String getApplication(String rejectionReason) {
		return ("Applicant ID: " + getID() + ", " + "Name: " + getName() + ", " + "Visa Type: " + "Worker" + ", "
				+ "Status: " + "Rejected" + ", " + "Reason: " + rejectionReason);

	}
}
