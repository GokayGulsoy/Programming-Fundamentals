package visacontrolapp;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Date;

public class VisaChecker {

	// checker method for FinancialStatus
	private boolean checkFinancialStatus(Applicant person) {

		// boolean flag value to check the conditions
		boolean isValid = false;

		String checkIncome = person.getFinancialStatus().getIncome();
		String checkSavings = person.getFinancialStatus().getSavings();

		// firstly checking whether the appliant has an financial status report
		if (checkIncome.equals("0") && checkSavings.equals("0")) {
			person.setRejectionReason("Applicant does not have a financial status report");
			return isValid;
		}

		if (checkDocument(person)) {

			int k = halveIncomeAndSavings(person);
			// Using getClass method to determine the class type of person
			if ((person.getClass() + "").equals("class Tourist")) {

				String income = person.getFinancialStatus().getIncome();
				String savings = person.getFinancialStatus().getSavings();

				int numericIncome = Integer.parseInt(income);
				int numericSavings = Integer.parseInt(savings);

				if ((2000 / k <= numericIncome) && (numericIncome <= 3000 / k)) {
					if (numericSavings >= 12000 / k) {
						isValid = true;

					}
				}

				else if (3000 / k <= numericIncome && numericIncome <= 4000 / k) {
					if (numericSavings >= 6000 / k) {
						isValid = true;

					}
				}

				else if (numericIncome >= 4000 / k) {
					isValid = true;
				}

			}

			else if ((person.getClass() + "").equals("class Worker")) {

				String savings = person.getFinancialStatus().getSavings();
				int numericSavings = Integer.parseInt(savings);

				if (numericSavings >= 2000) {
					isValid = true;

				}
			}

			else if ((person.getClass() + "").equals("class Educational")) {

				String income = person.getFinancialStatus().getIncome();
				String savings = person.getFinancialStatus().getSavings();

				int numericIncome = Integer.parseInt(income);
				int numericSavings = Integer.parseInt(savings);

				if (1000 / k <= numericIncome && numericIncome <= 2000 / k) {
					if (numericSavings >= 6000 / k) {
						isValid = true;

					}
				}

				else if (2000 / k <= numericIncome && numericIncome <= 4000 / k) {
					if (numericSavings >= 3000 / k) {
						isValid = true;

					}
				}

				else if (numericIncome > 3000 / k) {
					isValid = true;

				}

			}

			else if ((person.getClass() + "").equals("class Immigrant")) {

				String savings = person.getFinancialStatus().getSavings();

				int numericSavings = Integer.parseInt(savings);
				// we need to check whether the immigrant has a green card or not
				boolean hasGreenCard = false;

				ArrayList<Document> documentList = person.getDocumentList();

				for (Document document : documentList) {
					if (document.getDocumentType().equals("GC")) {
						hasGreenCard = true;
					}
				}

				if (hasGreenCard) {
					if (numericSavings >= 4000 / k) {
						isValid = true;

					}
				}

				else {
					if (numericSavings >= 50000 / k) {
						isValid = true;

					}
				}
			}

			if (!(isValid)) {
				// case in which applicant doesn't have a stable financial status
				person.setRejectionReason("Applicant does not have a stable financial status");
			}

			return isValid;

		}

		else {

			return isValid;

		}
	}

	// cheker method for Photo
	private boolean checkPhoto(Applicant person) {
		Photo photo = person.getPhoto();

		String resolution = photo.getResolution();
		String position = photo.getPosition();

		// firstly we will check whether the person has a photo
		if (position.equals("0") && resolution.equals("0")) {
			// position and resolution being zero indicate that he/she
			// doesn't have a photo
			person.setRejectionReason("Applicant does not have a photo");
			return false;
		}

		StringTokenizer tokenizer = new StringTokenizer(resolution, "x");

		String resolutionFirstMultiplier = tokenizer.nextToken();
		String resolutionSecondMultiplier = tokenizer.nextToken();

		int multiplier1 = Integer.parseInt(resolutionFirstMultiplier);
		int multiplier2 = Integer.parseInt(resolutionSecondMultiplier);

		boolean isValid = false;
		// cehcking whether the photo is valid or not
		if ((resolutionFirstMultiplier.equals(resolutionSecondMultiplier))
				&& ((360000 <= (multiplier1 * multiplier2)) && (multiplier1 * multiplier2) <= 1440000)) {
			if ((position.equals("Neutral Face") || position.equals("Natural Smile"))) {
				isValid = true;

			}

			else {
				// case in which the position of photo is not valid
				person.setRejectionReason("Position in the photo is not valid");
			}

		}

		else {
			// case in which the resolution of photo is not valid
			person.setRejectionReason("Resolution of photo is not valid");
		}

		return isValid;

	}

