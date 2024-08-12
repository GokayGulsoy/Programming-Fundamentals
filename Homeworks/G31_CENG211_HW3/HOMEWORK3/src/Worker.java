public abstract class Worker {

	// instance variables of Worker abstract class
	private double opinion;
	private String order;
	
	
	// constructor for Worker abstract class
	public Worker(double opinion,String order) {
	
		this.opinion = opinion;
		this.order = order;
	}
	
	
	// getters (accessors) for Worker abstract class
	public double getOpinion() {
		
		return opinion;
	}
	
	
	public String getOrder() {
		
		return order;
	}
	
	
	
}