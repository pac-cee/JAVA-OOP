import java.util.Scanner;

public class CustomExceptionExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int num = sc.nextInt();
        try {
            if (num < 0) throw new NegativeNumberException("Negative numbers not allowed!");
            System.out.println("You entered: " + num);
        } catch (NegativeNumberException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
