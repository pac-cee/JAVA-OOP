import java.util.List;

public static void main(String[] args) {
    List<Book> bookList = java.util.Arrays.asList(new Book("Java Basics"), new Book("OOP in Depth"));
    Library lib = new Library(bookList);
    lib.showBooks(); // Output: Java Basics\nOOP in Depth
}
