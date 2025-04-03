package ClassWork;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract base class for library resources
abstract class LibraryResource {
    private String uniqueId;
    private String title;
    private boolean isAvailable;
    protected int totalCopies;
    protected int availableCopies;

    public LibraryResource(String uniqueId, String title, int totalCopies) {
        this.uniqueId = uniqueId;
        this.title = title;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
        this.isAvailable = true;
    }

    // Abstract methods to be implemented by child classes
    public abstract void displayDetails();
    public abstract double calculateReplacement();

    // Getters and setters with encapsulation
    public String getUniqueId() { return uniqueId; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return availableCopies > 0; }
    public int getAvailableCopies() { return availableCopies; }
}

// Concrete class for Books
class Book extends LibraryResource {
    private String author;
    private int publishedYear;
    private Genre genre;

    // Enum for book genres
    public enum Genre {
        FICTION, NON_FICTION, SCIENCE, HISTORY, TECHNOLOGY
    }

    public Book(String uniqueId, String title, String author, int publishedYear, Genre genre, int totalCopies) {
        super(uniqueId, title, totalCopies);
        this.author = author;
        this.publishedYear = publishedYear;
        this.genre = genre;
    }

    @Override
    public void displayDetails() {
        System.out.printf("Book: %s | Author: %s | Genre: %s | Published: %d | Available Copies: %d%n", 
                          getTitle(), author, genre, publishedYear, getAvailableCopies());
    }

    @Override
    public double calculateReplacement() {
        // Complex replacement cost calculation based on age and genre
        double basePrice = 50.0;
        double ageFactor = Math.max(1, (2024 - publishedYear) / 10.0);
        return basePrice * ageFactor * (genre == Genre.TECHNOLOGY ? 1.5 : 1.0);
    }
}

// Concrete class for Academic Journals
class AcademicJournal extends LibraryResource {
    private String publisher;
    private String issn;
    private ResearchField field;

    // Enum for research fields
    public enum ResearchField {
        COMPUTER_SCIENCE, BIOLOGY, PHYSICS, CHEMISTRY, MATHEMATICS
    }

    public AcademicJournal(String uniqueId, String title, String publisher, String issn, 
                            ResearchField field, int totalCopies) {
        super(uniqueId, title, totalCopies);
        this.publisher = publisher;
        this.issn = issn;
        this.field = field;
    }

    @Override
    public void displayDetails() {
        System.out.printf("Journal: %s | Publisher: %s | ISSN: %s | Field: %s | Available Copies: %d%n", 
                          getTitle(), publisher, issn, field, getAvailableCopies());
    }

    @Override
    public double calculateReplacement() {
        // More complex replacement cost for academic journals
        return 200.0 * (field == ResearchField.COMPUTER_SCIENCE ? 1.7 : 1.0);
    }
}

// User management class
class LibraryUser {
    private String userId;
    private String name;
    private List<Loan> activeLoans;
    private static final int MAX_LOANS = 5;

    public LibraryUser(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.activeLoans = new ArrayList<>();
    }

    // Loan management methods with complex logic
    public boolean canBorrow() {
        return activeLoans.size() < MAX_LOANS && 
               activeLoans.stream().noneMatch(Loan::isOverdue);
    }

    public void addLoan(Loan loan) {
        if (canBorrow()) {
            activeLoans.add(loan);
        } else {
            throw new IllegalStateException("Cannot borrow more resources");
        }
    }

    public void displayLoans() {
        System.out.println("Active Loans for " + name + ":");
        activeLoans.forEach(System.out::println);
    }
}

// Loan tracking class
class Loan {
    private LibraryResource resource;
    private LibraryUser borrower;
    private LocalDate borrowDate;
    private static final int LOAN_PERIOD_DAYS = 14;

    public Loan(LibraryResource resource, LibraryUser borrower) {
        this.resource = resource;
        this.borrower = borrower;
        this.borrowDate = LocalDate.now();
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(borrowDate.plusDays(LOAN_PERIOD_DAYS));
    }