	// method for checking whether the applicant has the required
	// document for application
	private boolean checkDocument(Applicant person) {

		boolean isValid = false;
		ArrayList<Document> documentList = person.getDocumentList();

		if ((person.getClass() + "").equals("class Tourist")) {
			// it is not necessary to have a document for tourist
			isValid = true;

		}

		else if ((person.getClass() + "").equals("class Worker")) {
			// it is necessary to have a letter of acceptance for Worker
			for (Document document : documentList) {
				if (document.getDocumentType().equals("LA")) {
					isValid = true;

				}
			}

			if (!(isValid)) {
				person.setRejectionReason("Applicant does not have a letter of acceptance");

			}

		}

		else if ((person.getClass() + "").equals("class Educational")) {
			for (Document document : documentList) {
				if (document.getDocumentType().equals("LA")) {
					isValid = true;

				}
			}

			// case in which applicant dose not have a letter of acceptance
			if (!(isValid)) {
				person.setRejectionReason("Applicant does not have a letter of acceptance");

			}

		}

		else if ((person.getClass() + "").equals("class Immigrant")) {
			// it is not necessary to have a letter of acceptance for Immigrant
			isValid = true;

		}

		return isValid;

	}

	private int halveIncomeAndSavings(Applicant person) {

		// Usual denominator for income and savings
		int denominator = 1;

		ArrayList<Document> documentList = person.getDocumentList();

		if ((person.getClass() + "").equals("class Tourist")) {
			for (Document document : documentList) {
				if (document.getDocumentType().equals("IL")) {
					denominator = 2;
				}

			}
		}

		// if the applicant is worker income and savings are not halved
		else if ((person.getClass() + "").equals("class Educational")) {
			for (Document document : documentList) {
				if (document.getDocumentType().equals("IL")) {
					denominator = 2;
				}

			}

		}

		else if ((person.getClass() + "").equals("class Immigrant")) {
			for (Document document : documentList) {
				if (document.getDocumentType().equals("IL")) {
					denominator = 2;
				}
			}
		}

		return denominator;

	}

	private boolean checkPassport(Applicant person) {
		String passportNum = person.getPassport().getPassportNumber();
		String expireDate = person.getPassport().getExpirationDate();
		// firstly checking whether the applicant has a passport
		if (passportNum.equals("0") && expireDate.equals("0")) {
			person.setRejectionReason("Applicant does not have a passport");
			return false;

		}

		if (passportNum.length() == 10) {
			// getting the first character of passport
			char firstChar = passportNum.charAt(0);

			// getting the last three characters
			char lastThird = passportNum.charAt(9);
			char lastSecond = passportNum.charAt(8);
			char lastFirst = passportNum.charAt(7);

			if (Character.isDigit(lastThird) && Character.isDigit(lastSecond) && Character.isDigit(lastFirst)
					&& firstChar == 'P') {
				// Finally we need to check the expiration date of passport
				double expirationInMonths = computeExpirationDate(person);

				if (expirationInMonths >= 6) {
					return true;

				}

				else {
					// case in which the expiration date is not valid
					person.setRejectionReason("Passport expiration date is not valid");
					return false;
				}

			}
			// returning false if the passport is not valid
			person.setRejectionReason("Passport is not valid");
			return false;

		}
		// returning false if the passport is not valid
		person.setRejectionReason("Passport is not valid");
		return false;

	}

	// helper method that computes expiration date
	private double computeExpirationDate(Applicant person) {
		String expirationDate = person.getPassport().getExpirationDate();

		StringTokenizer tokenizer = new StringTokenizer(expirationDate, "-");
		// tokenizing the date and getting year,month, and day
		String year = tokenizer.nextToken();
		String month = tokenizer.nextToken();
		String day = tokenizer.nextToken();

		// as the month and day Strings may contain zeros
		// at the beginning we remove them before giving them to constructor of Date
		// class
		if (month.charAt(0) == '0') {
			month = month.substring(1, month.length());

		}

		if (day.charAt(0) == '0') {
			day = day.substring(1, day.length());

		}

		// parsing year,month, and day into integer
		int numericYear = Integer.parseInt(year);
		int numericMonth = Integer.parseInt(month);
		int numericDay = Integer.parseInt(day);

		// creating a Date object that represents the current time
		Date currentDate = new Date();

		// creating new Date object that represents expirationDate
		@SuppressWarnings("deprecation")
		Date expireDate = new Date(numericYear - 1900, numericMonth, numericDay);

		long currentTime = currentDate.getTime();
		long expireTime = expireDate.getTime();

		// time difference in milliseconds
		long difference = expireTime - currentTime;

		// we need to convert milliseconds to months
		double expirationInMonths = difference * (3.8 * Math.pow(10, -10));

		return expirationInMonths;

	}

	// helper method to check whether the applicant is reasonable for
	// visa application
	private boolean isAccepted(Applicant person) {
		return (checkPassport(person) && checkPhoto(person) && checkFinancialStatus(person));

	}

