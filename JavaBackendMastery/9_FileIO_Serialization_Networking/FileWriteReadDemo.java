// Demonstrates writing and reading a file in Java
import java.nio.file.*;
import java.io.IOException;
public class FileWriteReadDemo {
    public static void main(String[] args) throws IOException {
        String text = "Backend mastery!";
        Path path = Path.of("backend.txt");
        Files.writeString(path, text);
        String read = Files.readString(path);
        System.out.println("File says: " + read);
    }
}
