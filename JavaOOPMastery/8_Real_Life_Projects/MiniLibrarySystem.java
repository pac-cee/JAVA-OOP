// Mini library management system
class Book {
    String title, author;
    boolean isAvailable = true;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

class Library {
    private Book[] books;
    public Library(Book[] books) { this.books = books; }
    public void listBooks() {
        for (Book b : books) {
            System.out.println(b.title + " by " + b.author + (b.isAvailable ? " (Available)" : " (Checked out)"));
        }
    }
}

public class MiniLibrarySystem {
    public static void main(String[] args) {
        Book[] books = { new Book("Java Basics", "Alice"), new Book("OOP Mastery", "Bob") };
        Library library = new Library(books);
        library.listBooks();
    }
}
