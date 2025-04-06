public interface Stock {
    // Abstract methods
    double calculateMarketValue() throws Exception;
    void updatePrice(double percentageChange);
    String getStockType();

    // Getters for attributes
    String getSymbol();
    double getPrice();
    int getVolume();
    String getExchangeName();

    // Trading operations
    void buyShares(int qty) throws InvalidTransactionException;
    void sellShares(int qty) throws InvalidTransactionException, InsufficientSharesException;
}

// Custom exception classes
class InvalidTransactionException extends Exception {
    public InvalidTransactionException(String message) {
        super(message);
    }
}

class InsufficientSharesException extends Exception {
    public InsufficientSharesException(String message) {
        super(message);
    }
}

class InvalidStockAttributeException extends Exception {
    public InvalidStockAttributeException(String message) {
        super(message);
    }
}
