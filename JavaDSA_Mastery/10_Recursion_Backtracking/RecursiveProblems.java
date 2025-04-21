public class RecursiveProblems {
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
    // Tower of Hanoi
    public static void towerOfHanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + from + " to " + to);
            return;
        }
        towerOfHanoi(n - 1, from, aux, to);
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        towerOfHanoi(n - 1, aux, to, from);
    }
    public static void main(String[] args) {
        System.out.println("Factorial(5): " + factorial(5));
        System.out.println("Fibonacci(7): " + fibonacci(7));
        System.out.println("Tower of Hanoi (3 disks):");
        towerOfHanoi(3, 'A', 'C', 'B');
    }
}
