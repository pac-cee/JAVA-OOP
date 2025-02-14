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
        try (Scanner scanner = new Scanner(System.in)) {
            // 1. Triangle Type Tests
            System.out.println("=== 1. Triangle Type Tests ===");
            System.out.println("Triangle (3, 3, 3): " + determineTriangleType(3, 3, 3)); // Equilateral
            System.out.println("Triangle (3, 3, 4): " + determineTriangleType(3, 3, 4)); // Isosceles
            System.out.println("Triangle (3, 4, 5): " + determineTriangleType(3, 4, 5)); // Scalene

            // 2. Number Properties Tests
            System.out.println("\n=== 2. Number Properties Tests ===");
            System.out.println("Number 5: " + checkNumber(5));     // positive and odd/even
            System.out.println("Number -4: " + checkNumber(-4));   // negative and even
            System.out.println("Number 0: " + checkNumber(0));     // zero and even

            // 3. Employee Bonus Tests
            System.out.println("\n=== 3. Employee Bonus Tests ===");
            System.out.println("Bonus for salary 1000, 12 years: " + calculateBonus(1000, 12)); // 15%
            System.out.println("Bonus for salary 1000, 5 years: " + calculateBonus(1000, 5));   // 10%
            System.out.println("Bonus for salary 1000, 2 years: " + calculateBonus(1000, 2));   // 5%

            // 4. Password Validator Tests
            System.out.println("\n=== 4. Password Validator Tests ===");
            System.out.println("Valid Password 'Pass123!': " + isPasswordValid("Pass123!"));   // true
            System.out.println("Invalid Password 'password': " + isPasswordValid("password")); // false

            // 5. Time-based Greeting Tests
            System.out.println("\n=== 5. Time-based Greeting Tests ===");
            System.out.println("Greeting for hour 2: " + getGreeting(2));   // Good Night
            System.out.println("Greeting for hour 8: " + getGreeting(8));   // Good Morning
            System.out.println("Greeting for hour 14: " + getGreeting(14)); // Good Afternoon
            System.out.println("Greeting for hour 20: " + getGreeting(20)); // Good Evening
            System.out.println("Greeting for hour 25: " + getGreeting(25)); // Invalid hour

            // 6. Palindrome Check Tests
            System.out.println("\n=== 6. Palindrome Check Tests ===");
            System.out.println("Is 12321 a palindrome? " + isPalindrome(12321)); // true
            System.out.println("Is 12345 a palindrome? " + isPalindrome(12345)); // false

            // 7. BMI Calculator Tests
            System.out.println("\n=== 7. BMI Calculator Tests ===");
            System.out.println("BMI for weight 45, height 1.8: " + calculateBMI(45, 1.8));   // Underweight
            System.out.println("BMI for weight 70, height 1.75: " + calculateBMI(70, 1.75)); // Normal
            System.out.println("BMI for weight 85, height 1.80: " + calculateBMI(85, 1.80)); // Overweight
            System.out.println("BMI for weight 95, height 1.70: " + calculateBMI(95, 1.70)); // Obese

            // 8. Electricity Bill Tests
            System.out.println("\n=== 8. Electricity Bill Tests ===");
            System.out.println("Bill for 80 units: " + calculateElectricityBill(80));   // within first slab
            System.out.println("Bill for 250 units: " + calculateElectricityBill(250)); // within second slab
            System.out.println("Bill for 350 units: " + calculateElectricityBill(350)); // above 300 units

            // 9. Loan Eligibility Tests
            System.out.println("\n=== 9. Loan Eligibility Tests ===");
            System.out.println("Eligible (Income 35000, Credit Score 720, Loans 1): " 
                               + isEligibleForLoan(35000, 720, 1)); // Expected: true
            System.out.println("Not Eligible (Income 25000, Credit Score 680, Loans 2): " 
                               + isEligibleForLoan(25000, 680, 2)); // Expected: false

            // 10. Number Guessing Game Test (Interactive)
            System.out.println("\n=== 10. Number Guessing Game Test ===");
            System.out.println("Note: This is an interactive game. Please follow the prompts.");
            playNumberGame(scanner);

            // 11. Number to Word Tests
            System.out.println("\n=== 11. Number to Word Tests ===");
            System.out.println("Digit 5: " + numberToWord(5));   // "Five"
            System.out.println("Digit 10: " + numberToWord(10)); // Invalid digit

            // 25. DateTime Formatting Test
            System.out.println("\n=== 25. DateTime Formatting Test ===");
            System.out.println("Current DateTime: " + formatDateTime());

            // 26. Name Formatter Test
            System.out.println("\n=== 26. Name Formatter Test ===");
            System.out.println("Formatted Name (Alice, Smith): " + formatName("Alice", "Smith"));

            // 27. Reverse Words Test
            System.out.println("\n=== 27. Reverse Words Test ===");
            System.out.println("Reversed 'Java Programming': " + reverseWords("Java Programming"));

            // 28. URL Generator Test
            System.out.println("\n=== 28. URL Generator Test ===");
            System.out.println("URL for 'User_123': " + generateURL("User_123"));

            // 29. Log Message Generator Test
            System.out.println("\n=== 29. Log Message Generator Test ===");
            System.out.println("Log Message: " + generateLogMessage("Alice", "logged in"));

            // 30. String Encoder Test
            System.out.println("\n=== 30. String Encoder Test ===");
            System.out.println("Encoded 'abc': " + encodeString("abc"));
        }
    }
}