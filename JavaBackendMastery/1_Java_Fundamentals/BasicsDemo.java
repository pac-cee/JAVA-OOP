// Demonstrates variables, control flow, and methods in Java
public class BasicsDemo {
    // Method to add two numbers
    public static int add(int a, int b) {
        return a + b;
    }
    public static void main(String[] args) {
        int age = 18;
        if (age >= 18) {
            System.out.println("You are an adult.");
        } else {
            System.out.println("You are not an adult.");
        }
        // Loop from 1 to 10
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        // Using add method
        int sum = add(5, 7);
        System.out.println("Sum: " + sum);
    }
}
