// Demonstrates writing, appending, checking existence, and reading a file in Java
import java.nio.file.*;
import java.io.IOException;
public class FileWriteReadDemo {
    public static void main(String[] args) throws IOException {
        String text = "Backend mastery!\n";
        Path path = Path.of("backend.txt");
        // Write to file (overwrites if exists)
        Files.writeString(path, text);
        // Append to file
        Files.writeString(path, "Appended line!\n", StandardOpenOption.APPEND);
        // Check if file exists
        if (Files.exists(path)) {
            System.out.println("File exists!");
        }
        // Read from file
        String read = Files.readString(path);
        System.out.println("File says:\n" + read);
    }
}
