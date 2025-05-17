package main;

import abstracts.StudentManagement;
import foreign.ForeignStudent;
import informationmanagement.InformationManagementStudent;
import java.util.Scanner;
import networking.NetworkingStudent;
import softwareengineering.SoftwareEngineeringStudent;
import utils.DateUtils;
import utils.ValidationUtils;

public class StudentRegistrationSystem {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Student Registration System ===");
            System.out.println("1. Register Software Engineering Student");
            System.out.println("2. Register Networking Student");
            System.out.println("3. Register Information Management Student");
            System.out.println("4. Register Foreign Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 5) {
                System.out.println("Thank you for using the system!");
                break;
            }

            StudentManagement student = createStudent(choice);
            if (student != null) {
                if (captureStudentDetails(student)) {
                    System.out.println("\nRegistration successful!");
                    displayStudentDetails(student);
                } else {
                    System.out.println("\nRegistration failed due to validation errors!");
                }
            }
        }
        scanner.close();
    }

    private static StudentManagement createStudent(int choice) {
        switch (choice) {
            case 1:
                return new SoftwareEngineeringStudent();
            case 2:
                return new NetworkingStudent();
            case 3:
                return new InformationManagementStudent();
            case 4:
                return new ForeignStudent();
            default:
                System.out.println("Invalid choice!");
                return null;
        }
    }

    private static boolean captureStudentDetails(StudentManagement student) {
        // Capture Student ID
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        if (!ValidationUtils.isStudentIdUnique(studentId)) {
            System.out.println("Error: Student ID must be unique!");
            return false;
        }
        student.studentId = studentId;

        // Capture Full Name
        System.out.print("Enter Full Name: ");
        String fullName = scanner.nextLine();
        if (!ValidationUtils.isNameValid(fullName)) {
            System.out.println("Error: Name must contain only letters!");
            return false;
        }
        student.fullName = fullName;

        // Capture Date of Birth
        System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
        String dob = scanner.nextLine().trim();
        // Ensure proper date format
        if (!dob.matches("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.println("Error: Date must be in yyyy-MM-dd format (e.g., 2000-03-16)");
            return false;
        }
        student.dateOfBirth = dob;
        if (!student.validateAge()) {
            System.out.println("Error: Age must be above 18!");
            return false;
        }

        // Capture Nationality
        System.out.print("Enter Nationality: ");
        student.nationality = scanner.nextLine();
        if (student.nationality.trim().isEmpty()) {
            System.out.println("Error: Nationality is required!");
            return false;
        }

        // Capture Combination
        System.out.print("Enter Combination (mpc/mpg/mce/meg): ");
        student.combination = scanner.nextLine();
        if (!student.validateCombination()) {
            System.out.println("Error: Invalid combination for this department!");
            return false;
        }

        // Capture Marks
        System.out.print("Enter Final Senior Six Marks (0-100): ");
        student.marks = scanner.nextInt();
        scanner.nextLine(); 
        if (!student.validateMarks()) {
            System.out.println("Error: Invalid marks for this department!");
            return false;
        }

        // Capture Registration Date
        System.out.print("Enter Registration Date (yyyy-MM-dd): ");
        String regDate = scanner.nextLine();
        if (!DateUtils.isRegistrationDay(regDate)) {
            System.out.println("Error: Registration is only allowed on Monday or Friday!");
            return false;
        }
        student.registrationDate = regDate;

        // Capture School Name
        System.out.print("Enter School Name: ");
        student.schoolName = scanner.nextLine();

        // Capture Foreign Student Status
        System.out.print("Is this a foreign student? (true/false): ");
        student.isForeignStudent = scanner.nextBoolean();
        scanner.nextLine(); 

        // Calculate and Capture Registration Fee
        double fee = student.calculateRegistrationFee();
        System.out.printf("Registration Fee: %.2f\n", fee);
        System.out.print("Enter Amount Paid: ");
        student.registrationFeePaid = scanner.nextDouble();
        scanner.nextLine(); 

        if (student.registrationFeePaid < fee) {
            System.out.println("Error: Insufficient payment!");
            return false;
        }

        return true;
    }

    private static void displayStudentDetails(StudentManagement student) {
        System.out.println("\n==========================================");
        System.out.println("           STUDENT REGISTRATION DETAILS");
        System.out.println("==========================================");
        
        // Personal Information
        System.out.println("\n--- Personal Information ---");
        System.out.println("Student ID: " + student.studentId);
        System.out.println("Full Name: " + student.fullName);
        System.out.println("Date of Birth: " + student.dateOfBirth);
        System.out.println("Age: " + DateUtils.getAgeFromDOB(student.dateOfBirth) + " years");
        System.out.println("Nationality: " + student.nationality);
        
        // Academic Information
        System.out.println("\n--- Academic Information ---");
        System.out.println("Department: " + student.getClass().getSimpleName());
        System.out.println("Combination: " + student.combination.toUpperCase());
        System.out.println("Final Senior Six Marks: " + student.marks);
        System.out.println("School Name: " + student.schoolName);
        
        // Registration Information
        System.out.println("\n--- Registration Information ---");
        System.out.println("Registration Date: " + student.registrationDate);
        System.out.println("Registration Day: " + DateUtils.getDayOfWeek(student.registrationDate));
        System.out.println("Student Type: " + (student.isForeignStudent ? "Foreign Student" : "Local Student"));
        
        // Financial Information
        System.out.println("\n--- Financial Information ---");
        double baseFee = student.calculateRegistrationFee() / (student.isForeignStudent ? 0.9 : 1.0);
        System.out.printf("Base Registration Fee: %.2f\n", baseFee);
        if (student.isForeignStudent) {
            System.out.printf("Foreign Student Discount (10%%): %.2f\n", baseFee * 0.1);
        }
        System.out.printf("Final Registration Fee: %.2f\n", student.calculateRegistrationFee());
        System.out.printf("Amount Paid: %.2f\n", student.registrationFeePaid);
        System.out.printf("Balance: %.2f\n", student.registrationFeePaid - student.calculateRegistrationFee());
        
        System.out.println("\n==========================================");
        System.out.println("           REGISTRATION COMPLETE");
        System.out.println("==========================================");
    }
} 