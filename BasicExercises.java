import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class BasicExercises {
    // 1. Triangle Type
    public static String determineTriangleType(double side1, double side2, double side3) {
        if (side1 == side2 && side2 == side3) {
            return "Equilateral";
        } else if (side1 == side2 || side2 == side3 || side1 == side3) {
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }

    // 2. Number Properties
    public static String checkNumber(int number) {
        String type = (number > 0) ? "positive" : (number < 0) ? "negative" : "zero";
        String parity = (number % 2 == 0) ? "even" : "odd";
        return "The number is " + type + " and " + parity;
    }

    // 3. Employee Bonus
    public static double calculateBonus(double salary, int yearsOfService) {
        if (yearsOfService > 10) {
            return salary * 0.15;
        } else if (yearsOfService >= 5) {
            return salary * 0.10;
        } else {
            return salary * 0.05;
        }
    }

    // 4. Password Validator
    public static boolean isPasswordValid(String password) {
        boolean hasUpperCase = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        String specialChars = "!@#$%^&*()_+-=[]{}|;:,.<>?";
        
        if (password.length() < 8) return false;
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpperCase = true;
            if (Character.isDigit(c)) hasNumber = true;
            if (specialChars.contains(String.valueOf(c))) hasSpecial = true;
        }
        
        return hasUpperCase && hasNumber && hasSpecial;
    }

    // 5. Time-based Greeting
    public static String getGreeting(int hour) {
        if (hour >= 0 && hour <= 5) return "Good Night";
        if (hour >= 6 && hour <= 11) return "Good Morning";
        if (hour >= 12 && hour <= 17) return "Good Afternoon";
        if (hour >= 18 && hour <= 23) return "Good Evening";
        return "Invalid hour";
    }

    // 6. Palindrome Check
    public static boolean isPalindrome(int number) {
        int original = number;
        int reversed = 0;
        while (number > 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }
        return original == reversed;
    }

    // 7. BMI Calculator
    public static String calculateBMI(double weight, double height) {
        double bmi = weight / (height * height);
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }

    // 8. Electricity Bill
    public static double calculateElectricityBill(int units) {
        double bill = 0;
        if (units <= 100) {
            bill = units * 0.50;
        } else if (units <= 300) {
            bill = (100 * 0.50) + ((units - 100) * 0.75);
        } else {
            bill = (100 * 0.50) + (200 * 0.75) + ((units - 300) * 1.20);
        }
        return bill;
    }

    // 9. Loan Eligibility
    public static boolean isEligibleForLoan(double income, int creditScore, int existingLoans) {
        return income >= 30000 && creditScore >= 700 && existingLoans < 2;
    }

    // 10. Number Guessing Game
    public static void playNumberGame(Scanner scanner) {
        Random random = new Random();
        int target = random.nextInt(100) + 1;
        int attempts = 0;
        int guess;
        
        do {
            System.out.print("Guess a number between 1 and 100: ");
            guess = scanner.nextInt();
            attempts++;
            
            if (guess < target) {
                System.out.println("Too low!");
            } else if (guess > target) {
                System.out.println("Too high!");
            }
        } while (guess != target);
        
        System.out.println("Congratulations! You got it in " + attempts + " attempts!");
    }

    // 11. Number to Word
    public static String numberToWord(int digit) {
        String[] words = {"Zero", "One", "Two", "Three", "Four", 
                         "Five", "Six", "Seven", "Eight", "Nine"};
        return (digit >= 0 && digit <= 9) ? words[digit] : "Invalid digit";
    }

    // Additional utility methods for remaining exercises
    
    // 25. DateTime Formatting
    public static String formatDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    // 26. Name Formatter
    public static String formatName(String firstName, String lastName) {
        return lastName + ", " + firstName;
    }

    // 27. Reverse Words
    public static String reverseWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) reversed.append(" ");
        }
        return reversed.toString();
    }

    // 28. URL Generator
    public static String generateURL(String username) {
        return "www." + username.toLowerCase().replaceAll("[^a-z0-9]", "") + ".com";
    }

    // 29. Log Message Generator
    public static String generateLogMessage(String username, String action) {
        return String.format("[%s] User '%s' performed action: %s", 
            formatDateTime(), username, action);
    }

    // 30. String Encoder
    public static String encodeString(String input) {
        StringBuilder encoded = new StringBuilder();
        for (char c : input.toCharArray()) {
            encoded.append((int) c).append("-");
        }
        return encoded.substring(0, encoded.length() - 1);
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Test triangle type
        System.out.println(determineTriangleType(3, 3, 3));  // Equilateral
        
        // Test number properties
        System.out.println(checkNumber(-4));  // negative and even
        
        // Test password validator
        System.out.println(isPasswordValid("Pass123!"));  // true
        
        // Test greeting
        System.out.println(getGreeting(14));  // Good Afternoon
        
        // Test palindrome
        System.out.println(isPalindrome(12321));  // true
        
        // Test BMI calculator
        System.out.println(calculateBMI(70, 1.75));  // Normal
        
        // Test electricity bill
        System.out.println(calculateElectricityBill(250));  // 162.5
        
        // Test number game
        // playNumberGame(scanner);
        
        // Test name formatter
        System.out.println(formatName("John", "Doe"));  // Doe, John
        
        // Test reverse words
        System.out.println(reverseWords("Hello World"));  // World Hello
        
        scanner.close();
    }
}