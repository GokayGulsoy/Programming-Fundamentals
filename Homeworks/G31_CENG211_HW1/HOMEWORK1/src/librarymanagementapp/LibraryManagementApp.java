package librarymanagementapp;

public class LibraryManagementApp {

	public static void main(String[] args) {

		FileIO reader = new FileIO();
		LibraryManagement manager = new LibraryManagement();
		LibraryQuery queries = new LibraryQuery();
		Member member = new Member();
		Library librarian = new Library();

		// Performing file reading operations
		reader.applyReadingOperations(manager.getArray(), librarian.getArray(), member.getArray());

		// Finding the most issued Book
		String mostIssuedBook = queries.applyFindMostIssuedBook(manager.getArray(), librarian.getArray());

		// finding the most issued member in all three libraries
		String mostIssuedMember = queries.applymostIssuedMember(manager.getArray(), member.getArray());

		// finding the highest penalty for the given issues
		double highestPenalty = queries.applyFindHighestPenalty(manager.getArray());

		// finding the book with most copies
		String mostCopiedBook = queries.findMostCopied(librarian.getArray());

		// fnding the book with fewest copies which is previously issued
		String title1 = queries.applyFindBookWithFewestCopies(manager.getArray(), librarian.getArray())[0];
		String title2 = queries.applyFindBookWithFewestCopies(manager.getArray(), librarian.getArray())[1];
		String title3 = queries.applyFindBookWithFewestCopies(manager.getArray(), librarian.getArray())[2];
		String title4 = queries.applyFindBookWithFewestCopies(manager.getArray(), librarian.getArray())[3];

		// finding the least issued member from computer science library
		String leastIssuedMember = queries.leastIssuedComputerScienceMember(manager.getArray(), member.getArray());

		System.out.println("1.) " + mostIssuedBook);
		System.out.println("2.) " + mostIssuedMember);
		System.out.println("3.) " + highestPenalty + " TL");
		System.out.println("4.) " + mostCopiedBook);
		System.out.println("5.) " + title1 + "," + title2 + "," + title3 + "," + title4);
		System.out.println("6.) " + leastIssuedMember);

	}

}
