package ClassWork.inheritance.stock;
public class InvalidStockDataException extends Exception {
    public InvalidStockDataException(String message) {
        super(message);
    }
}

// Compare this snippet from ClassWork/inheritance/stock/Stock.java: