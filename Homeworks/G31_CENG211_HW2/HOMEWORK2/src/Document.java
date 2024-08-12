public class Document {
       
	// instance variables for Document class
	private String documentType;
	private String durationInMonths;
	
   // contructors for Document class
   public Document(String documentType,String durationInMonths) {
	   
	   this.documentType = documentType;
	   this.durationInMonths = durationInMonths;
	   
   }
	
   // Copy constructor for Document class
   public Document(Document otherDocument) {
	   
	   if (otherDocument == null) {
		   System.out.println("Fatal error object is null");
		   System.exit(0);
		   
	   }
	   
	   else {
		   documentType = otherDocument.documentType;
		   durationInMonths = otherDocument.durationInMonths;
		   
	   }
	   
	   
   }
     
   // as the durationInMonths is optional we will have another 
   // constructor for Document class
   
   public Document(String documentType) {
	   
	   this.documentType = documentType;
	   durationInMonths = "";
	   
   }
   
   // getters (accessors) for Document class
   public String getDocumentType() {
	   return documentType;
	   
   }
   
   public String getDurationInMonths() {
	   return durationInMonths;
	   
   }
   
   // setters (mutators) for Document class
   
   public void setDocumentType(String documentType) {
	   this.documentType = documentType;
	   
   }
   
   public void setDurationInMonths(String durationInMonths) {
	   this.durationInMonths = durationInMonths;
	   
   }
   
   
  
}
