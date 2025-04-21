import java.util.*;

public class TextAnalyzer {
    public static Map<String, Integer> wordFrequency(String text) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : text.split("\\W+")) {
            if (word.isEmpty()) continue;
            freq.put(word.toLowerCase(), freq.getOrDefault(word.toLowerCase(), 0) + 1);
        }
        return freq;
    }
    public static void main(String[] args) {
        String text = "Hello world! Hello Java. Java is powerful. World of Java.";
        Map<String, Integer> freq = wordFrequency(text);
        System.out.println("Word frequencies: " + freq);
    }
}
