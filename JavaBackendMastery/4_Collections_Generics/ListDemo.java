// Demonstrates using ArrayList, LinkedList, iteration, and sorting
import java.util.*;
public class ListDemo {
    public static void main(String[] args) {
        // ArrayList example
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        // Iteration
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }
        // Sorting
        Collections.sort(fruits);
        System.out.println("Sorted: " + fruits);
        // LinkedList example
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(20);
        // Remove first
        numbers.removeFirst();
        System.out.println("Numbers: " + numbers);
    }
}