	private void computeVisaDuration(Applicant person) {

		if (isAccepted(person)) {

			String visaDuration = "0";
			double expirationInMonths = computeExpirationDate(person);

			if ((person.getClass() + "").equals("class Tourist")) {

				// Defining duration constant for Tourist Applicant type
				double DC;

				boolean hasInvitationLetter = false;

				ArrayList<Document> documentList = person.getDocumentList();

				// checking whether the Tourist has an invitation letter
				for (Document document : documentList) {
					if (document.getDocumentType().equals("IL")) {
						hasInvitationLetter = true;
					}
				}

				// parsing income and savings to integer
				int numericIncome = Integer.parseInt(person.getFinancialStatus().getIncome());
				int numericSavings = Integer.parseInt(person.getFinancialStatus().getSavings());

				if (hasInvitationLetter) {
					// casting double in order not to use precision
					DC = (double) ((numericIncome - 2000) * 6 + numericSavings) / 6000;

				}

				else {
					DC = (double) ((numericIncome - 2000) * 6 + numericSavings) / 12000;

				}

				// Determining the visa duration
				if (1 <= DC && DC < 2) {
					visaDuration = "6";
					// only the numeric value 6 indicates months
					// all other durations are evaluated as years
				}

				else if (2 <= DC && DC < 4) {
					visaDuration = "1";

				}

				else {
					// case in which DC >=4 4
					visaDuration = "4";

				}

				// we also need to check whether the expiration date is before the
				// calculated duration
				int numericVisaDuration = Integer.parseInt(visaDuration);

				if (expirationInMonths < numericVisaDuration) {
					if (expirationInMonths < 6) {
						visaDuration = "0";
						// visaDuration 0 indicates rejection
						person.setRejectionReason("Passport expiration date is not valid");
						return;

					}

					else if (6 <= expirationInMonths && expirationInMonths < 12) {
						visaDuration = "6";
						// only numeric value 6 indicates month in duration
					}

					else if (12 <= expirationInMonths && expirationInMonths < 60) {
						visaDuration = "1";

					}

					else {
						visaDuration = "5";
						// case in which espirationInMonths >= 60

					}

				}

				if (visaDuration.equals("6")) {
					visaDuration = visaDuration + " months";

				}

				else if (visaDuration.equals("1")) {
					visaDuration = visaDuration + " year";

				}

				else {
					// case in which duration is more than 1 year
					visaDuration = visaDuration + " years";

				}

				person.setVisaDuration(visaDuration);

			}

			else if ((person.getClass() + "").equals("class Worker")) {
				// getting acceptance duration
				int acceptanceDuration = Integer.parseInt(person.getDocument().getDurationInMonths());

				if (expirationInMonths >= acceptanceDuration || acceptanceDuration > expirationInMonths) {

					if (expirationInMonths < 12) {
						visaDuration = "0";
						// visaDuration 0 indicates rejection
						person.setRejectionReason("Passport expiration date is not valid");
						return;
					}

					else if (12 <= expirationInMonths && expirationInMonths < 24) {
						visaDuration = "1 years";

					}

					else if (24 <= expirationInMonths && expirationInMonths < 60) {
						visaDuration = "2 years";

					}

					else {
						// situation in which expirationInMonths >= 60
						visaDuration = "5 years";

					}

				}

				person.setVisaDuration(visaDuration);

			}

			else if ((person.getClass() + "").equals("class Educational")) {

				// parsing acceptance duration to integer
				int acceptanceDuration = Integer.parseInt(person.getDocument().getDurationInMonths());

				if (expirationInMonths >= acceptanceDuration || acceptanceDuration > expirationInMonths) {

					if (expirationInMonths < 12) {
						visaDuration = "0";
						// visaDuration 0 indicates rejection
						person.setRejectionReason("Passport expiration date is not valid");
						return;
					}

					else if (12 <= expirationInMonths && expirationInMonths < 24) {
						visaDuration = "1 year";

					}

					else if (24 <= expirationInMonths && expirationInMonths < 48) {
						visaDuration = "2 years";

					}

					else {
						// case in which expirationInMonths >= 48
						visaDuration = "4 years";
					}

				}

				person.setVisaDuration(visaDuration);
			}

			else {
				// case in which the applicant is Immigrant
				visaDuration = "Permanent";
				person.setVisaDuration(visaDuration);

			}

		}

	}

	// printing out the application results
	public void showApplicationResults(ArrayList<Applicant> list, VisaChecker checker) {

		// we compute visa duration for accepted applicants
		for (Applicant person : list) {
			checker.computeVisaDuration(person);

		}

		// printing out application result for each applicant
		for (Applicant person : list) {

			// we call the overloaded version of getApplication method
			// according to rejection or acceptance

			if (person.getRejectionReason().equals("")) {
				// this is the case in which the applicant is accepted
				System.out.println(person.getApplication());

			}

			else {
				// this is the case in which the applicant is rejected
				String rejectionReason = person.getRejectionReason();
				System.out.println(person.getApplication(rejectionReason));

			}
		}

	}

}
