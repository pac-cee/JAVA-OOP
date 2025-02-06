package exercises.formatting;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringFormatter {
    public static String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }

    public static String formatName(String firstName, String lastName) {
        return lastName + ", " + firstName;
    }

    public static String reverseWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) reversed.append(" ");
        }
        return reversed.toString();
    }

    public static String generateURL(String username) {
        return "www." + username.toLowerCase().replaceAll("[^a-z0-9]", "") + ".com";
    }

    public static String generateLogMessage(String username, String action) {
        return String.format("[%s] User '%s' performed action: %s", 
            formatDateTime(LocalDateTime.now()), username, action);
    }

    public static String encodeString(String input) {
        StringBuilder encoded = new StringBuilder();
        for (char c : input.toCharArray()) {
            encoded.append((int) c).append("-");
        }
        return encoded.length() > 0 ? encoded.substring(0, encoded.length() - 1) : "";
    }
}
