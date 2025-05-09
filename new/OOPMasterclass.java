/**
 * OOPMasterclass.java - A comprehensive guide to Object-Oriented Programming in Java
 * 
 * This file demonstrates the core concepts of OOP using a University Management System example:
 * 1. Classes and Objects
 * 2. Inheritance
 * 3. Encapsulation
 * 4. Polymorphism
 * 5. Abstraction
 * 6. Interfaces
 * 7. Access Modifiers
 * 8. Constructors and method overloading
 * 9. Static members
 * 10. Final keyword
 */

// The main class that contains the entry point of our program
public class OOPMasterclass {
    
    // The main method - the entry point of our Java application
    public static void main(String[] args) {
        System.out.println("===== OBJECT-ORIENTED PROGRAMMING MASTERCLASS =====\n");
        
        // Demonstrating object creation and method calls
        demonstrateBasicOOP();
        
        // Demonstrating inheritance and polymorphism
        demonstrateInheritanceAndPolymorphism();
        
        // Demonstrating interfaces and abstraction
        demonstrateInterfacesAndAbstraction();
        
        // Demonstrating additional OOP concepts
        demonstrateAdditionalConcepts();
    }
    
    // Method to demonstrate basic OOP concepts like classes, objects, and encapsulation
    private static void demonstrateBasicOOP() {
        System.out.println("\n----- CLASSES, OBJECTS, AND ENCAPSULATION -----");
        
        // Creating objects (instances of the Student class)
        // This demonstrates object instantiation using constructors
        Student student1 = new Student(1001, "Alice Johnson", 20);
        Student student2 = new Student(1002, "Bob Smith", 22);
        
        // Accessing object properties via getter methods (encapsulation)
        System.out.println("Student 1: " + student1.getName() + " (ID: " + student1.getId() + ")");
        System.out.println("Student 2: " + student2.getName() + " (ID: " + student2.getId() + ")");
        
        // Modifying object state via setter methods (encapsulation)
        student1.setAge(21);
        System.out.println("Updated age of " + student1.getName() + ": " + student1.getAge());
        
        // This would cause an error due to encapsulation (private fields)
        // student1.age = 25; // Compilation error - age is private
        
        // Creating a Course object
        Course javaCourse = new Course("CS101", "Introduction to Java", 3);
        
        // Enrolling students in the course
        student1.enrollInCourse(javaCourse);
        student2.enrollInCourse(javaCourse);
        
        // Display enrolled students
        javaCourse.displayEnrolledStudents();
    }
    
    // Method to demonstrate inheritance and polymorphism
    private static void demonstrateInheritanceAndPolymorphism() {
        System.out.println("\n----- INHERITANCE AND POLYMORPHISM -----");
        
        // Creating objects of different classes in the inheritance hierarchy
        Person person = new Person("John Doe", 30);
        Student student = new Student(2001, "Jane Wilson", 19);
        Professor professor = new Professor(3001, "Dr. Robert Brown", 45, "Computer Science");
        
        // Calling methods - demonstrating method inheritance
        System.out.println("Person details: " + person.getDetails());
        System.out.println("Student details: " + student.getDetails()); // Overridden method
        System.out.println("Professor details: " + professor.getDetails()); // Overridden method
        
        // Polymorphism - treating different object types as their common supertype
        System.out.println("\nDemonstrating Polymorphism:");
        Person[] people = new Person[3];
        people[0] = person;     // Person object
        people[1] = student;    // Student is-a Person
        people[2] = professor;  // Professor is-a Person
        
        // Polymorphic method calls - the actual method executed depends on the object's type
        for (Person p : people) {
            System.out.println(p.getDetails()); // Calls the appropriate overridden version
        }
    }
    
    // Method to demonstrate interfaces and abstraction
    private static void demonstrateInterfacesAndAbstraction() {
        System.out.println("\n----- INTERFACES AND ABSTRACTION -----");
        
        // Creating objects that implement interfaces
        Student gradStudent = new GraduateStudent(4001, "Emily Davis", 24, "Artificial Intelligence");
        Professor adjunctProf = new AdjunctProfessor(5001, "Dr. Michael Wilson", 38, "Mathematics");
        
        // Using abstract class
        System.out.println("\nAbstract Classes:");
        // UniversityMember member = new UniversityMember(); // Error: Cannot instantiate abstract class
        UniversityMember student = new Student(6001, "Grace Lee", 20);
        System.out.println(student.getDetails());
        System.out.println("ID Card Number: " + student.generateIdCardNumber());
        
        // Using interfaces
        System.out.println("\nInterfaces:");
        printResearchActivities(gradStudent);
        printResearchActivities(adjunctProf);
        
        // Demonstrating default methods in interfaces
        System.out.println("\nInterface default methods:");
        System.out.println("Graduate Student: " + gradStudent.getResearchStatus());
        System.out.println("Adjunct Professor: " + adjunctProf.getResearchStatus());
    }
    
