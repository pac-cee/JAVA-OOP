// Demonstrates using ArrayList and generics
import java.util.*;
public class ListDemo {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
