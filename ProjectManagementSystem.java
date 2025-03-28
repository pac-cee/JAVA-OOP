import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Comprehensive OOP Demonstration: Project Management System
 * 
 * This file showcases Object-Oriented Programming concepts in Java
 * through a realistic project management application.
 * 
 * OOP Concepts Covered:
 * 1. Classes and Objects
 * 2. Encapsulation
 * 3. Inheritance
 * 4. Polymorphism
 * 5. Abstraction
 * 6. Interfaces
 * 7. Composition
 * 8. Enum Usage
 * 9. Exception Handling
 * 10. Generics
 */
public class ProjectManagementSystem {

    /**
     * Enum to represent different project statuses
     * Demonstrates use of Enum for predefined, limited set of values
     */
    public enum ProjectStatus {
        PLANNING, 
        IN_PROGRESS, 
        ON_HOLD, 
        COMPLETED, 
        CANCELLED
    }

    /**
     * Abstract base class demonstrating abstraction
     * Shows common properties and behaviors for all human resources
     */
    public abstract static class HumanResource {
        // Encapsulation: private fields with public getters/setters
        private String id;
        private String name;
        private String email;

        // Constructor
        public HumanResource(String name, String email) {
            this.id = UUID.randomUUID().toString();
            this.name = name;
            this.email = email;
        }

        // Abstract method: each subclass must implement
        public abstract double calculateCompensation();

        // Getters and Setters (Encapsulation)
        public String getId() { return id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    }

    /**
     * Inheritance: Specific type of HumanResource
     * Shows how to extend and specialize base classes
     */
    public static class Employee extends HumanResource {
        private double baseSalary;
        private String department;

        public Employee(String name, String email, double baseSalary, String department) {
            super(name, email);
            this.baseSalary = baseSalary;
            this.department = department;
        }

        // Polymorphism: Overriding the abstract method
        @Override
        public double calculateCompensation() {
            return baseSalary;
        }

        public String getDepartment() { return department; }
    }

    /**
     * Inheritance: Another type of HumanResource
     * Demonstrates different implementation of the same abstract method
     */
    public static class Contractor extends HumanResource {
        private double hourlyRate;
        private int hoursWorked;

        public Contractor(String name, String email, double hourlyRate) {
            super(name, email);
            this.hourlyRate = hourlyRate;
        }

        // Polymorphic method with different implementation
        @Override
        public double calculateCompensation() {
            return hourlyRate * hoursWorked;
        }

        public void setHoursWorked(int hours) { this.hoursWorked = hours; }
    }

    /**
     * Interface demonstrating contract-based programming
     * Shows how to define a contract that classes must follow
     */
    public interface Billable {
        double calculateBillingAmount();
        void applyDiscount(double discountPercentage);
    }

    /**
     * Main Project class demonstrating composition and complex relationships
     * Shows how objects can contain other objects
     */
    public static class Project implements Billable {
        // Composition: Project contains multiple objects
        private String projectName;
        private ProjectStatus status;
        private List<Employee> teamMembers;
        private List<Task> tasks;
        private double totalBudget;

        // Constructor with composition
        public Project(String projectName, double initialBudget) {
            this.projectName = projectName;
            this.status = ProjectStatus.PLANNING;
            this.teamMembers = new ArrayList<>();
            this.tasks = new ArrayList<>();
            this.totalBudget = initialBudget;
        }

        // Methods demonstrating object interactions
        public void addTeamMember(Employee employee) {
            // Prevents duplicate team members
            if (!teamMembers.contains(employee)) {
                teamMembers.add(employee);
            }
        }

        public void addTask(Task task) {
            tasks.add(task);
        }

        // Billable interface implementation
        @Override
        public double calculateBillingAmount() {
            return totalBudget;
        }

        @Override
        public void applyDiscount(double discountPercentage) {
            this.totalBudget *= (1 - discountPercentage);
        }
    }

    /**
     * Generic Task class demonstrating generics and type safety
     */
    public static class Task<T extends HumanResource> {
        private String description;
        private T assignedResource;
        private Date deadline;
        private boolean completed;

        public Task(String description, T assignedResource, Date deadline) {
            this.description = description;
            this.assignedResource = assignedResource;
            this.deadline = deadline;
            this.completed = false;
        }

        // Getter that uses generics
        public T getAssignedResource() {
            return assignedResource;
        }

        public void markCompleted() {
            this.completed = true;
        }
    }

    /**
     * Custom Exception for demonstrating exception handling
     */
    public static class ProjectManagementException extends Exception {
        public ProjectManagementException(String message) {
            super(message);
        }
    }

    /**
     * Main method to demonstrate usage of all OOP concepts
     */
    public static void main(String[] args) {
        try {
            // Creating objects and demonstrating OOP principles
            Employee projectManager = new Employee(
                "John Doe", 
                "john.doe@company.com", 
                75000, 
                "Project Management"
            );

            Contractor designer = new Contractor(
                "Jane Smith", 
                "jane.smith@freelance.com", 
                50
            );
            designer.setHoursWorked(40);

            // Create a project
            Project webAppProject = new Project("Enterprise Web App", 100000);
            
            // Add team members
            webAppProject.addTeamMember(projectManager);

            // Create and assign tasks
            Task<Employee> managerTask = new Task<>(
                "Create Project Plan", 
                projectManager, 
                new Date()
            );
            webAppProject.addTask(managerTask);

            // Demonstrate polymorphic compensation calculation
            System.out.println("Project Manager Compensation: $" + 
                projectManager.calculateCompensation());
            System.out.println("Contractor Compensation: $" + 
                designer.calculateCompensation());

            // Demonstrate billing and discounts
            System.out.println("Initial Project Budget: $" + 
                webAppProject.calculateBillingAmount());
            webAppProject.applyDiscount(0.1);
            System.out.println("Discounted Project Budget: $" + 
                webAppProject.calculateBillingAmount());

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}