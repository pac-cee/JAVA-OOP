import java.util.InputMismatchException;
import java.util.Scanner;

 public class Main {
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean continueProgram = true;
            
            while (continueProgram) {
                try {
                    Student student = new Student();
                    
                    // 1. Get student ID
                    boolean validId = false;
                    while (!validId) {
                        try {
                            System.out.print("Enter Student ID (positive integer): ");
                            int id = scanner.nextInt();
                            scanner.nextLine(); // consume newline
                            student.setStudentId(id);
                            validId = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Please enter a valid integer.");
                            scanner.nextLine(); // consume invalid input
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    
                    // 2. Get student name
                    boolean validName = false;
                    while (!validName) {
                        try {
                            System.out.print("Enter Student Name: ");
                            String name = scanner.nextLine();
                            student.setStudentName(name);
                            validName = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Please enter a valid Name .");
                            scanner.nextLine(); // consume invalid input
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    
                    // 3. Get program
                    boolean validProgram = false;
                    while (!validProgram) {
                        try {
                            System.out.print("Enter Program (Undergraduate/Postgraduate): ");
                            String program = scanner.nextLine();
                            student.setProgram(program);
                            validProgram = true;
                        }catch (InputMismatchException e) {
                            System.out.println("Error: Please enter a valid program.");
                            scanner.nextLine(); // consume invalid input
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    
                    // 4. Get previous qualification
                    boolean validQualification = false;
                    while (!validQualification) {
                        try {
                            System.out.print("Enter Previous Qualification  for undergraduate(A-level , equivalent)and postgraduate(Bachelor's degree in Finance /Bachelor's degree in Accounting) : ");
                            String qualification = scanner.nextLine();
                            if (qualification == null || qualification.trim().isEmpty()) {
                                throw new IllegalArgumentException("Previous qualification cannot be empty");
                            }
                            student.setPreviousQualification(qualification);
                            validQualification = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Please enter a valid Previous Qualification.");
                            scanner.nextLine(); // consume invalid input
                        }  catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    
                    // Create required objects
                    StudentRegistration registration = new StudentRegistration(student);
                    RegistrationFees fees = new RegistrationFees(student);
                    DepartmentAllocation department = new DepartmentAllocation(student);
                    
                    // Step 1: Register the student

                    System.out.println("\n=== STUDENT REGISTRATION ===");
                    boolean registrationSuccess = registration.registerStudent();
                    
                    if (registrationSuccess) {

                        // Step 2: Process payment
                        System.out.println("\n=== PAYMENT PROCESSING ===");
                        boolean paymentSuccess = false;
                        while (!paymentSuccess) {
                            try {
                                System.out.print("Enter Payment Amount: ");
                                double payment = scanner.nextDouble();
                                scanner.nextLine(); // consume newline
                                paymentSuccess = fees.payFees(payment);
                                if (!paymentSuccess) {
                                    System.out.print("Would you like to try payment again? (yes/no): ");
                                    String retry = scanner.nextLine();
                                    if (!retry.equalsIgnoreCase("yes")) {
                                        break;
                                    }
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Error: Please enter a valid payment amount.");
                                scanner.nextLine(); // consume invalid input
                            }
                        }
                        
                        if (paymentSuccess) {
                            // Step 3: Allocate department
                            System.out.println("\n=== DEPARTMENT ALLOCATION ===");
                            if (student.getProgram().equalsIgnoreCase("Undergraduate")) {
                                System.out.println("Available departments: Software Engineering, Networking, Information Management");
                            } else {
                                System.out.println("Available departments: Big Data, Project Management, Accounting");
                            }
                            
                            boolean departmentAllocated = false;
                            while (!departmentAllocated) {
                                System.out.print("Enter Department Choice: ");
                                String deptChoice = scanner.nextLine();
                                departmentAllocated = department.allocateDepartment(deptChoice);
                                
                                if (!departmentAllocated) {
                                    System.out.print("Would you like to try another department? (yes/no): ");
                                    String retry = scanner.nextLine();
                                    if (!retry.equalsIgnoreCase("yes")) {
                                        break;
                                    }
                                }
                            }
                            
                            if (departmentAllocated) {
                                System.out.println("\n=== REGISTRATION COMPLETE ===");
                                System.out.println("Student ID: " + student.getStudentId());
                                System.out.println("Name: " + student.getStudentName());
                                System.out.println("Program: " + student.getProgram());
                                System.out.println("Department: " + student.getDepartment());
                                System.out.println("Registration Status: Confirmed");
                            }
                        }
                    }
                    
                    System.out.print("\nWould you like to register another student? (yes/no): ");
                    String continueChoice = scanner.nextLine();
                    continueProgram = continueChoice.equalsIgnoreCase("yes");
                    
                } catch (Exception e) {
                    System.out.println("An unexpected error occurred: " + e.getMessage());
                    scanner.nextLine(); // Consume any remaining input
                }
            }
            
            System.out.println("Thank you for using the Student Registration System!");
        }
    }
}
