import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Student class encapsulating student details and grades
class Student {
    private String name;
    private String studentId;
    private ArrayList<Double> grades;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.grades = new ArrayList<>();
    }

    // Add a grade to the student's record
    public void addGrade(double grade) {
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
        } else {
            System.out.println("Invalid grade. Please enter a value between 0 and 100.");
        }
    }

    // Calculate the average grade of the student
    public double getAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "Student Name: " + name + " | ID: " + studentId + " | Average Grade: " + String.format("%.2f", getAverage());
    }
}

// GradeManager class to manage multiple student records
class GradeManager {
    private ArrayList<Student> students = new ArrayList<>();

    // Add a new student record
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    // Find a student by student ID
    public Student findStudent(String studentId) {
        for (Student s : students) {
            if (s.getStudentId().equals(studentId))
                return s;
        }
        System.out.println("Student not found.");
        return null;
    }

    // Calculate the overall class average
    public double getClassAverage() {
        if (students.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        int count = 0;
        for (Student s : students) {
            sum += s.getAverage();
            count++;
        }
        return (count > 0) ? sum / count : 0.0;
    }

    // List all student records
    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }
}

public class StudentGradeManagement {
    private static GradeManager gradeManager = new GradeManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        System.out.println("Welcome to the Student Grade Management System!");
        do {
            displayMenu();
            choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    addGradeToStudent();
                    break;
                case 3:
                    displayStudentRecord();
                    break;
                case 4:
                    displayClassAverage();
                    break;
                case 5:
                    gradeManager.listStudents();
                    break;
                case 6:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select from the menu.");
            }
        } while (choice != 6);
        scanner.close();
    }

    // Display menu options for grade management
    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add New Student");
        System.out.println("2. Add Grade to Student");
        System.out.println("3. Display Student Record");
        System.out.println("4. Display Class Average");
        System.out.println("5. List All Students");
        System.out.println("6. Exit");
    }

    // Add a new student record
    private static void addNewStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = new Student(name, studentId);
        gradeManager.addStudent(student);
    }

    // Add a grade to an existing student
    private static void addGradeToStudent() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = gradeManager.findStudent(studentId);
        if (student != null) {
            double grade = getDoubleInput("Enter grade (0-100): ");
            student.addGrade(grade);
            System.out.println("Grade added successfully.");
        }
    }

    // Display a specific student's record
    private static void displayStudentRecord() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = gradeManager.findStudent(studentId);
        if (student != null) {
            System.out.println(student);
        }
    }

    // Display overall class average
    private static void displayClassAverage() {
        double classAvg = gradeManager.getClassAverage();
        System.out.println("Class Average: " + String.format("%.2f", classAvg));
    }

    // Get integer input with validation
    private static int getIntInput(String prompt) {
        int value = 0;
        while (true) {
            System.out.print(prompt);
            try {
                value = scanner.nextInt();
                scanner.nextLine(); // Clear newline
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
                scanner.nextLine(); // Clear newline
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
        return value;
    }
}
