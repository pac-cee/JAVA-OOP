package utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateUtils {
public static int getAgeFromDOB(String dob) {
    try {
        // Validate date format
        if (!dob.matches("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd format");
            return 0;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(dob, formatter);
        LocalDate today = LocalDate.now();
        
        if (birthDate.isAfter(today)) {
            System.out.println("Invalid date: Birth date is in the future");
            return 0;
        }

        int age = Period.between(birthDate, today).getYears();
        System.out.println("Calculated age: " + age);
        return age;
    } catch (Exception e) {
        System.out.println("Error calculating age: " + e.getMessage());
        return 0;
    }
}


    public static boolean isRegistrationDay(String date) {
        try {
            LocalDate regDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String day = regDate.getDayOfWeek().toString();
            return day.equals("MONDAY") || day.equals("FRIDAY");
        } catch (Exception e) {
            return false;
        }
    }

    public static String getDayOfWeek(String date) {
        try {
            LocalDate regDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return regDate.getDayOfWeek().toString();
        } catch (Exception e) {
            return "Invalid Date";
        }
    }
} 