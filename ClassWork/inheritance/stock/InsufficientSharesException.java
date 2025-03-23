package ClassWork.inheritance.stock;

public class InsufficientSharesException extends Exception {
    
    public InsufficientSharesException(String message) {
        super(message);
    }   
}
// Compare this snippet from ClassWork/inheritance/stock/Stock.java: