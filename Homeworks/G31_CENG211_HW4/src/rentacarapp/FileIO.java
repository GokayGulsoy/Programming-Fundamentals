package rentacarapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

@SuppressWarnings("unchecked")
public class FileIO {

	public ArrayList<Customer> readFile() {

		// creating an ArrayList of customers
		ArrayList<Customer> customerList = new ArrayList<Customer>();

		Scanner inputStream = null;

		try {

			inputStream = new Scanner(new FileInputStream("HW4_Rentals.csv"));
		}

		catch (FileNotFoundException e) {

			System.out.println("File not found,aborting the application");
			System.exit(0);
		}

		String line = null;

		// reading the csv file until we reach the end of the file.
		while (inputStream.hasNext()) {

			line = inputStream.nextLine();

			// Using StringTokenizer
			StringTokenizer tokenizer = new StringTokenizer(line, ",");
			String typeToken = tokenizer.nextToken();

			Customer customer = null;

			String token = tokenizer.nextToken();

			if (typeToken.equals("Individual")) {

				if (token.length() == 12) {

					// creating IndividualCustomer object
					customer = new IndividualCustomer<String>();
					IndividualCustomer<String> individualCustomer = (IndividualCustomer<String>) customer;
					/*
					 * we are sure that given customer is individual customer so we can safely apply
					 * downcasting
					 */
					individualCustomer.setID(token);
					individualCustomer.setIsMember("Yes");
					individualCustomer.setType(typeToken);

					token = tokenizer.nextToken();
					int intToken = Integer.parseInt(token);
					individualCustomer.setNumberOfDays(intToken);

					token = tokenizer.nextToken();
					individualCustomer.setCarModel(token);

					token = tokenizer.nextToken();
					int carModelYear = Integer.parseInt(token);
					individualCustomer.setCarModelYear(carModelYear);

					token = tokenizer.nextToken();
					double basePrice = Double.parseDouble(token);
					individualCustomer.setBasePrice(basePrice);

					// adding customer to ArrayList
					customerList.add(individualCustomer);

					// continue from here
				}

				else if (token.length() == 11) {

					customer = new IndividualCustomer<Long>();
					IndividualCustomer<Long> individualCustomer = (IndividualCustomer<Long>) customer;
					/*
					 * we are sure that given customer is individual customer so we can safely apply
					 * downcasting
					 */

					long longID = Long.parseLong(token);

					individualCustomer.setID(longID);
					individualCustomer.setIsMember("No");
					individualCustomer.setType(typeToken);

					token = tokenizer.nextToken();
					int intToken = Integer.parseInt(token);
					individualCustomer.setNumberOfDays(intToken);

					token = tokenizer.nextToken();
					individualCustomer.setCarModel(token);

					token = tokenizer.nextToken();
					int carModelYear = Integer.parseInt(token);
					individualCustomer.setCarModelYear(carModelYear);

					token = tokenizer.nextToken();
					double basePrice = Double.parseDouble(token);
					individualCustomer.setBasePrice(basePrice);

					// adding customer to ArrayList
					customerList.add(individualCustomer);
				}

				else { // customer ID is not appropriate

					try {

						throw new InvalidIDException("Individual customer ID is not valid");
					}

					catch (InvalidIDException e) {

						System.out.println(e.getMessage());
					}

				}

			}

			else { // if customer is CommercialCustomer

				customer = new CommercialCustomer();

				if (token.length() == 8) {

					CommercialCustomer commercialCustomer = (CommercialCustomer) customer;
					/*
					 * we are sure that given customer is commercial customer so we can safely apply
					 * downcasting
					 */

					commercialCustomer.setID(token);

					commercialCustomer.setIsMember("Yes");
					commercialCustomer.setType(typeToken);

					token = tokenizer.nextToken();
					int numberOfMonths = Integer.parseInt(token);
					commercialCustomer.setNumberOfMonths(numberOfMonths);

					token = tokenizer.nextToken();
					commercialCustomer.setCarModel(token);

					token = tokenizer.nextToken();
					int carModelYear = Integer.parseInt(token);
					commercialCustomer.setCarModelYear(carModelYear);

					token = tokenizer.nextToken();
					double basePrice = Double.parseDouble(token);
					commercialCustomer.setBasePrice(basePrice);

					// adding customer to ArrayList
					customerList.add(commercialCustomer);
				}

				else { // cutomer ID is not appropriate

					try {

						throw new InvalidIDException("Commercial customer ID is not valid");
					}

					catch (InvalidIDException e) {

						System.out.println(e.getMessage());

					}
				}

			}

		}

		// at the end of the while loop we will return the ArrayList of customers
		return customerList;

	}

}