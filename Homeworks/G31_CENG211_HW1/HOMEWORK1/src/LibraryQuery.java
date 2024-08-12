import java.util.StringTokenizer;
import java.util.Date;

public class LibraryQuery {

	 private Book findMostIssuedBook(int row,int size,Issue[][] array1,Book[] array2) {
		 
		 int countArray[] = new int[size];
		 
		 // determining where to start to search for each book
         int startPoint = determineStartPoint(row);
		 
		 // Using nested for loops to find the most issued book in each library
		 
		 for (int i = 0; i < size; i++) {
			   // Using inner for loop to count the number of issues for each book
			  int count = 0;   
			  for (int j = 0; j < array1[row].length; j++) {
				   if (array2[i+startPoint].getID().equals(array1[row][j].getBook())) {
					   count++;
					   
				   }
				   
			   }
			 // at the end of each inner for loop add issue amount for each book
			// to  countarray 
			countArray[i] = count;   
			
		 }
		 
		 // at the end of the outer for loop find the most frequent issue amount
		 int max = countArray[0];
		 for (int i = 0; i < countArray.length; i++) {
			 if (countArray[i] > max) {
				 max = countArray[i];
				 
			 }
			 
		 }
		 		 
		 // next job is to find where the most issued book is located
		 int mostIssued = linearSearch(countArray,max);
		 
		 if (row == 0) {
			 return array2[mostIssued];
			 
		 }
		 
		 else if (row == 1) {
			 return array2[mostIssued+20];
			 
			 
		 }
		 
		 else  {
			 return array2[mostIssued+30];
			 
		 }
		  
	 }
	 
	 
	 private String mostIssuedOfThree(Book book1,Book book2,Book book3,Issue[][] array) {
		 
		 // array that will keep amount of issues of three most issued books from 
		 // three book libraries
		 int countArray[] = new int[3];

		 // checking how many times each book object is occuring in the issue 
		 // array's corresponding entry
		 
		 int count1 = 0,count2 = 0,count3 = 0;
	     // calling countOccurences method
		 count1 = countOccurences(book1,array,0);
		 count2 = countOccurences(book2,array,1);
		 count3 = countOccurences(book3,array,2);
		 
		 // assigning the entries of an count array
		 countArray[0] = count1;
		 countArray[1] = count2;
		 countArray[2] = count3;
		 
	
		 // After finding the number of occurences of each mostly occured book
		 // objects in each three library, we will find the most issued one among
		 // three
		 
		 int max = countArray[0];
		 for (int i = 0; i < countArray.length; i++) {
		       if (countArray[i] > max) {
		    	   max = countArray[i];
		    	   
		       }
			 
			 
		 }
	 	 
	     // locating the index of the max element in array
	     int index = linearSearch(countArray,max);
	     
		 // selecting and returning the most issued book object
	     if (index == 0) {
	    	 return book1.getTitle();
	    	 
	     }
		 
	     else if (index == 1) {
	    	 return book2.getTitle();
	    	 
	     }
		 
	     else {
	    	 return book3.getTitle();
	    	 
	     }
				 
	 }
	 
	 
	 private int[] issueAmountMemberArrays(int row,Issue[][] array1,Member[] memberArray) {
		 
		 int[] countArray = new int[5];
		 
		 // finding the issue amount for each member
		 for (int i = 0; i < countArray.length; i++) {
			 
			 int count = 0;
			 for (int j = 0; j < array1[row].length; j++) {
				 if (memberArray[i].getID().equals(array1[row][j].getMember())) {
					 count++;
					 
				 }
			 
			 }
			 
			 // at the end of the each inner for loop assigning the entry of countarray
			 countArray[i] = count;
			
		 }
		 
		 // returning the count array for given row of issue array
		 return countArray;
	 
	 }
	
	 
	 private String mostIssuedMember(int[] array1,int[] array2,int[] array3,Member[] memberArray) {
		  
		 int[] countArray = new int[5];
		 
		 for (int i = 0; i < countArray.length; i++) {
			 countArray[i] = array1[i] + array2[i] + array3[i];
			 
		 }
		 
		 // at the end of the for loop we will find how any times that the each member has issued
		 
		// finding the most issuing amount 
		int max = 0; 
		
		for (int i = 0; i < countArray.length; i++) {
			  if (countArray[i] > max) {
				  max = countArray[i];
				  
			  }
		}
		
		// finding where the most issued amount is located
		int index = linearSearch(countArray,max);
		
		// returning the person name who has most issued
		return memberArray[index].getName();
		 
	 }
	 
	 
	 public String leastIssuedComputerScienceMember(Issue[][] array1,Member[] memberArray) {
		 
		 int[] countArray = new int[5];
		 
		 // finding how many books each member has borrowed from computer science library
		 for (int i = 0; i < countArray.length; i++) {
			 
			 int count = 0;
			 for (int j = 0; j < array1[2].length; j++) {
				 if (memberArray[i].getID().equals(array1[2][j].getMember())) {
					 count++;
					 
				 }
				  
			 }
			 
			 // at the end of the each inner for loop assign the entry of countarray
			 
			 countArray[i] = count;
		 }
		 
		 // finding the least issue amount 
		int min = countArray[1];
		for (int i = 2; i < countArray.length; i++) {
			if (countArray[i] < min) {
				min = countArray[i];
				
			}
		}
		
		// finding the where the min is located
		int index = linearSearch(countArray,min);
			
		// returning the name of person who has issued least form computer science library
		return memberArray[index+1].getName();
			 
	 }
	 
