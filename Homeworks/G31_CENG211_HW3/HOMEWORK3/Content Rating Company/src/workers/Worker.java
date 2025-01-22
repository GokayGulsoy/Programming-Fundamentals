package workers;

/**
 *
 * @author Gökay Gülsoy
 */
public abstract class Worker {

    private double opinion;
    private int orderNumber;

    // constructor for Worker abstract class
    public Worker(double opinion, int orderNumber) {
        this.opinion = opinion;
        this.orderNumber = orderNumber;

    }

    // getters (accessors) for Worker abstract class
    public double getOpinion() {
        return opinion;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

}
