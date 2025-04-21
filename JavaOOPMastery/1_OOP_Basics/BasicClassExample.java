// Example of a basic class with fields and methods
public class BasicClassExample {
    private String message;

    public BasicClassExample(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        BasicClassExample example = new BasicClassExample("Hello, OOP!");
        example.printMessage();
    }
}