    // Helper method that works with the Researcher interface (showing interface as a type)
    private static void printResearchActivities(Researcher researcher) {
        System.out.println("Research focus: " + researcher.getResearchFocus());
        System.out.println("Publication count: " + researcher.getPublicationCount());
    }
    
    // Method to demonstrate additional OOP concepts
    private static void demonstrateAdditionalConcepts() {
        System.out.println("\n----- ADDITIONAL OOP CONCEPTS -----");
        
        // Static members
        System.out.println("\nStatic Members:");
        System.out.println("University Name: " + University.universityName);
        System.out.println("Student Count: " + University.getStudentCount());
        University.addStudent();
        System.out.println("Updated Student Count: " + University.getStudentCount());
        
        // Final keyword
        System.out.println("\nFinal Keyword:");
        final Student finalStudent = new Student(7001, "Tom Harris", 21);
        // finalStudent = new Student(7002, "Jerry Lewis", 22); // Error: Cannot reassign a final variable
        
        // But we can modify the object's state
        finalStudent.setAge(22);
        System.out.println("Final student's age updated: " + finalStudent.getAge());
        
        // Composition
        System.out.println("\nComposition:");
        Department csDepartment = new Department("Computer Science");
        csDepartment.addProfessor(new Professor(8001, "Dr. Lisa Chen", 40, "Software Engineering"));
        csDepartment.addProfessor(new Professor(8002, "Dr. David Wang", 55, "Algorithms"));
        System.out.println("Department: " + csDepartment.getName());
        System.out.println("Number of professors: " + csDepartment.getProfessorCount());
    }
}

/**
 * CLASSES AND OBJECTS
 * 
 * A class is a blueprint or template for creating objects.
 * An object is an instance of a class.
 */

// A utility class with static members
class University {
    // Static field - shared across all instances
    public static final String universityName = "OOP University";
    
    // Private static field - encapsulated but shared
    private static int studentCount = 0;
    
    // Static method
    public static int getStudentCount() {
        return studentCount;
    }
    
    // Static method that modifies static state
    public static void addStudent() {
        studentCount++;
    }
}

/**
 * ABSTRACTION
 * 
 * Abstract classes cannot be instantiated and may contain abstract methods
 * (methods without a body) that must be implemented by concrete subclasses.
 */
abstract class UniversityMember {
    protected String name;
    protected int age;
    
