package classwork;
/*
 * public class Learn {
   Let's break down each topic with explanations and examples, followed by a comprehensive example combining all concepts with best practices.
    
    ### 1. Using Scanner in Java
    *Purpose*: Read user input from the console.  
    *Best Practices*:
    - Always close the Scanner to prevent resource leaks.
    - Handle different data types (e.g., nextInt(), nextLine()).
    - Clear the buffer after reading numeric values to avoid input mishaps.
    
    java
    import java.util.Scanner;
    
    public class ScannerExample {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Enter your name: ");
            String name = scanner.nextLine(); // Reads entire line
            
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consumes leftover newline
            
            scanner.close();
            System.out.println(name + " is " + age + " years old.");
        }
    }
    
    
    ---
    
    ### 2. Inputting Multiple Records
    *Approach*: Use loops (e.g., while) and collections (e.g., ArrayList) to store multiple objects.  
    *Best Practices*:
    - Prompt the user to continue/exit after each entry.
    - Separate input logic from business logic.
    
    java
    import java.util.ArrayList;
    import java.util.Scanner;
    
    public class MultipleRecords {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            ArrayList<String> names = new ArrayList<>();
            boolean addMore = true;
    
            while (addMore) {
                System.out.print("Enter a name: ");
                names.add(scanner.nextLine());
    
                System.out.print("Add another? (yes/no): ");
                String response = scanner.nextLine().trim().toLowerCase();
                addMore = response.equals("yes");
            }
    
            scanner.close();
            System.out.println("Names: " + names);
        }
    }
    
    
    ---
    
    ### 3. Retry on Invalid Input
    *Approach*: Use try-catch blocks and loops to validate input.  
    *Best Practices*:
    - Handle InputMismatchException for type mismatches.
    - Clear invalid input with scanner.nextLine() in catch blocks.
    
    java
    import java.util.InputMismatchException;
    import java.util.Scanner;
    
    public class RetryInput {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int age = 0;
            boolean valid = false;
    
            while (!valid) {
                try {
                    System.out.print("Enter age: ");
                    age = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    valid = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Clear invalid input
                }
            }
    
            scanner.close();
            System.out.println("Age: " + age);
        }
    }
    
    
    ---
    
    ### 4. OOP: Objects, Methods, Constructors, Encapsulation
    *Key Concepts*:
    - *Encapsulation*: Use private fields with public getters/setters.
    - *Constructors*: Initialize objects with valid states.
    - *Methods*: Define behaviors for objects.
    
    *Example Class*:
    java
    public class Student {
        private String name;
        private int age;
    
        // Constructor
        public Student(String name, int age) {
            setName(name);
            setAge(age); // Use setters for validation
        }
    
        // Getters and Setters (Encapsulation)
        public String getName() { return name; }
        public void setName(String name) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty.");
            }
            this.name = name.trim();
        }
    
        public int getAge() { return age; }
        public void setAge(int age) {
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative.");
            }
            this.age = age;
        }
    }
    
    
    ---
    
    ### Comprehensive Example: Combining All Concepts
    java
    import java.util.ArrayList;
    import java.util.Scanner;
    import java.util.InputMismatchException;
    
    public class StudentManager {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            ArrayList<Student> students = new ArrayList<>();
            boolean addMore = true;
    
            while (addMore) {
                try {
                    String name = getName(scanner);
                    int age = getAge(scanner);
                    students.add(new Student(name, age));
    
                    System.out.print("Add another student? (yes/no): ");
                    addMore = scanner.nextLine().trim().equalsIgnoreCase("yes");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
    
            scanner.close();
            System.out.println("\nRegistered Students:");
            for (Student s : students) {
                System.out.println(s.getName() + " - " + s.getAge());
            }
        }
    
        // Helper method to get valid name
        private static String getName(Scanner scanner) {
            while (true) {
                System.out.print("Enter student name: ");
                String name = scanner.nextLine().trim();
                if (!name.isEmpty()) return name;
                System.out.println("Name cannot be empty. Try again.");
            }
        }
    
        // Helper method to get valid age
        private static int getAge(Scanner scanner) {
            while (true) {
                try {
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    if (age >= 0) return age;
                    System.out.println("Age cannot be negative. Try again.");
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Enter a number.");
                    scanner.nextLine(); // Clear invalid input
                }
            }
        }
    }
    
    
    ---
    
    *Best Practices Highlighted*:
    1. *Encapsulation*: Student class uses private fields with validation in setters.
    2. *Input Validation*: Helper methods (getName, getAge) retry on invalid input.
    3. *Resource Management*: Scanner is closed after use.
    4. *Separation of Concerns*: Input logic is separated into helper methods.
    5. *Error Handling*: try-catch blocks handle type mismatches and business rule violations.
    
    This approach ensures clean, maintainable code that adheres to OOP principles and handles user input robustly.
}

import java.security.Key;


 */