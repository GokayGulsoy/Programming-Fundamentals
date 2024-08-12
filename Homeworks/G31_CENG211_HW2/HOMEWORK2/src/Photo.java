public class Photo {

	// instance variables of the Photo class
	private String resolution;
	private String position;
	
	// constructor for Photo class
	public Photo(String resolution,String position) {
		
		this.resolution = resolution;
		this.position = position;
		
		
	}
		
	// Copy constructor for Photo class
	public Photo(Photo otherPhoto) {
		
		if (otherPhoto == null) {
			System.out.println("Fatal error object is null");
			System.exit(0);
			
		}
		
		else {
			resolution = otherPhoto.resolution;
			position = otherPhoto.position;
			
		}
		
	}
	
	
	// getters (accessors) for Photo clas
	public String getResolution()  {
		return resolution;
		
	}
	
	public String getPosition() {
		return position;
		
	}
	
	// setters (mutators) for Photo class
	
	public void setResolution(String resolution) {
		this.resolution = resolution;
		
	}
	
	public void setPosition(String position) {
		this.position = position;
		
	}
	
}
