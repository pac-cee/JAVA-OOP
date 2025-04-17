// Demonstrates String and StringBuilder usage
public class StringDemo {
    public static void main(String[] args) {
        String greeting = "Hello, world!";
        System.out.println(greeting.toUpperCase()); // HELLO, WORLD!

        StringBuilder sb = new StringBuilder("Java");
        sb.append(" Programming");
        System.out.println(sb.toString()); // Java Programming
    }
}
