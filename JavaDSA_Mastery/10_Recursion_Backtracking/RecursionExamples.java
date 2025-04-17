public class RecursionExamples {
    // Factorial
    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
    // Fibonacci
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static void main(String[] args) {
        System.out.println("Factorial 5: " + factorial(5)); // 120
        System.out.println("Fibonacci 6: " + fibonacci(6)); // 8
    }
}
