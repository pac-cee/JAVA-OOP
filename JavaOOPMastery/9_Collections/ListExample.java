import java.util.*;
public class ListExample {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        System.out.println("Fruits: " + fruits);
        fruits.remove("Banana");
        System.out.println("After removal: " + fruits);
    }
}
