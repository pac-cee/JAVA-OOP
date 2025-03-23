package classwork;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Book class encapsulating book details and availability
class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true; // Book is available when added
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean status) {
        this.available = status;
    }

    @Override
    public String toString() {
        return "Title: " + title + " | Author: " + author + " | ISBN: " + isbn + " | Available: " + available;
    }
}

// Library class managing a collection of Book objects
class Library {
     ArrayList<Book> books = new ArrayList<>();

    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    // Remove a book based on ISBN
    public void removeBook(String isbn) {
        Book book = findBookByIsbn(isbn);
        if (book != null) {
            books.remove(book);
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    // Search for a book by title
    public void searchByTitle(String title) {
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with the title containing: " + title);
        }
    }

    // Helper method to find a book by ISBN
    private Book findBookByIsbn(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn))
                return b;
        }
        return null;
    }

    // List all books in the library
    public void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }
}

public class LibraryManagement {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        System.out.println("Welcome to the Library Management System!");
        do {
            displayMenu();
            choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    addNewBook();
                    break;
                case 2:
                    searchBookByTitle();
                    break;
                case 3:
                    removeBook();
                    break;
                case 4:
                    library.listAllBooks();
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

    // Display menu options for the library system
    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add New Book");
        System.out.println("2. Search Book by Title");
        System.out.println("3. Remove Book by ISBN");
        System.out.println("4. List All Books");
        System.out.println("5. Exit");
    }

    // Add a new book into the library
    private static void addNewBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        Book newBook = new Book(title, author, isbn);
        library.addBook(newBook);
    }

    // Search for a book by title
    private static void searchBookByTitle() {
        System.out.print("Enter title to search: ");
        String title = scanner.nextLine();
        library.searchByTitle(title);
    }

    // Remove a book by ISBN
    private static void removeBook() {
        System.out.print("Enter ISBN of the book to remove: ");
        String isbn = scanner.nextLine();
        library.removeBook(isbn);
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
}
