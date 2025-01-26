package rentacarapp;

public abstract class Customer {

	// instance variables of abstract Customer class
	private String type;
	private String carModel;
	private int carModelYear;
	private double basePrice;
	private long rentalCode;
	private String isMember;
	private double rentalPrice;

	/*
	 * no-argument constructor initializes instance variables with default values
	 * they will be later set to their actual values by using setters
	 */
	public Customer() {

		type = "";
		carModel = "";
		carModelYear = 0;
		basePrice = 0;
		rentalCode = 0;
		rentalPrice = 0;
	}

	// getters (accessors) for customer abstract class
	public String getType() {

		return type;
	}

	public String getCarModel() {

		return carModel;
	}

	public int getCarModelYear() {

		return carModelYear;
	}

	public double getBasePrice() {

		return basePrice;
	}

	public long getRentalCode() {

		return rentalCode;
	}

	public String getIsMember() {

		return isMember;
	}

	public double getRentalPrice() {

		return rentalPrice;
	}

	// setters (mutators) for Customer abstract class

	public void setType(String type) {

		this.type = type;
	}

	public void setCarModel(String carModel) {

		this.carModel = carModel;

	}

	public void setCarModelYear(int carModelYear) {

		this.carModelYear = carModelYear;
	}

	public void setBasePrice(double basePrice) {

		this.basePrice = basePrice;
	}

	public void setRentalCode(long rentalCode) {

		this.rentalCode = rentalCode;
	}

	public void setIsMember(String isMember) {

		this.isMember = isMember;
	}

	public void setRentalPrice(double rentalPrice) {

		this.rentalPrice = rentalPrice;
	}

}
