package ClassWork;
// EmployeeManagementSystem.java
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeManagementSystem {

    public static void main(String[] args) {
        // Using try-with-resources to ensure the scanner is closed automatically.
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the Employee Management System");

            int type = getEmployeeType(scanner);
            String name = getName(scanner);
            int id = getId(scanner);
            double salary = getSalary(scanner);
            String department = getDepartment(scanner);

            // Create the appropriate Employee instance.
            Employee employee;
            if (type == 1) {
                employee = new Manager(name, id, salary, department);
            } else { // type must be 2
                employee = new Developer(name, id, salary, department);
            }

            // Display employee details and bonus.
            System.out.println("\nEmployee Details:");
            employee.displayEmployeeInfo();

        } catch (Throwable t) {
            // This catch block handles any errors or exceptions that were not caught elsewhere.
            System.out.println("A serious error occurred: " + t.getMessage());
        }
    }

    // Prompts the user for the employee type until a valid integer (1 or 2) is entered.
    private static int getEmployeeType(Scanner scanner) {
        while (true) {
            System.out.println("Enter employee type (1 for Manager, 2 for Developer):");
            try {
                int type = scanner.nextInt();
                scanner.nextLine(); // clear newline character
                if (type == 1 || type == 2) {
                    return type;
                } else {
                    System.out.println("Invalid type. Please enter 1 for Manager or 2 for Developer.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input mismatch error: Please enter an integer (1 or 2).");
                scanner.nextLine(); // clear the invalid input
            }
        }
    }

    // Prompts the user to enter a name.
    private static String getName(Scanner scanner) {
        System.out.println("Enter Name:");
        return scanner.nextLine();
    }

    // Prompts the user for an integer ID until valid input is entered.
    private static int getId(Scanner scanner) {
        while (true) {
            System.out.println("Enter ID (integer):");
            try {
                int id = scanner.nextInt();
                scanner.nextLine(); // clear newline
                return id;
            } catch (InputMismatchException e) {
                System.out.println("Input mismatch error: Please enter a valid integer for ID.");
                scanner.nextLine(); // clear the invalid input
            }
        }
    }

    // Prompts the user for a salary (as a decimal) until valid input is entered.
    private static double getSalary(Scanner scanner) {
        while (true) {
            System.out.println("Enter Salary (decimal):");
            try {
                double salary = scanner.nextDouble();
                scanner.nextLine(); // clear newline
                return salary;
            } catch (InputMismatchException e) {
                System.out.println("Input mismatch error: Please enter a valid decimal number for Salary.");
                scanner.nextLine(); // clear the invalid input
            }
        }
    }

    // Prompts the user to enter a department.
    private static String getDepartment(Scanner scanner) {
        System.out.println("Enter Department:");
        return scanner.nextLine();
    }
}
