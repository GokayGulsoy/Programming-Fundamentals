package visacontrolapp;

import java.util.ArrayList;

public abstract class Applicant {

	// instance variables of the applicant base class
	private String applicantID;
	private String name;
	private Passport passport;
	private Photo photo;
	private FinancialStatus financialStatus;
	private Document document;
	private ArrayList<Document> documentList;
	private String visaDuration;
	private String rejectionReason;

	// no-argument constructor for Applicant class
	public Applicant() {
		// below are the default initalizations they will be later set to actual values
		applicantID = "";
		name = "";
		passport = new Passport("0", "0");
		photo = new Photo("0", "0");
		financialStatus = new FinancialStatus("0", "0");
		document = new Document("", "0");
		documentList = new ArrayList<Document>();
		visaDuration = "0";
		rejectionReason = "";

	}

	// copy-constructor for Applicant class
	public Applicant(Applicant otherApplicant) {

		if (otherApplicant == null) {
			System.out.println("Fatal error objcet is null");
			System.exit(0);

		}

		else {
			applicantID = otherApplicant.applicantID;
			name = otherApplicant.name;
			passport = otherApplicant.passport;
			photo = otherApplicant.photo;
			financialStatus = otherApplicant.financialStatus;
			document = otherApplicant.document;
			documentList = otherApplicant.documentList;
			visaDuration = otherApplicant.visaDuration;
			rejectionReason = otherApplicant.rejectionReason;

		}

	}

	// getters (accessors) for Applicant class

	public String getID() {
		return applicantID;

	}

	public String getName() {
		return name;

	}

	public String getRejectionReason() {
		return rejectionReason;

	}

	// as the class types are referance types to be more secure we
	// need to return copy of them

	public Passport getPassport() {

		return new Passport(passport);

	}

	public Photo getPhoto() {
		return new Photo(photo);

	}

	public FinancialStatus getFinancialStatus() {
		return new FinancialStatus(financialStatus);

	}

	public Document getDocument() {
		return new Document(document);

	}

	public ArrayList<Document> getDocumentList() {
		return copyDocumentList(documentList);

	}

	public String getVisaDuration() {
		return visaDuration;

	}

	// setters (mutators) for Applicant class

	public void setID(String ID) {
		applicantID = ID;

	}

	public void setName(String name) {
		this.name = name;

	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;

	}

	public void setPassport(String passportNumber, String expirationDate) {
		passport.setPassportNumber(passportNumber);
		passport.setExpirationDate(expirationDate);

	}

	public void setPhoto(String resolution, String position) {
		photo.setResolution(resolution);
		photo.setPosition(position);

	}

	public void setFinancialStatus(String income, String savings) {
		financialStatus.setIncome(income);
		financialStatus.setSavings(savings);

	}

	public void setVisaDuration(String visaDuration) {
		this.visaDuration = visaDuration;

	}

	public void setDocument(String documentType, String durationInMonths) {
		document.setDocumentType(documentType);
		document.setDurationInMonths(durationInMonths);

	}

	// as the duration in months is optional we have an alternative overloaded
	// version of the
	// setDocument method

	public void setDocument(String documentType) {
		document.setDocumentType(documentType);

	}

	public void addDocument(Document document) {
		documentList.add(document);

	}

	// copy method for ArrayList that contains document objects
	private ArrayList<Document> copyDocumentList(ArrayList<Document> list) {

		ArrayList<Document> copyList = new ArrayList<Document>();

		// copying each element of our original ArrayList
		for (Document document : list) {
			copyList.add(document);

		}

		// At the end of the for loop we will get a copy of ArrayList
		return copyList;

	}

	// abstract methods, each subclass will overide them accordingly
	public abstract String getApplication();

	public abstract String getApplication(String rejectionReason);

}
