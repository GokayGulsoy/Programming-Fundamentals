package visacontrolapp;

import java.util.ArrayList;

public class Demo {
	public static void main(String[] args) {

		// returning a copy of applicant list
		ArrayList<Applicant> applicantList = FileIO.setDocuments();

		// creating an object of VisaChecker class
		VisaChecker checker = new VisaChecker();

		// sorting applicantList according to IDs
		SelectionSort.sort(applicantList);

		// printing out the application results
		checker.showApplicationResults(applicantList, checker);

	}

}
