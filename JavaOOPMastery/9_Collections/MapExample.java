import java.util.*;
public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> grades = new HashMap<>();
        grades.put("Alice", 90);
        grades.put("Bob", 85);
        grades.put("Charlie", 95);
        for (String name : grades.keySet()) {
            System.out.println(name + " scored " + grades.get(name));
        }
    }
}
