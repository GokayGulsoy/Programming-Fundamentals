package visacontrolapp;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FileIO {

	private static ArrayList<String> IdReader() {

		// Creating an ArrayList for holding applicant ID's
		ArrayList<String> idList = new ArrayList<String>();

		Scanner inputStream = null;

		try {
			inputStream = new Scanner(new FileInputStream("HW2_ApplicantsInfo.csv"));

		}

		catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			System.exit(0);

		}

		String line = null;

		// checking for the end of the file
		while (inputStream.hasNextLine()) {

			line = inputStream.nextLine();

			// Using StringTokenizer to tokenize the string
			StringTokenizer tokenizer = new StringTokenizer(line, ",");

			tokenizer.nextToken();
			String id = tokenizer.nextToken();

			if (!(isContained(id, idList))) {
				idList.add(id);

			}

			else {
				// if id already exists in the list jump to next iteration
				continue;

			}

		}

		// returning the ArrayList of String objects
		return idList;

	}

	// this method is used to set the instance variables of each
	// applicant from mixed csv file
	private static ArrayList<Applicant> formApplicants() {

		// Forming the ArrayList that contains Applicant class
		// objects and (and derived class as they are also type of base class Applicant)

		ArrayList<String> idList = IdReader();
		ArrayList<Applicant> applicantList = new ArrayList<Applicant>();

		for (String id : idList) {

			Applicant anyApplicant = determinePrefix(id);

			// reading the csv file and finding matches with ids and setting each objects
			// instance variables

			Scanner inputStream = null;

			try {

				inputStream = new Scanner(new FileInputStream("HW2_ApplicantsInfo.csv"));

			}

			catch (FileNotFoundException e) {
				System.out.println("File not found");
				System.exit(0);

			}

			// reading the file with Scanner class
			String line = null;

			// cehcking fot the end of the file
			while (inputStream.hasNextLine()) {

				line = inputStream.nextLine();
				// creating an object of StringTokenizer class for tokenization
				StringTokenizer tokenizer = new StringTokenizer(line, ",");

				String prefix = tokenizer.nextToken();
				String ID = tokenizer.nextToken();

				if (id.equals(ID)) {
					// According to prefix we sill set the specific instance
					// variable of each Applicant object (and so any derived class object)

					switch (prefix) {
					case "A":
						String name = tokenizer.nextToken();
						anyApplicant.setName(name);
						anyApplicant.setID(ID);
						break;
					case "S":
						String passportNumber = tokenizer.nextToken();
						String expirationDate = tokenizer.nextToken();

						anyApplicant.setPassport(passportNumber, expirationDate);
						break;
					case "P":
						String resolution = tokenizer.nextToken();
						String position = tokenizer.nextToken();

						anyApplicant.setPhoto(resolution, position);
						break;

					case "F":
						String income = tokenizer.nextToken();
						String savings = tokenizer.nextToken();

						anyApplicant.setFinancialStatus(income, savings);
						break;
					}

				}

			}

			// at the end of the each while loop add the formed object to ArrayList
			applicantList.add(anyApplicant);

		}
		// retuning the ArrayList of Applicants
		return applicantList;

	}

	public static ArrayList<Applicant> setDocuments() {

		ArrayList<Applicant> applicantList = formApplicants();

		// setting the documents for each applicant
		for (Applicant person : applicantList) {

			String id = person.getID();

			// reading the csv file

			Scanner inputStream = null;

			try {
				inputStream = new Scanner(new FileInputStream("HW2_ApplicantsInfo.csv"));

			}

			catch (FileNotFoundException e) {
				System.out.println("File not found");
				System.exit(0);

			}

			String line = null;
			while (inputStream.hasNextLine()) {

				line = inputStream.nextLine();
				StringTokenizer tokenizer = new StringTokenizer(line, ",");

				String prefix = tokenizer.nextToken();
				String ID = tokenizer.nextToken();

				// checking the equality of ids
				if (id.equals(ID) && prefix.equals("D")) {
					if (tokenizer.countTokens() == 1) {
						String documentType = tokenizer.nextToken();
						person.setDocument(documentType);
						Document anyDocument = person.getDocument();
						person.addDocument(anyDocument);

					}

					else if (tokenizer.countTokens() == 2 && prefix.equals("D")) {
						String documentType = tokenizer.nextToken();
						String durationInMonths = tokenizer.nextToken();
						person.setDocument(documentType, durationInMonths);
						Document anyDocument = person.getDocument();
						person.addDocument(anyDocument);

					}

				}

			}

		}
		// returning the copy of ArrayList of Applicants after setting document
		// information
		return copyList(applicantList);
	}

	// helper method used in IdReader method
	private static boolean isContained(String id, ArrayList<String> list) {

		// looping through the ArrayList and searching for id
		for (String element : list) {
			if (id.equals(element)) {
				return true;

			}
		}

		return false;

	}

	// helper method used in the formApplicants method
	private static Applicant determinePrefix(String id) {
		String prefix = id.substring(0, 2);

		if (prefix.equals("11")) {
			return new Tourist();

		}

		else if (prefix.equals("23")) {
			return new Worker();

		}

		else if (prefix.equals("25")) {
			return new Educational();

		}

		else { // in the case prefix is 30
			return new Immigrant();

		}
	}

	// helper method used in copyList method for determining subclass
	// copy constructors
	private static Applicant determineCopyApplicant(String id, Applicant person) {
		String prefix = id.substring(0, 2);

		// making safe downcasting
		if (prefix.equals("11")) {
			Tourist applicant = (Tourist) person;
			return new Tourist(applicant);

		}

		else if (prefix.equals("23")) {
			Worker applicant = (Worker) person;
			return new Worker(applicant);

		}

		else if (prefix.equals("25")) {
			Educational applicant = (Educational) person;
			return new Educational(applicant);

		}

		else { // in the case prefix is 30
			Immigrant applicant = (Immigrant) person;
			return new Immigrant(applicant);

		}
	}

	// helper method that creates a copy of ArrayList
	private static ArrayList<Applicant> copyList(ArrayList<Applicant> list) {

		// creating a copy ArrayList
		ArrayList<Applicant> copyList = new ArrayList<Applicant>();

		for (Applicant person : list) {
			String id = person.getID();
			Applicant copyPerson = determineCopyApplicant(id, person);

			// after creating a copy of applicant object add it to new copy ArrayList
			copyList.add(copyPerson);

		}

		// At the end of the for loop we return the copyList
		return copyList;

	}

}