	 public String findMostCopied(Book[] array) {
		 
		 // finding the book with most copies
		 int mostCopy = array[0].getQuantity();
		 
	     for (int i = 0; i < array.length; i++) {
	    	 if (array[i].getQuantity() > mostCopy) {
	    		 mostCopy = array[i].getQuantity();
	    		 
	    	 }
	     }
		 
		 
	     // After finding the book with most copies locating it in our array
	     int index = 0;
	     for (int i = 0; i < array.length; i++) {
	    	 if (array[i].getQuantity() == mostCopy) {
	    		 index = i; 
	    		 
	    	 }
	     }
	     
	     // we find the book with the most copies returning the name of that book
	     return array[index].getTitle();
	     	 
	 }
	 
	 public String fewestCopies(int row,int size,int entryNum,int copyAmount,Issue[][] array1,Book[] array2) {
		 // determining from where to start searching process
		 int startPoint = determineStartPoint(row);

		 Book[] tempArray = new Book[entryNum];
		 
		 // checking whether the book is previously issued or not
		int index = 0;
		 for (int i = 0; i < size; i++) {
			 
			 for (int j = 0; j < array1[row].length; j++) {
				 if (array2[i+startPoint].getID().equals(array1[row][j].getBook()) && isContained(array2[i+startPoint],tempArray)) {
					 
					 // assigning the entries of temparray if the book is previously issued
					 tempArray[index] = array2[i+startPoint];
					 index++;
									 
				 }	 
			 }
			 
		 }
	    	 		 
		// As the first issue list contains two fewest amount of copy books we will return the title of both 
	    // according to given row number	
		 
		 // finding the fewest copy amount
		 int minCopy = tempArray[0].getQuantity();
		 for (int i = 0; i < tempArray.length-copyAmount; i++) {
			 if (tempArray[i].getQuantity() < minCopy) {
				 minCopy = tempArray[i].getQuantity();
				 
			 }
		 }
		 
		 // returning the name of book object which has fewest copies and previosuly issued 
	     index = 0;
		 for (int i = 0; i < tempArray.length-copyAmount; i++) {
			 if (tempArray[i].getQuantity() == minCopy) {
				  index = i;
				 
			 }
		 }
		 
		 return tempArray[index].getTitle();
		
		 
	 }
	
