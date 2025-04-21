import java.util.*;

public class MiniLibrarySystem {
    static class Book {
        String title, author;
        Book(String title, String author) { this.title = title; this.author = author; }
        public String toString() { return title + " by " + author; }
    }
    private Map<String, Book> books = new HashMap<>();

    public void addBook(String title, String author) {
        books.put(title, new Book(title, author));
    }
    public void removeBook(String title) {
        books.remove(title);
    }
    public Book searchBook(String title) {
        return books.get(title);
    }
    public void listBooks() {
        for (Book b : books.values()) System.out.println(b);
    }
    public static void main(String[] args) {
        MiniLibrarySystem lib = new MiniLibrarySystem();
        lib.addBook("1984", "George Orwell");
        lib.addBook("Brave New World", "Aldous Huxley");
        lib.listBooks();
        System.out.println("Search '1984': " + lib.searchBook("1984"));
        lib.removeBook("1984");
        lib.listBooks();
    }
}
