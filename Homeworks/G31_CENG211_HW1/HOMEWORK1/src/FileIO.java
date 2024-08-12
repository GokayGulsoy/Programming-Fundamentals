import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;


public class FileIO {
        
	
	private void issueCsvReader(int entry,String filename,Issue array[][]) {
		
		Scanner inputStream = null;
		
		try {
			
			inputStream = new Scanner(new FileInputStream(filename));
			
	
		}
		
	    catch (FileNotFoundException e) {
	    	System.out.println("File is not found");
	    	System.exit(0);
	    	
	    }
		
		
		String line;
		int count = 0;
		while (inputStream.hasNextLine()) {
			
			line = inputStream.nextLine();
			
			// breaking the loop when we encounter a unintended pattern
			if (line.equals(",,,,")) {
				break;
			}
			
			StringTokenizer wordfinder = new StringTokenizer(line,",");
			
			String id = "",member = "",book = "",issue_date = "",return_date = "";
			
			while (wordfinder.hasMoreTokens()) {
				
			    id = wordfinder.nextToken();				
				member = wordfinder.nextToken();
				book = wordfinder.nextToken();
				issue_date = wordfinder.nextToken();
			    return_date = wordfinder.nextToken();	
			       
			}
			
			// at the end of the each while loop for stringTokenizer
			// we will create and object of Issue class
			
			array[entry][count] = new Issue(id,member,book,issue_date,return_date);
			count++;		
			
		}	
		
	}
	
	
	private void bookCsvReader(Book[] array,String filename,int startpoint) {
		
		Scanner inputStream = null;
		
		try {
			inputStream = new Scanner(new FileInputStream(filename));
			
			
		}
		
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
			
			
		}
		
		String line;
		String id = "",title = "",author= "",publisher = "",edition = "",genre = "";
		int quantity = 0;
		while (inputStream.hasNextLine()) {
			line = inputStream.nextLine();
			
			StringTokenizer wordfinder = new StringTokenizer(line,",");
		  	
		  while (wordfinder.hasMoreTokens())  {
		  
			
			id = wordfinder.nextToken();
			title = wordfinder.nextToken();
			author = wordfinder.nextToken();
			publisher = wordfinder.nextToken();
			edition = wordfinder.nextToken();
			genre =  wordfinder.nextToken();
			// Using Integer wrapper class to parse string to integer
			quantity = Integer.parseInt(wordfinder.nextToken());
			
		  }	
		// creating an object of book class with the infomation read from file
	    // and assigning them to entries of book array
		
	    array[startpoint] = new Book(id,title,author,publisher,edition,genre,quantity);		
		startpoint++;	
			
		}
				
	}
	
	private void memberReader(Member[] array,String filename) {
		
		Scanner inputStream = null;
		
		try {
			inputStream = new Scanner(new FileInputStream(filename));
				
		}
		
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
				
		}
		
		String line;
		String id = "",name = "",email = "";
		int count = 0;
		while (inputStream.hasNextLine()) {
			line = inputStream.nextLine();

			StringTokenizer wordfinder = new StringTokenizer(line,",");
		    
			// reading first three tokens line as it is given for infomative reasons
			if ( count == 0) {
			   wordfinder.nextToken();
			   wordfinder.nextToken();
			   wordfinder.nextToken();
			}	
			
			// when we reach to last iteration there will be no tokens to read so we can finish the 
			// tokenizing process by breaking the while loop
			if (count == 5) {
				break;
				
			}
		   	
			while (wordfinder.hasMoreTokens()) {
				
				id = wordfinder.nextToken();
				name = wordfinder.nextToken();
				email = wordfinder.nextToken();
				
			}	
			
			array[count] = new Member(id,name,email);
			count++;	
				
					
			}
	}
	
	
	// This method will call the previous three methods we defined so far in order to keep the main
	// program simple (for clarity)
	
	
	public void applyReadingOperations(Issue[][] array1,Book[] array2,Member[] array3) {
		
		// Reading the issue csv files
		issueCsvReader(0,"L1_Issues.csv",array1);
		issueCsvReader(1,"L2_Issues.csv",array1);
		issueCsvReader(2,"L3_Issues.csv",array1);
		
		// Reading the books csv files
		bookCsvReader(array2,"L1_Books.csv",0);
		bookCsvReader(array2,"L2_Books.csv",20);
		bookCsvReader(array2,"L3_Books.csv",30);
		
	   // Reading the Members csv file
	   memberReader(array3,"Members.csv");
		
	}
	
		
}
