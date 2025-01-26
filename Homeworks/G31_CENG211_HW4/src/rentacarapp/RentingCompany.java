package rentacarapp;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RentingCompany implements IRentable {

	public void simulateRentingCompany() {

		ArrayList<Customer> customerList = generateRentalCode();

		// calculating total cars rented
		int totalCarsRented = 0;

		for (Customer customer : customerList) {

			totalCarsRented++;
		}

		// at the end of the for loop we will get total cars rented

		int totalCommercialRentals = 0;
		int totalIndividualRentals = 0;

		for (Customer customer : customerList) {

			if (customer instanceof CommercialCustomer) {

				totalCommercialRentals++;
			}

			else { // if customer is IndividualCustomer

				totalIndividualRentals++;
			}

		}

		// at the end of the for loop we will get the total commercial and individual
		// rentals

		// calculating total number of commerical rentals-month and total individual
		// rentals-day
		int totalCommercialRentalsMonth = 0;
		int totalIndividualRentalsDay = 0;

		for (Customer customer : customerList) {

			if (customer instanceof CommercialCustomer) {

				CommercialCustomer commercialCustomer = (CommercialCustomer) customer;
				totalCommercialRentalsMonth += commercialCustomer.getNumberOfMonths();

			}

			else {

				IndividualCustomer individualCustomer = (IndividualCustomer) customer;
				totalIndividualRentalsDay += individualCustomer.getNumberOfDays();

			}

			/*
			 * at the end of the for loop we will have found the totalCommercialRentalsMonth
			 * and totalIndividualRentalsDay
			 */

		}

		int totalNonMemberIndividualRentals = 0;
		int totalMemberIndividualRentals = 0;

		for (Customer customer : customerList) {

			if (customer instanceof IndividualCustomer) {

				IndividualCustomer individualCustomer = (IndividualCustomer) customer;

				// checking whether individualCustomer is member or not
				if (individualCustomer.getIsMember().equals("No")) {

					totalNonMemberIndividualRentals++;
				}

				else { // case in which customer is a member

					totalMemberIndividualRentals++;
				}
			}

			/*
			 * at the end of the for loop we will have calculated
			 * totalNonMemberIndividualRentals and totalMemberIndividualRentals
			 */

		}

		// calculating total silver commercial rentals
		int totalSilverCommercialRentals = 0;
		int totalGoldCommercialRentals = 0;
		int totalPlatinumCommercialRentals = 0;

		for (Customer customer : customerList) {

			if (customer instanceof CommercialCustomer) {

				CommercialCustomer commercialCustomer = (CommercialCustomer) customer;

				String ID = commercialCustomer.getID();
				char customerType = ID.charAt(0);

				if (customerType == 'S') {

					totalSilverCommercialRentals++;
				}

				else if (customerType == 'G') {

					totalGoldCommercialRentals++;
				}

				else if (customerType == 'P') {

					totalPlatinumCommercialRentals++;
				}

			}

		}

		System.out.println(); // advancing to new line
		// giving an output first part
		System.out.println("Welcome!");
		System.out.println("Total number of cars rented: " + totalCarsRented);
		System.out.println("Total number of commercial rentals: " + totalCommercialRentals);
		System.out.println("Total number of commercial rental-moths: " + totalCommercialRentalsMonth);
		System.out.println("Total number of indvidual rentals: " + totalIndividualRentals);
		System.out.println("Total number of individual rental-day: " + totalIndividualRentalsDay);
		System.out.println(
				"Total number of rentals of individual non-member customers: " + totalNonMemberIndividualRentals);
		System.out.println("Total number of rentals of individual member customers: " + totalMemberIndividualRentals);
		System.out.println("Total number of rentals of silver commerical customers: " + totalSilverCommercialRentals);
		System.out.println("Total number of rentals of gold commercial customers: " + totalGoldCommercialRentals);
		System.out
				.println("Total number of rentals of platinum commercial customers: " + totalPlatinumCommercialRentals);

		// printing out newly added commercial customers,if there exist some
		printOtherCommercialCustomers(customerList);

		System.out.println();
		// giving an output second part
		System.out.println("Individual Rentals");
		System.out.println();
		System.out.println("No\t" + "Rental Code\t" + "Customer ID\t" + "IsMember\t" + "Number of Days\t"
				+ "Car Model\t\t" + "Model Year\t" + "Rental Price");

		// Usig for-each loop to print out information related to individual rentals
		int no = 1;

		for (Customer customer : customerList) {

			if (customer instanceof IndividualCustomer) {

				@SuppressWarnings("rawtypes")
				IndividualCustomer individualCustomer = (IndividualCustomer) customer;
				/*
				 * we are sure that given customer is individual customer and so we can make
				 * type cast safely
				 */

				System.out.printf("%d\t", no);
				System.out.printf("%-7s\t\t", individualCustomer.getRentalCode());
				System.out.print(individualCustomer.getID() + "\t");
				System.out.printf("%-5s\t\t", individualCustomer.getIsMember());
				System.out.printf("%-5s\t\t", individualCustomer.getNumberOfDays());
				System.out.printf("%-16s\t", individualCustomer.getCarModel());
				System.out.printf("%-5s\t\t", individualCustomer.getCarModelYear());
				System.out.printf("%5.1f", individualCustomer.getRentalPrice());

				no++;
				System.out.println(); // advancing a new line

			}
		}

		System.out.println();
		// setting no to 1 again
		no = 1;
		// printing out commercial rentals

		System.out.println("Commercial Rentals");
		System.out.println();
		System.out.println("No\t" + "Rental Code\t" + "Customer ID\t" + "Customer Type\t\t" + "IsMember\t"
				+ "Number of Months\t" + "Car Model\t\t" + "Model Year\t" + "Rental Price");

		for (Customer customer : customerList) {

			if (customer instanceof CommercialCustomer) {

				CommercialCustomer commercialCustomer = (CommercialCustomer) customer;
				/*
				 * we are sure that given customer is individual customer and so we can make
				 * type cast safely
				 */

				System.out.printf("%d\t", no);
				System.out.printf("%-7s\t\t", commercialCustomer.getRentalCode());
				System.out.print(commercialCustomer.getID() + "\t");
				System.out.printf("%-8s\t\t", commercialCustomer.getCustomerType());
				System.out.printf("%-5s\t\t", commercialCustomer.getIsMember());
				System.out.printf("%-5s\t\t\t", commercialCustomer.getNumberOfMonths());
				System.out.printf("%-20s\t", commercialCustomer.getCarModel());
				System.out.printf("%-5s\t\t", commercialCustomer.getCarModelYear());
				System.out.printf("%5.1f", commercialCustomer.getRentalPrice());

				no++;
				System.out.println(); // advancing a new line

			}
		}

		// continue from here with commercial customer output
	}

	public ArrayList<Customer> generateRentalCode() {

		ArrayList<Customer> customerList = calculatePriceOfRentals();

		// generating 7 digit random rental code
		Random randomCodeGenerator = new Random();

		for (Customer customer : customerList) {

			String randomCode = "";
			for (int i = 0; i < 7; i++) {

				int randomDigit = randomCodeGenerator.nextInt(10);
				randomCode += randomDigit;
			}

			// at the end of the for loop we get 7 digit random code
			long rentalCode = Long.parseLong(randomCode);

			customer.setRentalCode(rentalCode);
		}

		return customerList;
	}

	@SuppressWarnings("rawtypes")
	public ArrayList<Customer> calculatePriceOfRentals() {
		ArrayList<Customer> updatedList = new ArrayList<Customer>();

		FileIO fileReader = new FileIO();

		ArrayList<Customer> customerList = fileReader.readFile();

		Scanner keyboard = new Scanner(System.in);

		// company may add new commercial customer

		System.out.println("Do you want to add new commercial customer ?(yes/no)");

		String response = keyboard.nextLine();
		response = response.toLowerCase();

		int numberOfNewCustomers = 0;

		if (response.equals("yes")) {

			System.out.println("How many customers do you want to add ?");

			numberOfNewCustomers = keyboard.nextInt();

		}

		CommercialCustomer newCommercialCustomer;

		int count = 1;
		while (count <= numberOfNewCustomers && response.equals("yes")) {

			newCommercialCustomer = addNewCommercialCustomer();

			if (newCommercialCustomer != null) {

				customerList.add(newCommercialCustomer);
			}

			count++;
		}

		// calculating rental for each customer
		for (Customer customer : customerList) {

			if (customer instanceof IndividualCustomer) {

				String ID = "";
				ID += ((IndividualCustomer) customer).getID();

				if (ID.length() == 12) {

					@SuppressWarnings("unchecked")
					IndividualCustomer<String> individualCustomer = (IndividualCustomer<String>) customer;
					/*
					 * now we are sure that this downcasting is type safety
					 */

					double dailyPrice = calculateDailyPrice(individualCustomer);

					int numberOfDays = individualCustomer.getNumberOfDays();

					double rentalPrice = dailyPrice * numberOfDays;
					// determining whether the customer is member or not
					if (individualCustomer.getIsMember().equals("Yes")) {

						rentalPrice -= rentalPrice * 0.1;
					}

					individualCustomer.setRentalPrice(rentalPrice);

				}

				else { // if customer ID is integer and 11 digit

					@SuppressWarnings("unchecked")
					IndividualCustomer<Long> individualCustomer = (IndividualCustomer<Long>) customer;
					/*
					 * now we are sure that downcasting is type safety
					 */

					double dailyPrice = calculateDailyPrice(individualCustomer);

					int numberOfDays = individualCustomer.getNumberOfDays();

					double rentalPrice = dailyPrice * numberOfDays;
					// determining whether the customer is member or not
					if (individualCustomer.getIsMember().equals("Yes")) {

						rentalPrice -= rentalPrice * 0.1;
					}

					individualCustomer.setRentalPrice(rentalPrice);

				}

			}

			else { // if customer is CommercialCustomer

				CommercialCustomer commercialCustomer = (CommercialCustomer) customer;

				// calculating daily price
				double dailyPrice = calculateDailyPrice(commercialCustomer);

				double rentalPrice = 30 * dailyPrice * commercialCustomer.getNumberOfMonths();

				// determining the type of discount
				double discount = determineDiscount(commercialCustomer);

				rentalPrice -= rentalPrice * discount;

				commercialCustomer.setRentalPrice(rentalPrice);

			}

		}

		/*
		 * adding customer after calculating rentalPrice for each of them to updatedList
		 */
		updatedList.addAll(customerList);

		return updatedList;
	}

	public CommercialCustomer addNewCommercialCustomer() {

		Scanner keyboard = new Scanner(System.in);

		CommercialCustomer commercialCustomer = new CommercialCustomer();

		commercialCustomer.setType("Commercial");

		System.out.println("Enter customer ID for new commercial customer: ");
		String customerID = keyboard.nextLine();

		commercialCustomer.setID(customerID);

		if (customerID.length() != 8) {

			try {

				keyboard.close();
				throw new InvalidIDException("Commercial customer ID is not valid");
			}

			catch (InvalidIDException e) {

				System.out.println(e.getMessage());

				keyboard.close();
				return null; // returning null if the customer ID is not valid
			}
		}

		System.out.println("Enter customer type for new commercial customer: ");
		String customerType = keyboard.nextLine();

		commercialCustomer.setCustomerType(customerType);

		System.out.println("Enter car model for new commercial customer: ");
		String carModel = keyboard.nextLine();
		commercialCustomer.setCarModel(carModel);

		System.out.println("Enter car model year for new commercial customer: ");
		int carModelYear = keyboard.nextInt();

		commercialCustomer.setCarModelYear(carModelYear);

		System.out.println("Enter base price for new  commercial customer");
		double basePrice = keyboard.nextDouble();

		commercialCustomer.setBasePrice(basePrice);

		commercialCustomer.setIsMember("Yes");

		System.out.println("Enter number of months for new customer: ");

		int numberOfMonths = keyboard.nextInt();

		commercialCustomer.setNumberOfMonths(numberOfMonths);

		return commercialCustomer;

	}

	// method for printing out total rentals for newly added commercial customers
	public void printOtherCommercialCustomers(ArrayList<Customer> list) {

		ArrayList<CommercialCustomer> newCommercialCustomers = new ArrayList<CommercialCustomer>();

		for (Customer customer : list) {

			if (customer instanceof CommercialCustomer) {

				CommercialCustomer commercialCustomer = (CommercialCustomer) customer;

				char customerType = commercialCustomer.getID().charAt(0);

				if (customerType != 'S' && customerType != 'G' && customerType != 'P') {

					newCommercialCustomers.add(commercialCustomer);
				}
			}
		}

		ArrayList<CommercialCustomer> checkerList = new ArrayList<CommercialCustomer>();

		// then we need to calculate rental amount for each of these commercial
		// customers
		if (newCommercialCustomers.size() != 0) {

			for (int i = 0; i < newCommercialCustomers.size(); i++) {

				CommercialCustomer commercialCustomer = newCommercialCustomers.get(i);

				int total = 0;

				for (CommercialCustomer customer : newCommercialCustomers) {

					if (commercialCustomer.getCustomerType().equals(customer.getCustomerType())) {

						total++;
					}

				}

				// at the end of each inner for loop we will print out
				// rental amount for given commercial customer type

				if (!linearSearch(checkerList, newCommercialCustomers.get(i))) {

					System.out.println("Total number of rentals of " + newCommercialCustomers.get(i).getCustomerType()
							+ " commercial customers: " + total);
					checkerList.add(newCommercialCustomers.get(i));

				}

			}

		}

	}

	// helper method that is used to determine model year ratio
	public double determineModelYearRatio(int carModelYear) {

		if (2017 <= carModelYear && carModelYear <= 2019) {

			return 0.9;
		}

		else if (2020 <= carModelYear && carModelYear <= 2021) {

			return 0.95;
		}

		else { // if carModelYear is 2022

			return 1;
		}
	}

	public double calculateDailyPrice(Customer customer) {

		int carModelYear = customer.getCarModelYear();

		double modelYearRatio = determineModelYearRatio(carModelYear);

		double modelBasePrice = customer.getBasePrice();

		// calculating daily price
		double dailyPrice = modelBasePrice * modelYearRatio;

		return dailyPrice;
	}

	// helper method that is used to determine discount for Commercial Customer
	public double determineDiscount(CommercialCustomer customer) {

		String ID = customer.getID();
		char customerType = ID.charAt(0);

		if (customerType == 'S') {

			customer.setCustomerType("Silver");
			return 0.2;
		}

		else if (customerType == 'G') {

			customer.setCustomerType("Gold");
			return 0.25;
		}

		else if (customerType == 'P') {

			customer.setCustomerType("Platinum");
			return 0.3;
		}

		else {
			// discount rate for commercial customers
			// that are added to company later

			double discount = Math.random(); // randomly generating discount value
			System.out.println(discount);

			return discount;
		}

	}

	// helper method to search for an element in ArrayList
	public boolean linearSearch(ArrayList<CommercialCustomer> customerList, CommercialCustomer commercialCustomer) {

		// for the first case of looping as the
		// ArrayList is empty we are guaranteed the we can add new Customer to ArrayList
		if (customerList.size() == 0) {

			return false;
		}

		for (CommercialCustomer customer : customerList) {

			if (customer.getCustomerType().equals(commercialCustomer.getCustomerType())) {

				return true;
			}
		}

		// at the end of the for loop customer was not
		// found and we return false
		return false;
	}

}
