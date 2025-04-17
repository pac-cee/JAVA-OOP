// Demonstrates reading and writing files in Java
import java.nio.file.*;
import java.io.IOException;
public class FileIODemo {
    public static void main(String[] args) throws IOException {
        String content = "Hello File!";
        Path filePath = Path.of("sample.txt");
        // Write to file
        Files.writeString(filePath, content);
        // Read from file
        String read = Files.readString(filePath);
        System.out.println("File content: " + read);
    }
}
