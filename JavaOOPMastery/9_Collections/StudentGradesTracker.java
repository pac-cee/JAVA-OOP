// Student Grades Tracker using Maps and Streams
import java.util.*;
import java.util.stream.Collectors;

public class StudentGradesTracker {
    public static void main(String[] args) {
        Map<String, Double> grades = new HashMap<>();
        grades.put("Alice", 88.5);
        grades.put("Bob", 91.0);
        grades.put("Carol", 76.5);
        grades.put("Dave", 85.0);

        // Print all grades
        grades.forEach((student, grade) -> System.out.println(student + ": " + grade));

        // Calculate average
        double avg = grades.values().stream().mapToDouble(Double::doubleValue).average().orElse(0);
        System.out.println("Average: " + avg);

        // Sort by grade descending
        List<Map.Entry<String, Double>> sorted = grades.entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .collect(Collectors.toList());
        System.out.println("Sorted by grade:");
        sorted.forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
