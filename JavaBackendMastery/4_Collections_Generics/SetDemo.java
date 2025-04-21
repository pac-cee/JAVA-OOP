import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple"); // Duplicate, will not be added

        System.out.println("Fruits in the set: " + fruits);
        System.out.println("Contains 'Banana'? " + fruits.contains("Banana"));
        System.out.println("Set size: " + fruits.size());
    }
}