	 private double findHighestPenalty(Issue[][] array,int row) {
		 
		 // Using for loop to find penalty for each Issue
		 double[] countArray = new double[array[row].length];
		 
		 for (int i = 0; i < array[row].length; i++) {
			 // Tokenizing the issue date
			 StringTokenizer startDate = new StringTokenizer(array[row][i].getIssuedate(),"-");
			 
			 String startDay = startDate.nextToken(); 
			 String startMonth = startDate.nextToken();
			 String startYear = startDate.nextToken();
			 
			 // Tokenizing the return date
			 StringTokenizer returnDate = new StringTokenizer(array[row][i].getReturndate(),"-");
			 
			 String returnDay = returnDate.nextToken();
			 String returnMonth = returnDate.nextToken();
			 String returnYear = returnDate.nextToken();
			 
			 // Using Date class to find out day difference between given dates
			 startYear = "20" + startYear; 
			 int startingYear = Integer.parseInt(startYear);
			 int startingDay = Integer.parseInt(startDay); 
			 int startingMonth = getMonth(startMonth);
			 
			 
			 returnYear = "20" + returnYear;
			 int returningYear = Integer.parseInt(returnYear);
			 int returningDay = Integer.parseInt(returnDay);
			 int returningMonth = getMonth(returnMonth);
			 
			 @SuppressWarnings("deprecation")
			 Date dateEnd = new Date(returningYear,returningMonth,returningDay);
			 @SuppressWarnings("deprecation")
			 Date dateBegin = new Date(startingYear,startingMonth,startingDay);
			 
			 // getting milliseconds for both dates
			 long date1Ms = dateBegin.getTime();
			 long date2Ms = dateEnd.getTime();
			 
			 
			 // Getting the time difference between two dates
			 long timeDiff = 0;
			 
			 if (date1Ms > date2Ms) {
				 timeDiff = date1Ms - date2Ms;
				 
			 }
			 
			 else {
				 timeDiff = date2Ms - date1Ms;
				 
			 }
			 
			 // converting milliseconds to days
			 int daysDiff = (int) (timeDiff / (1000 * 60 * 60 * 24));
			 
			 // finding penalty for each issue
			 double penalty;
			 if (daysDiff > 14) {
				  penalty = (daysDiff-14)*(0.5);
				 
			 }
			 
			 else {
				 penalty = 0;
			 }
			 
			 countArray[i] = penalty;
		 
		 }
		 
		 // finding the highest penalty for given row of Issue array
		 double highestPenalty = findMaxOfArray(countArray);
		 
		 // returning the highest penalty for a given row of Issue array
		 return highestPenalty; 		 
	 }
	 
	 private double returnHighestPenalty(double penalty1,double penalty2,double penalty3) {		 
		 // Array that will hold the penalties
		 double[] countArray = new double[3];   
		 
		 // Assigning the entries of array with penalties
		 countArray[0] = penalty1;
		 countArray[1] = penalty2;
		 countArray[2] = penalty3;
		 
		 // finding the highest penalty 
		 double highestPenalty = findMaxOfArray(countArray);
		 
	     // returning the highest penalty
	     return highestPenalty;
	 }
	 
	 
	 // These methods will call the other methods that we have defined so far to keep the main program
	 // simple (for clarity)
	 
	 public String applyFindMostIssuedBook(Issue[][] array1,Book[] array2) {
		 
			// finding the most issued books in each library 
			Book lib1MostIssued = findMostIssuedBook(0,20,array1,array2);
			Book lib2MostIssued = findMostIssuedBook(1,10,array1,array2);
			Book lib3MostIssued = findMostIssuedBook(2,13,array1,array2);
		
			// finding the most issued book among three libraries 
			String mostIssuedBook = mostIssuedOfThree(lib1MostIssued, lib2MostIssued, lib3MostIssued,array1);
		 
		    // returning the most issued book
			return mostIssuedBook;
		 
	 }
	 
	 public String applymostIssuedMember(Issue[][] array1,Member[] array2) {
		 
		 int[] firstArray = issueAmountMemberArrays(0,array1,array2);
		 int[]secondArray = issueAmountMemberArrays(0,array1,array2);
		 int[] thirdArray = issueAmountMemberArrays(0,array1,array2);
		 
		 String memberMostIssued = mostIssuedMember(firstArray,secondArray,thirdArray,array2);
		 
		 // returning the member who has most issued
		 return memberMostIssued;
		 	 
	 }
	 