    public long getDaysOverdue() {
        return ChronoUnit.DAYS.between(borrowDate.plusDays(LOAN_PERIOD_DAYS), LocalDate.now());
    }

    @Override
    public String toString() {
        return String.format("Resource: %s | Borrowed: %s | Overdue: %b", 
                             resource.getTitle(), borrowDate, isOverdue());
    }
}

// Library Management System with Complex Menu-Driven Interface
public class LibraryManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static List<LibraryResource> resources = new ArrayList<>();
    private static List<LibraryUser> users = new ArrayList<>();
    private static List<Loan> loans = new ArrayList<>();

    public static void main(String[] args) {
        initializeSampleData();
        displayMainMenu();
    }

    private static void initializeSampleData() {
        // Populate initial resources and users
        resources.add(new Book("B001", "Java OOP Mastery", "John Smith", 2022, 
                                Book.Genre.TECHNOLOGY, 5));
        resources.add(new AcademicJournal("J001", "Advanced Computing", 
                                          "Tech Publications", "1234-5678", 
                                          AcademicJournal.ResearchField.COMPUTER_SCIENCE, 3));
        
        users.add(new LibraryUser("U001", "Alice Johnson"));
        users.add(new LibraryUser("U002", "Bob Williams"));
    }

    private static void displayMainMenu() {
        while (true) {
            System.out.println("\n--- Advanced Library Management System ---");
            System.out.println("1. Manage Resources");
            System.out.println("2. Manage Users");
            System.out.println("3. Loan Management");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: manageResources(); break;
                case 2: manageUsers(); break;
                case 3: loanManagement(); break;
                case 4: 
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default: 
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void manageResources() {
        System.out.println("\n--- Resource Management ---");
        System.out.println("1. Add New Resource");
        System.out.println("2. List All Resources");
        System.out.println("3. Search Resources");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1: addNewResource(); break;
            case 2: listAllResources(); break;
            case 3: searchResources(); break;
            default: System.out.println("Invalid choice.");
        }
    }

    private static void addNewResource() {
        System.out.println("Select Resource Type:");
        System.out.println("1. Book");
        System.out.println("2. Academic Journal");
        int type = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Unique ID: ");
        String uniqueId = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Total Copies: ");
        int totalCopies = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (type == 1) {
            System.out.print("Enter Author: ");
            String author = scanner.nextLine();
            System.out.print("Enter Published Year: ");
            int publishedYear = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.println("Select Genre:");
            for (Book.Genre genre : Book.Genre.values()) {
                System.out.println((genre.ordinal() + 1) + ". " + genre);
            }
            int genreChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Book newBook = new Book(uniqueId, title, author, publishedYear, 
                                    Book.Genre.values()[genreChoice - 1], totalCopies);
            resources.add(newBook);
            System.out.println("Book added successfully!");
        } else if (type == 2) {
            System.out.print("Enter Publisher: ");
            String publisher = scanner.nextLine();
            System.out.print("Enter ISSN: ");
            String issn = scanner.nextLine();

            System.out.println("Select Research Field:");
            for (AcademicJournal.ResearchField field : AcademicJournal.ResearchField.values()) {
                System.out.println((field.ordinal() + 1) + ". " + field);
            }
            int fieldChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            AcademicJournal newJournal = new AcademicJournal(uniqueId, title, publisher, issn, 
                                          AcademicJournal.ResearchField.values()[fieldChoice - 1], totalCopies);
            resources.add(newJournal);
            System.out.println("Journal added successfully!");
        }
    }

    private static void listAllResources() {
        System.out.println("\n--- All Resources ---");
        resources.forEach(LibraryResource::displayDetails);
    }

    private static void searchResources() {
        System.out.print("Enter search term: ");
        String searchTerm = scanner.nextLine().toLowerCase();

        resources.stream()
                 .filter(r -> r.getTitle().toLowerCase().contains(searchTerm))
                 .forEach(LibraryResource::displayDetails);
    }

    private static void manageUsers() {
        // Similar implementation for user management
        System.out.println("User management placeholder");
    }

    private static void loanManagement() {
        // Similar implementation for loan management
        System.out.println("Loan management placeholder");
    }
}