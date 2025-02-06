package exercises.time;

public class TimeGreeting {
    public static String getGreeting(int hour) {
        if (hour < 0 || hour > 23) {
            return "Invalid hour";
        }
        
        if (hour >= 0 && hour <= 5) {
            return "Good Night";
        } else if (hour >= 6 && hour <= 11) {
            return "Good Morning";
        } else if (hour >= 12 && hour <= 17) {
            return "Good Afternoon";
        } else {
            return "Good Evening";
        }
    }
}
