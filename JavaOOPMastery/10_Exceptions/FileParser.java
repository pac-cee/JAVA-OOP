// FileParser project: demonstrates advanced exception handling and custom exceptions
import java.io.*;

class InvalidFileFormatException extends Exception {
    public InvalidFileFormatException(String message) {
        super(message);
    }
}

public class FileParser {
    public static void parseFile(String filename) throws InvalidFileFormatException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNum = 0;
            while ((line = br.readLine()) != null) {
                lineNum++;
                if (!line.contains(",")) {
                    throw new InvalidFileFormatException("Line " + lineNum + " is not CSV formatted");
                }
                System.out.println("Parsed: " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            parseFile("test.csv");
        } catch (InvalidFileFormatException e) {
            System.out.println("Invalid file format: " + e.getMessage());
        }
    }
}
