package classwork.inheritance.stock;

public class InsufficientSharesException extends Exception {
    
    public InsufficientSharesException(String message) {
        super(message);
    }   
}
