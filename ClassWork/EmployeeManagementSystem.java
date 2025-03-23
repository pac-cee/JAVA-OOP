package classwork;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Employee class encapsulating employee details
class Employee {
    private int id;
    private String name;
    private String position;
    private double salary;

    public Employee(int id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Position: " + position + " | Salary: " + salary;
    }
}

// EmployeeManager class to perform CRUD operations on employees
class EmployeeManager {
    private ArrayList<Employee> employees = new ArrayList<>();

    // Add a new employee
    public void addEmployee(Employee emp) {
        employees.add(emp);
        System.out.println("Employee added successfully.");
    }

    // Update employee details
    public void updateEmployee(int id, String newPosition, double newSalary) {
        Employee emp = findEmployeeById(id);
        if (emp != null) {
            emp.setPosition(newPosition);
            emp.setSalary(newSalary);
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Remove an employee by id
    public void removeEmployee(int id) {
        Employee emp = findEmployeeById(id);
        if (emp != null) {
            employees.remove(emp);
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // List all employees
    public void listEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employee records available.");
            return;
        }
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    // Helper method to find employee by id
    private Employee findEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id)
                return emp;
        }
        return null;
    }
}

public class EmployeeManagementSystem {
    private static EmployeeManager manager = new EmployeeManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        System.out.println("Welcome to the Employee Management System!");
        do {
            displayMenu();
            choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    addNewEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    removeEmployee();
                    break;
                case 4:
                    manager.listEmployees();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        scanner.close();
    }

    // Display menu options for employee management
    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add New Employee");
        System.out.println("2. Update Employee");
        System.out.println("3. Remove Employee");
        System.out.println("4. List All Employees");
        System.out.println("5. Exit");
    }

    // Add a new employee
    private static void addNewEmployee() {
        int id = getIntInput("Enter employee ID: ");
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee position: ");
        String position = scanner.nextLine();
        double salary = getDoubleInput("Enter employee salary: ");
        Employee emp = new Employee(id, name, position, salary);
        manager.addEmployee(emp);
    }

    // Update employee details
    private static void updateEmployee() {
        int id = getIntInput("Enter employee ID to update: ");
        System.out.print("Enter new position: ");
        String position = scanner.nextLine();
        double salary = getDoubleInput("Enter new salary: ");
        manager.updateEmployee(id, position, salary);
    }

    // Remove an employee
    private static void removeEmployee() {
        int id = getIntInput("Enter employee ID to remove: ");
        manager.removeEmployee(id);
    }

    // Get integer input with validation
    private static int getIntInput(String prompt) {
        int value = 0;
        while (true) {
            System.out.print(prompt);
            try {
                value = scanner.nextInt();
                scanner.nextLine(); // clear newline
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer value.");
                scanner.nextLine();
            }
        }
        return value;
    }

    // Get double input with validation
    private static double getDoubleInput(String prompt) {
        double value = 0;
        while (true) {
            System.out.print(prompt);
            try {
                value = scanner.nextDouble();
                scanner.nextLine(); // clear newline
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
        return value;
    }
}
