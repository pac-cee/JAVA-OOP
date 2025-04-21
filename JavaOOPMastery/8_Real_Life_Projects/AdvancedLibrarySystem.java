// Advanced Library Management System (skeleton)
import java.util.*;

class Book {
    private String title, author;
    private boolean available = true;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    @Override
    public String toString() {
        return title + " by " + author + (available ? " (Available)" : " (Checked out)");
    }
}

class User {
    private String name;
    public User(String name) { this.name = name; }
    public String getName() { return name; }
}

class Library {
    private List<Book> books = new ArrayList<>();
    private Map<User, List<Book>> userBooks = new HashMap<>();
    public void addBook(Book b) { books.add(b); }
    public void registerUser(User u) { userBooks.putIfAbsent(u, new ArrayList<>()); }
    public void borrowBook(User u, Book b) {
        if (b.isAvailable() && userBooks.containsKey(u)) {
            b.setAvailable(false);
            userBooks.get(u).add(b);
            System.out.println(u.getName() + " borrowed " + b.getTitle());
        } else {
            System.out.println("Cannot borrow book.");
        }
    }
    public void returnBook(User u, Book b) {
        if (userBooks.containsKey(u) && userBooks.get(u).remove(b)) {
            b.setAvailable(true);
            System.out.println(u.getName() + " returned " + b.getTitle());
        }
    }
    public void listBooks() {
        for (Book b : books) System.out.println(b);
    }
}

public class AdvancedLibrarySystem {
    public static void main(String[] args) {
        Library lib = new Library();
        Book b1 = new Book("Java in Depth", "Alice");
        Book b2 = new Book("Design Patterns", "Bob");
        lib.addBook(b1); lib.addBook(b2);
        User u1 = new User("John");
        lib.registerUser(u1);
        lib.listBooks();
        lib.borrowBook(u1, b1);
        lib.listBooks();
        lib.returnBook(u1, b1);
        lib.listBooks();
    }
}
