import java.util.Scanner;

public class Simplecalculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("A simple calculator:");
            System.out.println("Choose an operator:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");

            int choice = scanner.nextInt();

            System.out.println("Enter first number: ");
            double num1 = scanner.nextDouble();

            System.out.println("Enter second number: ");
            double num2 = scanner.nextDouble();

            double result = switch (choice) {
                case 1 -> num1 + num2;
                case 2 -> num1 - num2;
                case 3 -> num1 * num2;
                case 4 -> {
                    if (num2 != 0) {
                        yield num1 / num2;
                    } else {
                        System.out.println("Error! Division by zero.");
                        yield Double.NaN; // Not a Number to indicate an error
                    }
                }
                default -> {
                    System.out.println("Invalid operator choice.");
                    yield Double.NaN; // Not a Number to indicate an error
                }
            };

            if (!Double.isNaN(result)) {
                System.out.println("Result: " + result);
            }
        }
    }
}