public class InvalidStockDataException extends Exception {
    public InvalidStockDataException(String message) {
        super(message);
    }
}

public class InvalidTransactionException extends Exception {
    public InvalidTransactionException(String message) {
        super(message);
    }
}

public class InsufficientSharesException extends Exception {
    public InsufficientSharesException(String message) {
        super(message);
    }
}