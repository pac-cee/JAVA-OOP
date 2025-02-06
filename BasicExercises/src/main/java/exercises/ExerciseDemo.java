package exercises;

import exercises.arrays.ArrayOperations;
import exercises.finance.FinancialCalculator;
import exercises.formatting.StringFormatter;
import exercises.game.NumberGuessingGame;
import exercises.geometry.ShapeClassifier;
import exercises.health.HealthCalculator;
import exercises.input.UserInputProcessor;
import exercises.numbers.NumberOperations;
import exercises.random.RandomGenerator;
import exercises.restaurant.RestaurantSystem;
import exercises.security.SecurityValidator;
import exercises.time.TimeGreeting;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class ExerciseDemo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // 1. Triangle Type
            System.out.println("\n=== Triangle Classifier ===");
            System.out.println(ShapeClassifier.determineTriangleType(3, 3, 3));  // Equilateral
            
            // 2. Number Properties
            System.out.println("\n=== Number Properties ===");
            System.out.println(NumberOperations.checkNumber(-4));  // negative and even
            
            // 3. Employee Bonus
            System.out.println("\n=== Employee Bonus ===");
            System.out.println("Bonus for 11 years: $" + FinancialCalculator.calculateBonus(50000, 11));  // 7500.0
            
            // 4. Password Validator
            System.out.println("\n=== Password Validator ===");
            System.out.println("Is 'Pass123!' valid? " + SecurityValidator.isPasswordValid("Pass123!"));  // true
            
            // 5. Time Greeting
            System.out.println("\n=== Time Greeting ===");
            System.out.println("Greeting at 14:00: " + TimeGreeting.getGreeting(14));  // Good Afternoon
            
            // 5. BMI Calculator
            System.out.println("\n=== BMI Calculator ===");
            System.out.println("BMI Category: " + HealthCalculator.calculateBMI(70, 1.75));  // Normal
            
            // 6. Palindrome Check
            System.out.println("\n=== Palindrome Check ===");
            System.out.println("Is 12321 palindrome? " + NumberOperations.isPalindrome(12321));  // true
            
            // 7. Electricity Bill
            System.out.println("\n=== Electricity Bill ===");
            System.out.println("Bill for 250 units: $" + FinancialCalculator.calculateElectricityBill(250));  // 162.5
            
            // 8. Loan Eligibility
            System.out.println("\n=== Loan Eligibility ===");
            System.out.println("Eligible for loan? " + 
                FinancialCalculator.isEligibleForLoan(35000, 750, 0));  // true
            
            // 9. Number to Word
            System.out.println("\n=== Number to Word ===");
            System.out.println("5 in words: " + NumberOperations.numberToWord(5));  // Five
            
            // 10. Currency Converter
            System.out.println("\n=== Currency Converter ===");
            System.out.println("100 USD to EUR: " + 
                FinancialCalculator.convertCurrency(100, "USD", "EUR"));
            
            // 11. Restaurant Menu
            System.out.println("\n=== Restaurant Menu ===");
            System.out.println("Price of burger: $" + RestaurantSystem.getPrice("burger"));
            
            // 12. Grade Calculator
            System.out.println("\n=== Grade Calculator ===");
            System.out.println("Grade for 85%: " + NumberOperations.getGrade(85));  // B
            
            // 13. Zodiac Sign
            System.out.println("\n=== Zodiac Sign ===");
            System.out.println("Born on March 15: " + HealthCalculator.getZodiacSign(3, 15));
            
            // 14. Shape Classifier
            System.out.println("\n=== Shape Classifier ===");
            System.out.println("5 sides is a: " + ShapeClassifier.classifyShape(5));  // Pentagon
            
            // 15. Customer Discount
            System.out.println("\n=== Customer Discount ===");
            System.out.println("VIP discount on $100: $" + 
                FinancialCalculator.calculateDiscount(100, "VIP"));
            
            // 16. Chess Piece Movement
            System.out.println("\n=== Chess Piece Movement ===");
            System.out.println("Queen moves: " + ShapeClassifier.getChessPieceMovement("queen"));
            
            // 17. OS Identifier
            System.out.println("\n=== OS Identifier ===");
            System.out.println("Current OS: " + SecurityValidator.identifyOS(System.getProperty("os.name")));
            
            // 18. Vehicle Fee
            System.out.println("\n=== Vehicle Fee ===");
            System.out.println("Fee for truck: $" + FinancialCalculator.getVehicleFee("truck"));
            
            // 19. Number Guessing Game
            System.out.println("\n=== Number Guessing Game ===");
            System.out.println("Would you like to play the number guessing game? (yes/no)");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                NumberGuessingGame.playGame(scanner);
            }

            // 21. Process User Input
            System.out.println("\n=== Process User Input ===");
            System.out.println("Processed value: " + UserInputProcessor.processNumericInput(scanner));

            // 22. Swap Numbers
            System.out.println("\n=== Swap Numbers ===");
            int[] numbers = {5, 10};
            System.out.println("Before swap: " + numbers[0] + ", " + numbers[1]);
            UserInputProcessor.swapNumbers(numbers);
            System.out.println("After swap: " + numbers[0] + ", " + numbers[1]);

            // 23. Prime Numbers Array
            System.out.println("\n=== First 10 Prime Numbers ===");
            int[] primes = ArrayOperations.generateFirstNPrimes(10);
            System.out.println(Arrays.toString(primes));

            // 24. Random Number
            System.out.println("\n=== Random Number ===");
            System.out.println("Random number (1-100): " + RandomGenerator.generateNumber(1, 100));

            // 25. DateTime Formatting
            System.out.println("\n=== DateTime Formatting ===");
            System.out.println("Formatted date: " + StringFormatter.formatDateTime(LocalDateTime.now()));

            // 26. Name Formatting
            System.out.println("\n=== Name Formatting ===");
            System.out.println(StringFormatter.formatName("John", "Doe"));

            // 27. Reverse Words
            System.out.println("\n=== Reverse Words ===");
            System.out.println(StringFormatter.reverseWords("Hello World Java"));

            // 28. URL Generation
            System.out.println("\n=== URL Generation ===");
            System.out.println(StringFormatter.generateURL("John Doe"));

            // 29. Log Message
            System.out.println("\n=== Log Message ===");
            System.out.println(StringFormatter.generateLogMessage("admin", "login"));

            // 30. String Encoding
            System.out.println("\n=== String Encoding ===");
            System.out.println(StringFormatter.encodeString("Hello"));
        }
    }
}
