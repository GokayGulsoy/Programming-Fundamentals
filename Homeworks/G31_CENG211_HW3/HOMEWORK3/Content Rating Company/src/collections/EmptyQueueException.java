package collections;

/**
 *
 * @author Gökay Gülsoy
 */
public class EmptyQueueException extends RuntimeException {
    
    public EmptyQueueException() {
        super("Queue is empty!");
    }
        
}
