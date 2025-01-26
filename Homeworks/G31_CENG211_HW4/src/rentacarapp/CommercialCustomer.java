package rentacarapp;

public class CommercialCustomer extends Customer {

	// instance variables
	private int numberOfMonths;
	private String customerType;
	private String ID;

	// no-argument constructor
	public CommercialCustomer() {

		super();
		numberOfMonths = 0;
		customerType = "";
	}

	// getters (accessors)

	public int getNumberOfMonths() {

		return numberOfMonths;
	}

	public String getCustomerType() {

		return customerType;
	}

	public String getID() {

		return ID;
	}

	// setters (mutators)

	public void setNumberOfMonths(int numberOfMonths) {

		this.numberOfMonths = numberOfMonths;
	}

	public void setCustomerType(String customerType) {

		this.customerType = customerType;
	}

	public void setID(String ID) {

		this.ID = ID;
	}

}
