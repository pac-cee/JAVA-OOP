import java.util.*;
public class SetExample {
    public static void main(String[] args) {
        Set<String> names = new TreeSet<>();
        names.add("Charlie");
        names.add("Alice");
        names.add("Bob");
        System.out.println("Sorted names: " + names);
    }
}
