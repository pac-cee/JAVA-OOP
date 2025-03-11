package ClassWork;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class ImproveExercises {

    
    public static String determineTriangleType(double a, double b, double c) {
        
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

   
    public static String checkNumberProperties(int num) {
        StringBuilder result = new StringBuilder();
        result.append(num > 0 ? "Positive" : (num < 0 ? "Negative" : "Zero"));
        result.append(" and ");
        result.append((num % 2 == 0) ? "Even" : "Odd");
        return result.toString();
    }


    
    public static double calculateBonus(double salary, int yearsOfService) {
        if (yearsOfService < 5) {
            return salary * 0.05;
        } else if (yearsOfService <= 10) {
            return salary * 0.10;
        } else {
            return salary * 0.15;
        }
    }

    
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

    
    public static int reverseNumber(int num) {
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }

   
    public static boolean isPalindromeNumber(int num) {
        String original = Integer.toString(num);
        String reversed = new StringBuilder(original).reverse().toString();
        return original.equals(reversed);
    }

   
    public static String calculateBMICategory(double weight, double height) {
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

    public static double calculateElectricityBill(int units) {
        double bill = 0;
        if (units <= 100) {
            bill = units * 0.50;
        } else if (units <= 300) {
            bill = 100 * 0.50 + (units - 100) * 0.75;
        } else {
            bill = 100 * 0.50 + 200 * 0.75 + (units - 300) * 1.20;
        }
        return bill;
    }

    
    public static boolean isEligibleForLoan(double income, int creditScore, int existingLoans) {
        return (income >= 30000 && creditScore >= 650 && existingLoans < 2);
    }

    
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

    
    public static double convertCurrency(double amount, String targetCurrency) {
        return switch (targetCurrency.toUpperCase()) {
            case "USD" -> amount;
            case "EUR" -> amount * 0.85;
            case "GBP" -> amount * 0.75;
            case "INR" -> amount * 74.0;
            default -> throw new IllegalArgumentException("Unsupported currency: " + targetCurrency);
        };
    }


    public static double getMenuItemPrice(String menuItem) {
        return switch (menuItem.toLowerCase()) {
            case "burger" -> 5.99;
            case "pizza" -> 8.99;
            case "salad" -> 4.99;
            case "soda" -> 1.99;
            case "pasta" -> 10.99;
            case "fries" -> 3.99;
            case "drinks" -> 2.99;
            case "sandwich" -> 6.99;
            case "steak" -> 15.99;
            case "chicken" -> 12.99;
            case "fish" -> 14.99;
            case "veggies" -> 7.99;
            case "salmon" -> 18.99;
            case "rice" -> 4.99;
            case "beans" -> 0.99;
            case "soup" -> 3.99;
            case "bread" -> 1.99;
            default -> throw new IllegalArgumentException("Menu item not found: " + menuItem);
        };
    }

    
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

    public static double applyDiscount(double amount, String customerCategory) {
        return switch (customerCategory.toLowerCase()) {
            case "regular" -> amount * 0.95;
            case "premium" -> amount * 0.90;
            case "vip" -> amount * 0.85;
            default -> amount;
        };
    }

    
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

    
    public static double calculateVehicleFee(String vehicleType) {
        return switch (vehicleType.toLowerCase()) {
            case "car" -> 10.0;
            case "truck" -> 20.0;
            case "motorcycle" -> 5.0;
            case "bus" -> 15.0;
            default -> throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
        };
    }

    
    public static int processUserInput(int input) {
        return input * input;
    }

    
    public static int[] swapNumbers(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        return new int[]{a, b};
    }

    
    public static int[] getFirst10Primes() {
        return new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    }

    
    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

 
    public static String getFormattedCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

   
    public static String formatName(String fullName) {
        String[] parts = fullName.trim().split("\\s+");
        if (parts.length < 2) {
            return fullName; // Not enough parts to reformat
        }
        String firstName = parts[0];
        String lastName = parts[parts.length - 1];
        return lastName + ", " + firstName;
    }

   
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

    
    public static String generatePersonalizedURL(String username) {
        return "www." + username.toLowerCase() + ".com";
    }

    
    public static String createLogMessage(String username, String action) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return "[" + timestamp + "] User: " + username + " performed action: " + action;
    }

    
    public static String encodeString(String input) {
        StringBuilder encoded = new StringBuilder();
        for (char c : input.toCharArray()) {
            encoded.append((char)(c + 3));
        }
        return encoded.toString();
    }

   
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice = 0;

            while (true) {
         
            System.out.println("==================================");
            System.out.println("Choose an exercise to run (1-30) or 0 to exit:");
            System.out.println(" 1.  Determine Triangle Type");
            System.out.println(" 2.  Check Number Properties");
            System.out.println(" 3.  Calculate Employee Bonus");
            System.out.println(" 4.  Validate Password");
            System.out.println(" 5.  Get Greeting by Hour");
            System.out.println(" 6.  Reverse Number & Check Palindrome");
            System.out.println(" 7.  Calculate BMI Category");
            System.out.println(" 8.  Calculate Electricity Bill");
            System.out.println(" 9.  Check Loan Eligibility");
            System.out.println("10.  Play Rock-Paper-Scissors");
            System.out.println("11.  Convert Digit to Word");
            System.out.println("12.  Convert Currency");
            System.out.println("13.  Get Menu Item Price");
            System.out.println("14.  Grade from Percentage");
            System.out.println("15.  Determine Zodiac Sign");
            System.out.println("16.  Classify Shape by Sides");
            System.out.println("17.  Apply Discount");
            System.out.println("18.  Chess Piece Movement");
            System.out.println("19.  Identify Operating System");
            System.out.println("20.  Calculate Vehicle Fee");
            System.out.println("21.  Process User Input (Square it)");
            System.out.println("22.  Swap Two Numbers");
            System.out.println("23.  Display First 10 Prime Numbers");
            System.out.println("24.  Generate a Random Number (1-100)");
            System.out.println("25.  Show Current Date and Time");
            System.out.println("26.  Format Full Name");
            System.out.println("27.  Reverse Words in a Sentence");
            System.out.println("28.  Generate Personalized URL");
            System.out.println("29.  Create Log Message");
            System.out.println("30.  Encode a String");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 0) {
                System.out.println("Exiting. Goodbye!");
                break;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter side a: ");
                    double a = scanner.nextDouble();
                    System.out.print("Enter side b: ");
                    double b = scanner.nextDouble();
                    System.out.print("Enter side c: ");
                    double c = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Triangle Type: " + determineTriangleType(a, b, c));
                }
                case 2 -> {
                    System.out.print("Enter an integer: ");
                    int num = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Number Properties: " + checkNumberProperties(num));
                }
                case 3 -> {
                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();
                    System.out.print("Enter years of service: ");
                    int years = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Employee Bonus: $" + calculateBonus(salary, years));
                }
                case 4 -> {
                    System.out.print("Enter a password: ");
                    String password = scanner.nextLine();
                    System.out.println("Password Valid: " + isPasswordValid(password));
                }
                case 5 -> {
                    System.out.print("Enter the hour (0-23): ");
                    int hour = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Greeting: " + getGreeting(hour));
                }
                case 6 -> {
                    System.out.print("Enter a number: ");
                    int number = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Reversed Number: " + reverseNumber(number));
                    System.out.println("Is Palindrome? " + isPalindromeNumber(number));
                }
                case 7 -> {
                    System.out.print("Enter weight in kg: ");
                    double weight = scanner.nextDouble();
                    System.out.print("Enter height in meters: ");
                    double height = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("BMI Category: " + calculateBMICategory(weight, height));
                }
                case 8 -> {
                    System.out.print("Enter units consumed: ");
                    int units = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Electricity Bill: $" + calculateElectricityBill(units));
                }
                case 9 -> {
                    System.out.print("Enter income: ");
                    double income = scanner.nextDouble();
                    System.out.print("Enter credit score: ");
                    int creditScore = scanner.nextInt();
                    System.out.print("Enter number of existing loans: ");
                    int loans = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Loan Eligibility: " + isEligibleForLoan(income, creditScore, loans));
                }
                case 10 -> {
                    System.out.print("Enter your move (Rock/Paper/Scissors): ");
                    String move = scanner.nextLine();
                    System.out.println("Game Result: " + playRockPaperScissors(move));
                }
                case 11 -> {
                    System.out.print("Enter a digit (0-9): ");
                    int digit = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digit to Word: " + digitToWord(digit));
                }
                case 12 -> {
                    System.out.print("Enter amount in USD: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter target currency (USD, EUR, GBP, INR): ");
                    String currency = scanner.nextLine();
                    try {
                        System.out.println("Converted Amount: " + convertCurrency(amount, currency) + " " + currency.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 13 -> {
                    System.out.print("Enter menu item (Burger, Pizza, Salad, Soda, Pasta, Fries, Drinks, Sandwich, Steak, Chicken, Fish, Veggies, Salmon, Rice, Beans, Soup, Bread): ");
                    String menuItem = scanner.nextLine();
                    try {
                        System.out.println("Menu Price: $" + getMenuItemPrice(menuItem));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 14 -> {
                    System.out.print("Enter percentage: ");
                    double perc = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Grade: " + gradeFromPercentage(perc));
                }
                case 15 -> {
                    System.out.print("Enter birth month (1-12): ");
                    int month = scanner.nextInt();
                    System.out.print("Enter birth day: ");
                    int day = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Zodiac Sign: " + getZodiacSign(month, day));
                }
                case 16 -> {
                    System.out.print("Enter number of sides: ");
                    int sides = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Shape: " + classifyShape(sides));
                }
                case 17 -> {
                    System.out.print("Enter amount: ");
                    double amt = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter customer category (Regular, Premium, VIP): ");
                    String custCategory = scanner.nextLine();
                    System.out.println("Discounted Amount: $" + applyDiscount(amt, custCategory));
                }
                case 18 -> {
                    System.out.print("Enter chess piece name: ");
                    String piece = scanner.nextLine();
                    System.out.println("Movement: " + chessPieceMovement(piece));
                }
                case 19 -> {
                    System.out.print("Enter OS name: ");
                    String osName = scanner.nextLine();
                    System.out.println("Identified OS: " + identifyOS(osName));
                }
                case 20 -> {
                    System.out.print("Enter vehicle type (Car, Truck, Motorcycle, Bus): ");
                    String vehicleType = scanner.nextLine();
                    try {
                        System.out.println("Vehicle Fee: $" + calculateVehicleFee(vehicleType));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 21 -> {
                    System.out.print("Enter an integer: ");
                    int inputNum = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Processed (Squared): " + processUserInput(inputNum));
                }
                case 22 -> {
                    System.out.print("Enter first number: ");
                    int num1 = scanner.nextInt();
                    System.out.print("Enter second number: ");
                    int num2 = scanner.nextInt();
                    scanner.nextLine();
                    int[] swappedArr = swapNumbers(num1, num2);
                    System.out.println("Swapped Numbers: a = " + swappedArr[0] + ", b = " + swappedArr[1]);
                }
                case 23 -> {
                    System.out.print("First 10 Prime Numbers: ");
                    for (int prime : getFirst10Primes()) {
                        System.out.print(prime + " ");
                    }
                    System.out.println();
                }
                case 24 -> System.out.println("Random Number (1-100): " + generateRandomNumber());
                case 25 -> System.out.println("Current Date and Time: " + getFormattedCurrentDateTime());
                case 26 -> {
                    System.out.print("Enter full name: ");
                    String fullName = scanner.nextLine();
                    System.out.println("Formatted Name: " + formatName(fullName));
                }
                case 27 -> {
                    System.out.print("Enter a sentence: ");
                    String sentence = scanner.nextLine();
                    System.out.println("Reversed Sentence: " + reverseWords(sentence));
                }
                case 28 -> {
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.println("Personalized URL: " + generatePersonalizedURL(username));
                }
                case 29 -> {
                    System.out.print("Enter username: ");
                    String userForLog = scanner.nextLine();
                    System.out.print("Enter action: ");
                    String action = scanner.nextLine();
                    System.out.println("Log Message: " + createLogMessage(userForLog, action));
                }
                case 30 -> {
                    System.out.print("Enter a string to encode: ");
                    String inputString = scanner.nextLine();
                    System.out.println("Encoded String: " + encodeString(inputString));
                }
    
                default -> System.out.println("Invalid choice. Please try again.");
            }
            System.out.println(); 
        }
        }
    }
}
