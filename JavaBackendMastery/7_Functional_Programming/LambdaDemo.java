// Demonstrates lambda expressions and streams
import java.util.*;
public class LambdaDemo {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        // Print squares using lambda
        nums.forEach(n -> System.out.println(n * n));
        // Sum even numbers using streams
        int sum = nums.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println("Sum of even: " + sum);
    }
}
