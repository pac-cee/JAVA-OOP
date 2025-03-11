package ClassWork;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// A simple class representing a Student
class Student {
    // Encapsulated attributes
    private  String name;
    private  int age;
    
    // Constructor to initialize a Student object
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Getter methods to access private attributes
    public String getName() {
        return this.name;
    }
    
    public int getAge() {
        return this.age;
    }
    // Setter methods
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }
    
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
    
    // Overriding toString() method for easy printing of student details
    @Override
    public String toString() {
        return "Student Name: " + name + ", Age: " + age;
    }
}

public class Learn2 {
    // Main method to run the program
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        // ArrayList to store multiple Student objects (records)
        ArrayList<Student> students = new ArrayList<>();
        
        // Get the number of records to input
        System.out.print("Enter the number of students: ");
        int numStudents = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    numStudents = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    if(numStudents <= 0) {
                        throw new IllegalArgumentException("The number of students must be positive.");
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.print("Invalid input. Please enter an integer value: ");
                    scanner.nextLine(); // Clear the buffer
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    System.out.print("Enter a valid number of students: ");
                    scanner.nextLine();
                }
            }
            
            // Loop to input each student's details
            for (int i = 0; i < numStudents; i++) {
                System.out.println("\nEntering details for student " + (i + 1));
                
                // Input student's name
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                
                // Input student's age with error checking and retry mechanism
                int age = 0;
                while (true) {
                    System.out.print("Enter age: ");
                    try {
                        age = scanner.nextInt();
                        scanner.nextLine(); // Clear the newline
                        if (age < 0) {
                            throw new IllegalArgumentException("Age cannot be negative. Please try again.");
                        }
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter an integer for age.");
                        scanner.nextLine(); // Clear the buffer
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        scanner.nextLine();
                    }
                }
                
                // Create a new Student object using the constructor and add it to the list
                Student student = new Student(name, age);
                students.add(student);
            }
        }
        
        // Display all student records
        System.out.println("\n--- Student Details ---");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}