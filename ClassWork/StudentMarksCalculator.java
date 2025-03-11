package ClassWork;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentMarksCalculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<String> courseNames = new ArrayList<>();
            ArrayList<Double> courseMarks = new ArrayList<>();

            System.out.println("Student Marks Calculator");
            System.out.println("------------------------");

            int numCourses = 0;
            boolean validInput = false;
            
            // Read the number of courses (must be between 1 and 6)
            while (!validInput) {
                try {
                    System.out.print("Enter the number of courses (max 6): ");
                    numCourses = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    
                    if (numCourses <= 0 || numCourses > 6) {
                        System.out.println("Error: Number of courses must be greater than 0 and less than or equal to 6. Please try again.");
                    } else {
                        validInput = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Please enter a valid integer for the number of courses.");
                    scanner.nextLine(); // Clear invalid input
                }
            }
            
            // For each course, validate course name and mark.
            for (int i = 0; i < numCourses; i++) {
                String courseName = getValidCourseName(scanner, courseNames);
                courseNames.add(courseName);
                
                double mark = getValidMark(scanner, courseName);
                courseMarks.add(mark);
            }
            
            // Calculate average mark.
            double sum = 0;
            for (Double mark : courseMarks) {
                sum += mark;
            }
            double average = sum / courseMarks.size();
            
            System.out.println("\nResults:");
            System.out.println("--------");
            System.out.printf("Average mark: %.2f\n", average);
            
            System.out.println("\nCourses above average:");
            boolean foundAboveAverage = false;
            for (int i = 0; i < courseNames.size(); i++) {
                if (courseMarks.get(i) > average) {
                    System.out.printf("- %s: %.2f\n", courseNames.get(i), courseMarks.get(i));
                    foundAboveAverage = true;
                }
            }
            
            if (!foundAboveAverage) {
                System.out.println("No courses are above the average.");
            }
        }
    }
    
    /**
     * Prompts the user for a valid course name.
     * The course must be one of the allowed courses and must not have been entered before.
     * @param scanner the Scanner for input.
     * @param chosenCourses a list of courses already chosen.
     * @return a valid course name.
     */
    private static String getValidCourseName(Scanner scanner, ArrayList<String> chosenCourses) {
        String[] allowedCourses = {"Networks", "C", "Java", "OOP", "Math", "C++"};
        
        while (true) {
            System.out.print("Enter the name of course " + (chosenCourses.size() + 1) + ": ");
            String inputCourse = scanner.nextLine().trim();
            
            // Check if the course is one of the allowed ones (ignoring case)
            String validCourse = null;
            for (String allowed : allowedCourses) {
                if (allowed.equalsIgnoreCase(inputCourse)) {
                    validCourse = allowed; // Normalize the course name
                    break;
                }
            }
            if (validCourse == null) {
                System.out.println("Error: Invalid course name. Allowed courses are: Networks, C, Java, OOP, Math, C++.");
                continue;
            }
            // Check if the course has already been entered
            if (chosenCourses.contains(validCourse)) {
                System.out.println("Error: Course already entered. Please choose a different course.");
                continue;
            }
            return validCourse;
        }
    }
    
    /**
     * Prompts the user to enter a valid mark for a course.
     * The mark must be a number between 0 and 100.
     * @param scanner the Scanner for input.
     * @param courseName the name of the course.
     * @return a valid mark as a double.
     */
    private static double getValidMark(Scanner scanner, String courseName) {
        double mark = 0;
        boolean validMark = false;
        
        while (!validMark) {
            try {
                System.out.print("Enter mark for " + courseName + " (0-100): ");
                mark = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                
                if (mark < 0 || mark > 100) {
                    System.out.println("Error: Mark should be between 0 and 100. Please try again.");
                } else {
                    validMark = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number for the mark.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        
        return mark;
    }
}
