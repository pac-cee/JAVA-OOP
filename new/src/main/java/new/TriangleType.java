/*
// 1. Write a Java program to find the type of a triangle based on the three sides.
 
public class TriangleType {
    public static void main(String[] args) {
       try(Scanner scanner = new Scanner (System.in);){
        System.out.println("Enter the three sides of the triangle:");
        int side1 = scanner.nextInt();
        int side2 = scanner.nextInt();
        int side3 = scanner.nextInt();
       
        int side1 = 5, side2 = 5, side3 = 5;
        if (side1 == side2 && side2 == side3) {
            System.out.println("Equilateral Triangle");
        } else if (side1 == side2 || side2 == side3 || side1 == side3) {
            System.out.println("Isosceles Triangle");
        } else {
            System.out.println("Scalene Triangle");
        }
       }
       
    
    }
}

 /2. Write a Java program to check if a number is positive, negative, or zero.

public class NumberCheck {
    public static void main(String[] args) {
        int number = 7;
        if (number > 0) {
            System.out.println("Positive");
        } else if (number < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }

        if (number % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
}

/3
public class EmployeeBonus {
    public static void main(String[] args) {
        double salary = 50000;
        int yearsOfService = 7;
        double bonus = 0;

        if (yearsOfService < 5) {
            bonus = salary * 0.05;
        } else if (yearsOfService <= 10) {
            bonus = salary * 0.10;
        } else {
            bonus = salary * 0.15;
        }

        System.out.println("Bonus: $" + bonus);
    }
}


public class PasswordSecurity {
    public static void main(String[] args) {
        String password = "Password123!";
        boolean hasNumber = password.matches(".\\d.");
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasSpecialChar = !password.matches("[A-Za-z0-9]*");

        if (password.length() >= 8 && hasNumber && hasUppercase && hasSpecialChar) {
            System.out.println("Password meets security standards.");
        } else {
            System.out.println("Password does not meet security standards.");
        }
    }
}


public class TimeGreeting {
    public static void main(String[] args) {
        int time = 14; // Example time
        if (time >= 0 && time <= 5) {
            System.out.println("Good Night");
        } else if (time >= 6 && time <= 11) {
            System.out.println("Good Morning");
        } else if (time >= 12 && time <= 17) {
            System.out.println("Good Afternoon");
        } else if (time >= 18 && time <= 23) {
            System.out.println("Good Evening");
        } else {
            System.out.println("Invalid time");
        }
    }
}


public class PalindromeCheck {
    public static void main(String[] args) {
        int number = 121;
        int reversed = 0, original = number;

        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        if (original == reversed) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }
}


public class BMICalculation {
    public static void main(String[] args) {
        double height = 1.75; // in meters
        double weight = 70; // in kg
        double bmi = weight / (height * height);

        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            System.out.println("Normal");
        } else if (bmi >= 25 && bmi <= 29.9) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }
}


public class ElectricityBill {
    public static void main(String[] args) {
        int units = 250;
        double bill = 0;

        if (units <= 100) {
            bill = units * 0.50;
        } else if (units <= 300) {
            bill = 100 * 0.50 + (units - 100) * 0.75;
        } else {
            bill = 100 * 0.50 + 200 * 0.75 + (units - 300) * 1.20;
        }

        System.out.println("Electricity Bill: $" + bill);
    }
}


public class LoanEligibility {
    public static void main(String[] args) {
        double income = 50000;
        int creditScore = 700;
        boolean hasExistingLoans = false;

        if (income >= 30000 && creditScore >= 650 && !hasExistingLoans) {
            System.out.println("Eligible for Loan");
        } else {
            System.out.println("Not Eligible for Loan");
        }
    }
}


import java.util.Random;
import java.util.Scanner;

public class SimpleGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Enter your choice (0 for Rock, 1 for Paper, 2 for Scissors):");
        int userChoice = scanner.nextInt();
        int computerChoice = random.nextInt(3);

        System.out.println("Computer chose: " + computerChoice);

        if (userChoice == computerChoice) {
            System.out.println("It's a tie!");
        } else if ((userChoice == 0 && computerChoice == 2) ||
                   (userChoice == 1 && computerChoice == 0) ||
                   (userChoice == 2 && computerChoice == 1)) {
            System.out.println("You win!");
        } else {
            System.out.println("Computer wins!");
        }
    }
}



public class DigitToWord {
    public static void main(String[] args) {
        int digit = 5;
        String[] words = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        System.out.println(words[digit]);
    }
}


import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount in USD:");
        double usd = scanner.nextDouble();

        System.out.println("Select currency to convert to (EUR, GBP, INR):");
        String currency = scanner.next();

        double convertedAmount = 0;
        switch (currency.toUpperCase()) {
            case "EUR":
                convertedAmount = usd * 0.85;
                break;
            case "GBP":
                convertedAmount = usd * 0.72;
                break;
            case "INR":
                convertedAmount = usd * 75.0;
                break;
            default:
                System.out.println("Invalid currency");
                return;
        }

        System.out.println("Converted Amount: " + convertedAmount + " " + currency);
    }
}


import java.util.Scanner;

public class MenuPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a menu item (1: Burger, 2: Pizza, 3: Pasta):");
        int choice = scanner.nextInt();

        double price = 0;
        switch (choice) {
            case 1:
                price = 5.99;
                break;
            case 2:
                price = 8.99;
                break;
            case 3:
                price = 7.49;
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        System.out.println("Price: $" + price);
    }
}


public class PercentageToGrade {
    public static void main(String[] args) {
        double percentage = 85;
        String grade;

        if (percentage >= 90) {
            grade = "A";
        } else if (percentage >= 80) {
            grade = "B";
        } else if (percentage >= 70) {
            grade = "C";
        } else if (percentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("Grade: " + grade);
    }
}


public class ZodiacSign {
    public static void main(String[] args) {
        int month = 3, day = 21;
        String zodiacSign = "";

        if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) {
            zodiacSign = "Aquarius";
        } else if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) {
            zodiacSign = "Pisces";
        } // Add other zodiac signs similarly...

        System.out.println("Zodiac Sign: " + zodiacSign);
    }
}


public class ShapeClassification {
    public static void main(String[] args) {
        int sides = 5;
        String shape;

        switch (sides) {
            case 3:
                shape = "Triangle";
                break;
            case 4:
                shape = "Quadrilateral";
                break;
            case 5:
                shape = "Pentagon";
                break;
            case 6:
                shape = "Hexagon";
                break;
            default:
                shape = "Unknown Shape";
        }

        System.out.println("Shape: " + shape);
    }
}


public class CustomerDiscounts {
    public static void main(String[] args) {
        String customerCategory = "Premium";
        double discount = 0;

        switch (customerCategory) {
            case "Regular":
                discount = 0.10;
                break;
            case "Premium":
                discount = 0.20;
                break;
            case "VIP":
                discount = 0.30;
                break;
            default:
                discount = 0.0;
        }

        System.out.println("Discount: " + (discount * 100) + "%");
    }
}


public class ChessPieceMovement {
    public static void main(String[] args) {
        String piece = "Queen";
        String movement = "";

        switch (piece) {
            case "Pawn":
                movement = "Moves forward one square.";
                break;
            case "Rook":
                movement = "Moves horizontally or vertically any number of squares.";
                break;
            case "Knight":
                movement = "Moves in an L-shape.";
                break;
            case "Bishop":
                movement = "Moves diagonally any number of squares.";
                break;
            case "Queen":
                movement = "Moves horizontally, vertically, or diagonally any number of squares.";
                break;
            case "King":
                movement = "Moves one square in any direction.";
                break;
            default:
                movement = "Unknown piece.";
        }

        System.out.println(movement);
    }
}


public class OSIdentification {
    public static void main(String[] args) {
        String os = "macOS";

        switch (os) {
            case "Windows":
                System.out.println("Windows OS");
                break;
            case "macOS":
                System.out.println("macOS");
                break;
            case "Linux":
                System.out.println("Linux OS");
                break;
            default:
                System.out.println("Unknown OS");
        }
    }
}


public class VehicleFee {
    public static void main(String[] args) {
        String vehicleType = "truck";
        double fee = 0;

        switch (vehicleType) {
            case "car":
                fee = 5.0;
                break;
            case "truck":
                fee = 10.0;
                break;
            case "motorcycle":
                fee = 3.0;
                break;
            case "bus":
                fee = 15.0;
                break;
            default:
                fee = 0.0;
        }

        System.out.println("Fee: $" + fee);
    }
}


import java.util.Scanner;

public class UserInputProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = scanner.nextInt();

        System.out.println("You entered: " + number);
    }
}


public class NumberSwapping {
    public static void main(String[] args) {
        int a = 5, b = 10;
        System.out.println("Before swapping: a = " + a + ", b = " + b);

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("After swapping: a = " + a + ", b = " + b);
    }
}

public class PrimeNumbersArray {
    public static void main(String[] args) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

        for (int prime : primes) {
            System.out.print(prime + " ");
        }
    }
}


import java.util.Random;

public class RandomNumberGeneration {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        System.out.println("Random Number: " + randomNumber);
    }
}

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatting {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = now.format(formatter);
        System.out.println("Formatted Date: " + formattedDate);
    }
}



import java.util.Scanner;

public class NameFormatting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your full name (First Last):");
        String fullName = scanner.nextLine();

        String[] names = fullName.split(" ");
        String formattedName = names[1] + ", " + names[0];
        System.out.println("Formatted Name: " + formattedName);
    }
}


public class SentenceReversal {
    public static void main(String[] args) {
        String sentence = "Hello World Java";
        String[] words = sentence.split(" ");
        String reversedSentence = "";

        for (int i = words.length - 1; i >= 0; i--) {
            reversedSentence += words[i] + " ";
        }

        System.out.println("Reversed Sentence: " + reversedSentence.trim());
    }
}



import java.util.Scanner;

public class PersonalizedURL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username:");
        String username = scanner.nextLine();

        String url = "www." + username + ".com";
        System.out.println("Personalized URL: " + url);
    }
}
 */