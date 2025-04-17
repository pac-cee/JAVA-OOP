// Demonstrates usage of the java.time API
import java.time.LocalDate;
import java.time.LocalDateTime;
public class DateTimeDemo {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Today's date: " + today);

        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current date and time: " + now);
    }
}
