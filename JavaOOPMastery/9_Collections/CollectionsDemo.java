// Demonstrates usage of Java Collections
import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("OOP");
        System.out.println("List: " + list);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        System.out.println("Set: " + set);

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        System.out.println("Map: " + map);
    }
}
