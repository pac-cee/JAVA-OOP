// Demonstrates try-catch and custom exceptions
public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
        // Custom exception
        try {
            checkPositive(-5);
        } catch (NegativeNumberException e) {
            System.out.println("Custom Error: " + e.getMessage());
        }
    }
    static void checkPositive(int n) throws NegativeNumberException {
        if (n < 0) throw new NegativeNumberException("Negative not allowed");
    }
}
class NegativeNumberException extends Exception {
    public NegativeNumberException(String msg) { super(msg); }
}
