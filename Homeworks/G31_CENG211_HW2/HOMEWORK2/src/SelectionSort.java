import java.util.ArrayList;

public class SelectionSort {
	
	// This is the class that uses selection sort algorithm to
	// sort the Applicant ID's 
	
	public static void sort(ArrayList<Applicant> list) {
		
		int indexOfSmallest;
		int index;
		
		for (index = 0; index < list.size()-1; index++) {
			 indexOfSmallest = findIndexOfSmallest(list,index);
    		 interchange(list,index,indexOfSmallest);		
			
		}
	}
	
	
	// method for finding the smallest index for a given portion of array
    private static int findIndexOfSmallest(ArrayList<Applicant> list,int startIndex) {
    	
    	int index;
    	int indexOfSmallest = startIndex;
    	String min = list.get(indexOfSmallest).getID();
    	
    	for (index = startIndex+1; index < list.size(); index++) {
    		if (min.compareTo(list.get(index).getID()) > 0) {
    			  indexOfSmallest = index;
    			  min = list.get(index).getID();
    			
    		}
    	}
    	
    	// At the end of the for loop we will get the min applicant ID
    	return indexOfSmallest;
    	
    }
	
	
    // method for interchanging variables
    private static void interchange(ArrayList<Applicant> list,int i,int j) { 
    	Applicant temp = list.get(i);    	
    	list.set(i,list.get(j));
    	list.set(j,temp);
    	
    }
	
}
