package visacontrolapp;

public class FinancialStatus {

	// instance variables of the FinancialStatus class
	private String income;
	private String savings;

	// constructor for FinancialStatus class
	public FinancialStatus(String income, String savings) {

		this.income = income;
		this.savings = savings;

	}

	// Copy constructor for FinancialStatus class
	public FinancialStatus(FinancialStatus otherFinancialStatus) {

		if (otherFinancialStatus == null) {
			System.out.println("Fatal error object is null");
			System.exit(0);

		}

		else {

			income = otherFinancialStatus.income;
			savings = otherFinancialStatus.savings;

		}

	}

	// getters (accessors) for FinancialStatus class

	public String getIncome() {
		return income;

	}

	public String getSavings() {
		return savings;

	}

	// setters (mutators) for FinancialStatus class

	public void setIncome(String income) {
		this.income = income;

	}

	public void setSavings(String savings) {
		this.savings = savings;

	}

}
