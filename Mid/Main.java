package Mid;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice = 0;
            
            do {
                System.out.println("\n----- Main Menu -----");
                System.out.println("1. Bank Operations");
                System.out.println("2. Rectangle Area Calculator");
                System.out.println("3. Student Marks Calculator");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                
                String input = scanner.nextLine();
                try {
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a numeric value.");
                    continue;
                }
                
                switch (choice) {
                    case 1 -> {
                        System.out.println("\nLaunching Bank Operations...");
                        Bank.run(scanner);
                    }
                    case 2 -> {
                        System.out.println("\nLaunching Rectangle Area Calculator...");
                        RectangleAreaCalculator.run(scanner);
                    }
                    case 3 -> {
                        System.out.println("\nLaunching Student Marks Calculator...");
                        StudentMarksCalculator.run(scanner);
                    }
                    case 4 -> System.out.println("Exiting program. Thank you!");
                    default -> System.out.println("Invalid choice. Please try again.");
                }
                
            } while (choice != 4);
        }
    }
}
