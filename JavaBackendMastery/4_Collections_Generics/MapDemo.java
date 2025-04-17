// Demonstrates using a HashMap to count word frequencies
import java.util.*;
public class MapDemo {
    public static void main(String[] args) {
        String sentence = "hello world hello";
        Map<String, Integer> freq = new HashMap<>();
        for (String word : sentence.split(" ")) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        System.out.println(freq); // {hello=2, world=1}
    }
}
