package collections;

/**
 *
 * @author Gökay Gülsoy
 */
public class EmptyStackException extends RuntimeException {
        
    public EmptyStackException(){
        super("Stack is empty!");
    }
    
}
