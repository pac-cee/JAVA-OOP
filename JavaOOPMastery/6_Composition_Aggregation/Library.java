import java.util.List;
public class Library {
    private List<Book> books;
    public Library(List<Book> books) {
        this.books = books;
    }
    void showBooks() {
        for (Book b : books) {
            System.out.println(b.title);
        }
    }
    public static void main(String[] args) {
        List<Book> bookList = java.util.Arrays.asList(new Book("Java Basics"), new Book("OOP in Depth"));
        Library lib = new Library(bookList);
        lib.showBooks(); // Output: Java Basics\nOOP in Depth
    }
}
