// Demonstrates lambda expressions, Predicate, Function, and advanced Stream operations
import java.util.*;
import java.util.function.*;
public class LambdaDemo {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        // Print squares using lambda
        nums.forEach(n -> System.out.println("Square: " + n * n));
        // Predicate: check even
        Predicate<Integer> isEven = n -> n % 2 == 0;
        nums.stream().filter(isEven).forEach(n -> System.out.println("Even: " + n));
        // Function: double value
        Function<Integer, Integer> doubler = n -> n * 2;
        nums.stream().map(doubler).forEach(n -> System.out.println("Doubled: " + n));
        // Stream: sum, max, min
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        int max = nums.stream().max(Integer::compareTo).orElse(-1);
        int min = nums.stream().min(Integer::compareTo).orElse(-1);
        System.out.println("Sum: " + sum + ", Max: " + max + ", Min: " + min);
    }
}
