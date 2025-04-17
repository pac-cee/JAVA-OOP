// Demonstrates various String operations and StringBuilder usage
public class StringDemo {
    public static void main(String[] args) {
        String greeting = "Hello, world!";
        // Convert to uppercase
        System.out.println(greeting.toUpperCase()); // HELLO, WORLD!
        // Convert to lowercase
        System.out.println(greeting.toLowerCase()); // hello, world!
        // Substring
        System.out.println(greeting.substring(0, 5)); // Hello
        // Replace characters
        System.out.println(greeting.replace("world", "Java")); // Hello, Java!
        // Split string
        String[] words = greeting.split(", ");
        for (String word : words) {
            System.out.println("Word: " + word);
        }
        // StringBuilder for efficient concatenation
        StringBuilder sb = new StringBuilder("Java");
        sb.append(" Programming");
        sb.insert(0, "Awesome ");
        sb.reverse();
        System.out.println(sb.toString()); // gnimmargorP avaJ emosewA
    }
}
