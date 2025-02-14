import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * ExercisesForTheBasics
 * 
 * This class contains static methods that solve 30 basic exercises in Java.
 * Each method is written with advanced clean code principles, includes meaningful
 * comments, and is designed to run without errors.
 */
public class ExercisesForTheBasics {

    // 1. Determine triangle type based on three sides
    public static String determineTriangleType(double a, double b, double c) {
        // Check if the sides form a valid triangle
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "Not a valid triangle";
        }
        if (a == b && b == c) {
            return "Equilateral Triangle";
        } else if (a == b || a == c || b == c) {
            return "Isosceles Triangle";
        } else {
            return "Scalene Triangle";
        }
    }

    // 2. Check if a number is positive, negative, or zero and even or odd
    public static String checkNumberProperties(int num) {
        StringBuilder result = new StringBuilder();
        if (num > 0) {
            result.append("Positive");
        } else if (num < 0) {
            result.append("Negative");
        } else {
            result.append("Zero");
        }
        result.append(" and ");
        result.append((num % 2 == 0) ? "Even" : "Odd");
        return result.toString();
    }

    // 3. Calculate an employee's bonus based on years of service.
    //    < 5 years: 5% bonus, 5-10 years: 10%, > 10 years: 15%
    public static double calculateBonus(double salary, int yearsOfService) {
        if (yearsOfService < 5) {
            return salary * 0.05;
        } else if (yearsOfService <= 10) {
            return salary * 0.10;
        } else {
            return salary * 0.15;
        }
    }

    // 4. Check if a password meets security standards:
    //    at least 8 characters, contains an uppercase letter, a number, and a special character.
    public static boolean isPasswordValid(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if ("!@#$%^&*()-_+=<>?/{}~|".indexOf(c) != -1) {
                hasSpecial = true;
            }
        }
        return hasUpper && hasDigit && hasSpecial;
    }

    // 5. Given the hour (0-23), return an appropriate greeting.
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

    // 6a. Reverse a given number.
    public static int reverseNumber(int num) {
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }

    // 6b. Check if a given number is a palindrome.
    public static boolean isPalindromeNumber(int num) {
        String original = Integer.toString(num);
        String reversed = new StringBuilder(original).reverse().toString();
        return original.equals(reversed);
    }

    // 7. Compute BMI from weight (kg) and height (m) and categorize it.
    public static String calculateBMICategory(double weight, double height) {
        // BMI = weight / (height * height)
        double bmi = weight / (height * height);
        if (bmi < 18.5) {
            return "Underweight (BMI: " + String.format("%.2f", bmi) + ")";
        } else if (bmi < 24.9) {
            return "Normal (BMI: " + String.format("%.2f", bmi) + ")";
        } else if (bmi < 29.9) {
            return "Overweight (BMI: " + String.format("%.2f", bmi) + ")";
        } else {
            return "Obese (BMI: " + String.format("%.2f", bmi) + ")";
        }
    }

    // 8. Compute an electricity bill based on unit consumption.
    //    First 100 units: $0.50, next 200 units: $0.75, above 300 units: $1.20 per unit.
    public static double calculateElectricityBill(int units) {
        double bill;
        if (units <= 100) {
            bill = units * 0.50;
        } else if (units <= 300) {
            bill = 100 * 0.50 + (units - 100) * 0.75;
        } else {
            bill = 100 * 0.50 + 200 * 0.75 + (units - 300) * 1.20;
        }
        return bill;
    }

    // 9. Determine if a person is eligible for a loan.
    //    Criteria: income >= 30000, credit score >= 650, and less than 2 existing loans.
    public static boolean isEligibleForLoan(double income, int creditScore, int existingLoans) {
        return (income >= 30000 && creditScore >= 650 && existingLoans < 2);
    }

    // 10. A simple Rock-Paper-Scissors game: user vs. computer.
    public static String playRockPaperScissors(String userMove) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        String computerMove = moves[random.nextInt(moves.length)];
        String result;
        if (userMove.equalsIgnoreCase(computerMove)) {
            result = "It's a Tie!";
        } else if ((userMove.equalsIgnoreCase("Rock") && computerMove.equals("Scissors")) ||
                   (userMove.equalsIgnoreCase("Scissors") && computerMove.equals("Paper")) ||
                   (userMove.equalsIgnoreCase("Paper") && computerMove.equals("Rock"))) {
            result = "User wins!";
        } else {
            result = "Computer wins!";
        }
        return "User: " + userMove + " | Computer: " + computerMove + " => " + result;
    }

    // 11. Convert a digit (0-9) to its English word equivalent.
    public static String digitToWord(int digit) {
        return switch (digit) {
            case 0 -> "Zero";
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            case 4 -> "Four";
            case 5 -> "Five";
            case 6 -> "Six";
            case 7 -> "Seven";
            case 8 -> "Eight";
            case 9 -> "Nine";
            default -> "Invalid digit";
        };
    }

    // 12. Convert an amount (in USD) to another currency.
    //     Supported currencies: USD, EUR, GBP, INR.
    public static double convertCurrency(double amount, String targetCurrency) {
        switch (targetCurrency.toUpperCase()) {
            case "USD" -> {
                return amount;
            }
            case "EUR" -> {
                return amount * 0.85;
            }
            case "GBP" -> {
                return amount * 0.75;
            }
            case "INR" -> {
                return amount * 74.0;
            }
            default -> throw new IllegalArgumentException("Unsupported currency: " + targetCurrency);
        }
    }

    // 13. Return the price for a selected menu item.
    //     Sample menu: Burger, Pizza, Salad, Soda.
    public static double getMenuItemPrice(String menuItem) {
        switch (menuItem.toLowerCase()) {
            case "burger" -> {
                return 5.99;
            }
            case "pizza" -> {
                return 8.99;
            }
            case "salad" -> {
                return 4.99;
            }
            case "soda" -> {
                return 1.99;
            }
            default -> throw new IllegalArgumentException("Menu item not found: " + menuItem);
        }
    }

    // 14. Convert a percentage into a grade (A, B, C, D, F) with feedback.
    public static String gradeFromPercentage(double percentage) {
        if (percentage >= 90) {
            return "A - Excellent";
        } else if (percentage >= 80) {
            return "B - Good";
        } else if (percentage >= 70) {
            return "C - Average";
        } else if (percentage >= 60) {
            return "D - Below Average";
        } else {
            return "F - Fail";
        }
    }

    // 15. Determine zodiac sign based on birth month and day.
    public static String getZodiacSign(int month, int day) {
        if (month < 1 || month > 12 || day < 1 || day > 31) {
            return "Invalid date";
        }
        if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) {
            return "Aquarius";
        } else if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) {
            return "Pisces";
        } else if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) {
            return "Aries";
        } else if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) {
            return "Taurus";
        } else if ((month == 5 && day >= 21) || (month == 6 && day <= 20)) {
            return "Gemini";
        } else if ((month == 6 && day >= 21) || (month == 7 && day <= 22)) {
            return "Cancer";
        } else if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) {
            return "Leo";
        } else if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) {
            return "Virgo";
        } else if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) {
            return "Libra";
        } else if ((month == 10 && day >= 23) || (month == 11 && day <= 21)) {
            return "Scorpio";
        } else if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) {
            return "Sagittarius";
        } else if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) {
            return "Capricorn";
        } else {
            return "Invalid date";
        }
    }

    // 16. Classify a shape based on the number of sides.
    public static String classifyShape(int sides) {
        return switch (sides) {
            case 3 -> "Triangle";
            case 4 -> "Quadrilateral";
            case 5 -> "Pentagon";
            case 6 -> "Hexagon";
            case 7 -> "Heptagon";
            case 8 -> "Octagon";
            case 9 -> "Nonagon";
            case 10 -> "Decagon";
            default -> sides + "-sided polygon";
        };
    }

    // 17. Apply a discount based on customer category.
    //     Categories: Regular (5%), Premium (10%), VIP (15%).
    public static double applyDiscount(double amount, String customerCategory) {
        return switch (customerCategory.toLowerCase()) {
            case "regular" -> amount * 0.95;
            case "premium" -> amount * 0.90;
            case "vip" -> amount * 0.85;
            default -> amount;
        };
    }

    // 18. Describe the movement of a given chess piece.
    public static String chessPieceMovement(String piece) {
        return switch (piece.toLowerCase()) {
            case "king" -> "Moves one square in any direction";
            case "queen" -> "Moves diagonally, horizontally, or vertically any number of squares";
            case "rook" -> "Moves horizontally or vertically any number of squares";
            case "bishop" -> "Moves diagonally any number of squares";
            case "knight" -> "Moves in an 'L' shape: two squares in one direction and then one square perpendicular";
            case "pawn" -> "Moves forward one square (or two on its first move) and captures diagonally";
            default -> "Unknown chess piece";
        };
    }

    // 19. Identify the operating system based on a provided OS name.
    public static String identifyOS(String osName) {
        String os = osName.toLowerCase();
        if (os.contains("win")) {
            return "Windows";
        } else if (os.contains("mac")) {
            return "macOS";
        } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
            return "Linux";
        } else {
            return "Unknown OS";
        }
    }

    // 20. Calculate a fee based on the vehicle type.
    public static double calculateVehicleFee(String vehicleType) {
        return switch (vehicleType.toLowerCase()) {
            case "car" -> 10.0;
            case "truck" -> 20.0;
            case "motorcycle" -> 5.0;
            case "bus" -> 15.0;
            default -> throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
        };
        }

    // 21. Process user input by squaring the value (example processing)
    public static int processUserInput(int input) {
        return input * input;
    }

    // 22. Swap two numbers using arithmetic operations without a temporary variable.
    public static int[] swapNumbers(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        return new int[]{a, b};
    }

    // 23. Return an array of the first 10 prime numbers.
    public static int[] getFirst10Primes() {
        return new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    }

    // 24. Generate a random number between 1 and 100.
    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    // 25. Get the current LocalDateTime formatted as "yyyy-MM-dd HH:mm:ss".
    public static String getFormattedCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    // 26. Format a full name as "Last Name, First Name".
    public static String formatName(String fullName) {
        String[] parts = fullName.trim().split("\\s+");
        if (parts.length < 2) {
            return fullName; // Not enough parts to reformat
        }
        String firstName = parts[0];
        String lastName = parts[parts.length - 1];
        return lastName + ", " + firstName;
    }

    // 27. Reverse the words in a sentence using concatenation.
    public static String reverseWords(String sentence) {
        String[] words = sentence.split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }
        return reversed.toString();
    }

    // 28. Generate a personalized URL based on the user's input.
    public static String generatePersonalizedURL(String username) {
        return "www." + username.toLowerCase() + ".com";
    }

    // 29. Construct a log message with a timestamp, username, and action taken.
    public static String createLogMessage(String username, String action) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return "[" + timestamp + "] User: " + username + " performed action: " + action;
    }

    // 30. Encode a string by shifting each character's ASCII value by 3.
    public static String encodeString(String input) {
        StringBuilder encoded = new StringBuilder();
        for (char c : input.toCharArray()) {
            encoded.append((char)(c + 3));
        }
        return encoded.toString();
    }

    // Main method to demonstrate the solutions with sample inputs.
    public static void main(String[] args) {
        // 1. Triangle type
        System.out.println("1. Triangle Type: " + determineTriangleType(3, 3, 3));  // Equilateral
        System.out.println("1. Triangle Type: " + determineTriangleType(3, 4, 5));  // Scalene

        // 2. Number properties
        System.out.println("2. Number Properties: " + checkNumberProperties(7));
        System.out.println("2. Number Properties: " + checkNumberProperties(-4));

        // 3. Employee bonus
        System.out.println("3. Employee Bonus: $" + calculateBonus(50000, 4));
        System.out.println("3. Employee Bonus: $" + calculateBonus(50000, 7));
        System.out.println("3. Employee Bonus: $" + calculateBonus(50000, 12));

        // 4. Password validation
        System.out.println("4. Password Valid (Abcdef1!): " + isPasswordValid("Abcdef1!"));
        System.out.println("4. Password Valid (abcdefg): " + isPasswordValid("abcdefg"));

        // 5. Greeting based on time
        System.out.println("5. Greeting at 10:00: " + getGreeting(10));
        System.out.println("5. Greeting at 20:00: " + getGreeting(20));

        // 6. Reverse number and palindrome check
        int number = 121;
        System.out.println("6. Reversed Number of " + number + ": " + reverseNumber(number));
        System.out.println("6. Is " + number + " a Palindrome? " + isPalindromeNumber(number));

        // 7. BMI calculation
        System.out.println("7. BMI Category (70kg, 1.75m): " + calculateBMICategory(70, 1.75));

        // 8. Electricity bill calculation
        System.out.println("8. Electricity Bill for 350 units: $" + calculateElectricityBill(350));

        // 9. Loan eligibility
        System.out.println("9. Loan Eligibility (40000, 700, 1): " + isEligibleForLoan(40000, 700, 1));

        // 10. Rock-Paper-Scissors game
        System.out.println("10. Rock-Paper-Scissors: " + playRockPaperScissors("Rock"));

        // 11. Digit to word
        System.out.println("11. Digit to Word for 5: " + digitToWord(5));

        // 12. Currency conversion
        System.out.println("12. Currency Conversion (100 USD to EUR): €" + convertCurrency(100, "EUR"));

        // 13. Menu item price
        System.out.println("13. Menu Price for Pizza: $" + getMenuItemPrice("Pizza"));

        // 14. Grade from percentage
        System.out.println("14. Grade for 85%: " + gradeFromPercentage(85));

        // 15. Zodiac sign
        System.out.println("15. Zodiac Sign for 3/25: " + getZodiacSign(3, 25));

        // 16. Shape classification
        System.out.println("16. Shape for 5 sides: " + classifyShape(5));

        // 17. Apply discount
        System.out.println("17. Discounted Amount for VIP on $100: $" + applyDiscount(100, "VIP"));

        // 18. Chess piece movement
        System.out.println("18. Chess Movement for Knight: " + chessPieceMovement("Knight"));

        // 19. Identify OS
        System.out.println("19. Identified OS for 'Ubuntu Linux': " + identifyOS("Ubuntu Linux"));

        // 20. Vehicle fee calculation
        System.out.println("20. Vehicle Fee for Truck: $" + calculateVehicleFee("Truck"));

        // 21. Process user input (square of the input)
        System.out.println("21. Processed User Input (Square of 5): " + processUserInput(5));

        // 22. Swap two numbers
        int[] swapped = swapNumbers(10, 20);
        System.out.println("22. Swapped Numbers: a = " + swapped[0] + ", b = " + swapped[1]);

        // 23. First 10 prime numbers
        System.out.print("23. First 10 Primes: ");
        for (int prime : getFirst10Primes()) {
            System.out.print(prime + " ");
        }
        System.out.println();

        // 24. Generate a random number between 1 and 100
        System.out.println("24. Random Number (1-100): " + generateRandomNumber());

        // 25. Formatted current date and time
        System.out.println("25. Current DateTime: " + getFormattedCurrentDateTime());

        // 26. Format full name
        System.out.println("26. Formatted Name for 'John Doe': " + formatName("John Doe"));

        // 27. Reverse words in a sentence
        System.out.println("27. Reversed Sentence: " + reverseWords("Hello world from Java"));

        // 28. Generate personalized URL
        System.out.println("28. Personalized URL for 'User123': " + generatePersonalizedURL("User123"));

        // 29. Log message creation
        System.out.println("29. Log Message: " + createLogMessage("JohnDoe", "Logged in"));

        // 30. Encode a string using ASCII manipulation
        System.out.println("30. Encoded String for 'HelloWorld': " + encodeString("HelloWorld"));
    }
}