	 public double applyFindHighestPenalty(Issue[][] array) {
		 
		 double penalty1 = findHighestPenalty(array,0);
		 double penalty2 = findHighestPenalty(array,1);
		 double penalty3 = findHighestPenalty(array,2);
		 
		 double highestPenalty = returnHighestPenalty(penalty1,penalty2,penalty3); 
		
		 // returning the highest penalty
		 return highestPenalty;
		 
	 }
	 
	 public String[] applyFindBookWithFewestCopies(Issue[][] array1,Book[] array2) {
		 
		 // Array that will
		 String[] countArray = new String[4];
		 
		 String title1  = fewestCopies(0,20,16,2,array1,array2);
		 String title2 = fewestCopies(0,20,16,0,array1,array2);
		 String title3  = fewestCopies(1,10,8,0,array1,array2);
		 String title4  = fewestCopies(2,13,11,0,array1,array2);
		 
		 countArray[0] = title1;
		 countArray[1] = title2;
		 countArray[2] = title3;
		 countArray[3] = title4;
		 
		 // returning the least issued computer science books
		 return countArray;
		 
	 }
	 
	 // Some helper methods 
	 private int getMonth(String month) {
		 
	        switch (month) {
		          case "Jan": 
			         return 1;
		          case "Feb":	 
			         return 2;
		          case "Mar":
			         return 3;
		          case "Apr":	 
			         return 4;
		          case "May":
			         return 5;
		          case "Jun":
			         return 6;
		          case "Jul":
		        	  return 7;
		          case "Aug":
		        	  return 8;
		          case "Sep":
		        	  return 9;
		          case "Oct":	  
		        	  return 10;
		          case "Nov":	  
		        	  return 11;
		          case "Dec":
		        	  return 12;
		          default:	  
		        	  // if the invalid name for month is given
		        	  System.out.println("The invalid month name is given");
		        	  System.exit(0);
		        	  return 0; // To keep compiler satisfied	        	  
		 }	   
	
	}


	private boolean isContained(Book bookobj,Book[] array) {
		 
		 // Checking if the book object is already contained in the array or not
		 for (int i = 0; i < array.length; i++) {
			if (array[i] != null)  {
			   if (bookobj.getID().equals(array[i].getID())) {
				  // case in which the book object is already contained in the array
				  return false;
			
			   } 
			} 
			
		 }
		 
		 // case in which book object is not already in the array
		return true;
	 
	 }
	  
	 private int countOccurences(Book book,Issue[][] array,int row) {
		 // finding how many times each book object is issued among the 
		 // three most issued books in each library
		 int count = 0;
		 for(int i = 0; i < array[row].length; i++) {
			 if (book.getID().equals(array[row][i].getBook())) {
				 count++;
				 
			 }
		 }
		 
		 return count;
	 }
	 
	 
	 private int determineStartPoint(int row) {
		 
		 int startPoint;
		 
		 // determining start point for searching
		 if (row == 1) {
			 startPoint = 20;
			 
		 }
		 
		 else if (row == 2) {
			 startPoint = 30;
			 
		 }
		 
		 else {
			 startPoint = 0;
			 
		 }
		 
		 // returning the startpoint for search 
		 return startPoint;
	 
	 }
	 
	 private double findMaxOfArray(double[] array) {
		 // finding the max value of array
		 double highest = array[0];
		 
		 for (int i = 0; i < array.length; i++) {
			  if (array[i] > highest) {
				  highest = array[i];
			  }
			 
			 
		 }
		 
		 // returning the maximum of array
		 return highest;
	 }
	 
	 private int linearSearch(int[] array,int key) {	 
		 int index = 0;
		 // applying linear search algorithm
		 for (int i = 0; i < array.length; i++) {
			 if (key == array[i]) {
				 index = i;
			 }
			 
		 }
		 
		 // if the element was not found
		 return index;
		 
	 }
	 
	 
	 
	 
	 	
}