    // Constructor in abstract class
    public UniversityMember(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Concrete method in abstract class
    public String getName() {
        return name;
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract String getDetails();
    
    // Template method pattern - concrete implementation that uses abstract method
    public String generateIdCardNumber() {
        return "ID-" + name.charAt(0) + age + "-" + System.currentTimeMillis() % 1000;
    }
}

/**
 * INHERITANCE
 * 
 * Inheritance allows a class to inherit the properties and methods of another class.
 * The class that inherits is called a subclass, and the class that is inherited from is called a superclass.
 */
class Person extends UniversityMember {
    // Constructor
    public Person(String name, int age) {
        super(name, age); // Call to superclass constructor
    }
    
    // Implementation of abstract method
    @Override
    public String getDetails() {
        return "Person: " + name + ", Age: " + age;
    }
}

/**
 * INTERFACES
 * 
 * Interfaces define a contract that implementing classes must fulfill.
 * They can contain method signatures, default methods, and constants.
 */
interface Researcher {
    // Constant (public static final by default)
    int MIN_PUBLICATIONS = 1;
    
    // Abstract method (public abstract by default)
    String getResearchFocus();
    
    // Abstract method
    int getPublicationCount();
    
    // Default method - has implementation and can be overridden
    default String getResearchStatus() {
        int pubs = getPublicationCount();
        if (pubs < MIN_PUBLICATIONS) {
            return "Needs more publications";
        } else {
            return "Active researcher";
        }
    }
}

/**
 * ENCAPSULATION
 * 
 * Encapsulation is the bundling of data and the methods that act on that data,
 * restricting direct access to some of the object's components.
 */
class Student extends Person {
    // Private fields - encapsulated, not directly accessible from outside
    private int id;
    private Course[] enrolledCourses;
    private int courseCount;
    
    // Constructor
    public Student(int id, String name, int age) {
        super(name, age); // Call to superclass constructor
        this.id = id;
        this.enrolledCourses = new Course[10]; // Can enroll in up to 10 courses
        this.courseCount = 0;
        University.addStudent(); // Update static counter
    }
    
    // Getter method - part of encapsulation
    public int getId() {
        return id;
    }
    
    // Getter method
    public int getAge() {
        return age;
    }
    
    // Setter method - part of encapsulation
    public void setAge(int age) {
        if (age > 0) { // Validation logic
            this.age = age;
        }
    }
    
    // Method to enroll student in a course
    public void enrollInCourse(Course course) {
        if (courseCount < enrolledCourses.length) {
            enrolledCourses[courseCount++] = course;
            course.addStudent(this);
            System.out.println(name + " enrolled in " + course.getTitle());
        } else {
            System.out.println("Cannot enroll in more courses!");
        }
    }
    
    // Method overriding - implementing a method differently than in the superclass
    @Override
    public String getDetails() {
        return "Student: " + name + ", ID: " + id + ", Age: " + age;
    }
}

/**
 * INHERITANCE & INTERFACES
 * 
 * A class can extend only one class but implement multiple interfaces.
 */
class GraduateStudent extends Student implements Researcher {
    private String researchTopic;
    private int publicationCount;
    
    // Constructor
    public GraduateStudent(int id, String name, int age, String researchTopic) {
        super(id, name, age); // Call to superclass constructor
        this.researchTopic = researchTopic;
        this.publicationCount = 2; // Default value
    }
    
    // Implementation of interface methods
    @Override
    public String getResearchFocus() {
        return researchTopic;
    }
    
    @Override
    public int getPublicationCount() {
        return publicationCount;
    }
    
    // Method overriding
    @Override
    public String getDetails() {
        return "Graduate Student: " + name + ", Research: " + researchTopic;
    }
}

/**
 * POLYMORPHISM
 * 
 * Polymorphism allows us to perform a single action in different ways.
 * It occurs when we have many classes related to each other by inheritance.
 */
class Professor extends Person {
    private int id;
    private String department;
    
    // Constructor
    public Professor(int id, String name, int age, String department) {
        super(name, age);
        this.id = id;
        this.department = department;
    }
    
    // Getter methods
    public int getId() {
        return id;
    }
    
    public String getDepartment() {
        return department;
    }
    
    // Method overriding - a form of polymorphism
    @Override
    public String getDetails() {
        return "Professor: " + name + ", Department: " + department;
    }
}

/**
 * MULTIPLE INHERITANCE VIA INTERFACES
 */
class AdjunctProfessor extends Professor implements Researcher {
    private int publicationCount;
    
    // Constructor
    public AdjunctProfessor(int id, String name, int age, String department) {
        super(id, name, age, department);
        this.publicationCount = 5; // Default value
    }
    
    // Implementation of interface methods
    @Override
    public String getResearchFocus() {
        return getDepartment() + " Education";
    }
    
    @Override
    public int getPublicationCount() {
        return publicationCount;
    }
    
    // Override default method from interface
    @Override
    public String getResearchStatus() {
        return "Adjunct with " + publicationCount + " publications";
    }
}

/**
 * COMPOSITION
 * 
 * Composition is a "has-a" relationship, where one object contains other objects.
 */
class Course {
    private String code;
    private String title;
    private int credits;
    private Student[] enrolledStudents;
    private int studentCount;
    
    // Constructor - method overloading example
    public Course(String code, String title, int credits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.enrolledStudents = new Student[100]; // Maximum 100 students per course
        this.studentCount = 0;
    }
    
    // Method overloading - same method name with different parameters
    public Course(String code, String title) {
        this(code, title, 3); // Calling other constructor with default credits value
    }
    
    // Getter methods
    public String getCode() {
        return code;
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getCredits() {
        return credits;
    }
    
    // Method to add a student to the course
    public void addStudent(Student student) {
        if (studentCount < enrolledStudents.length) {
            // Check if student is already enrolled
            for (int i = 0; i < studentCount; i++) {
                if (enrolledStudents[i].getId() == student.getId()) {
                    return; // Student already enrolled
                }
            }
            enrolledStudents[studentCount++] = student;
        }
    }
    
    // Method to display all enrolled students
    public void displayEnrolledStudents() {
        System.out.println("\nStudents enrolled in " + title + " (" + code + "):");
        if (studentCount == 0) {
            System.out.println("  No students enrolled.");
        } else {
            for (int i = 0; i < studentCount; i++) {
                System.out.println("  " + enrolledStudents[i].getName() + 
                                  " (ID: " + enrolledStudents[i].getId() + ")");
            }
        }
    }
}

/**
 * COMPOSITION EXAMPLE
 * 
 * A Department "has-a" collection of Professors
 */
class Department {
    private String name;
    private Professor[] professors;
    private int professorCount;
    
    // Constructor
    public Department(String name) {
        this.name = name;
        this.professors = new Professor[20]; // Maximum 20 professors per department
        this.professorCount = 0;
    }
    
    // Getter for name
    public String getName() {
        return name;
    }
    
    // Method to add a professor to the department
    public void addProfessor(Professor professor) {
        if (professorCount < professors.length) {
            professors[professorCount++] = professor;
        }
    }
    
    // Method to get the number of professors
    public int getProfessorCount() {
        return professorCount;
    }
}
