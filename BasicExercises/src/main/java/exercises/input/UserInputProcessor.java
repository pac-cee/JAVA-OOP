package exercises.input;

import java.util.Scanner;

public class UserInputProcessor {
    public static int processNumericInput(Scanner scanner) {
        System.out.print("Enter a number: ");
        int value = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return value * 2; // Example processing: doubles the input
    }

    public static void swapNumbers(int[] numbers) {
        // Swap without using temporary variable
        numbers[0] = numbers[0] + numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] = numbers[0] - numbers[1];
    }
}
