// Demonstrates try-catch, try-with-resources, multiple catch blocks, and custom exceptions
import java.io.*;
public class ExceptionDemo {
    public static void main(String[] args) {
        // ArithmeticException
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Error: " + e.getMessage());
        }
        // Multiple catch blocks
        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("Null pointer!");
        } catch (Exception e) {
            System.out.println("General error: " + e.getMessage());
        }
        // Try-with-resources for file I/O
        try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
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
// Custom checked exception
class NegativeNumberException extends Exception {
    public NegativeNumberException(String msg) { super(msg); }
}
