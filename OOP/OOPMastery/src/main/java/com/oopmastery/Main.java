package com.oopmastery;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.oopmastery.encapsulation.BankAccount;
import com.oopmastery.encapsulation.ImmutablePerson;
import com.oopmastery.inheritance.shape.Circle;
import com.oopmastery.inheritance.shape.Rectangle;
import com.oopmastery.inheritance.shape.Shape;
import com.oopmastery.polymorphism.interfaces.CreditCardProcessor;
import com.oopmastery.polymorphism.interfaces.PayPalProcessor;
import com.oopmastery.polymorphism.interfaces.PaymentProcessor;
import com.oopmastery.polymorphism.runtime.AudioPlayer;
import com.oopmastery.polymorphism.runtime.MediaPlayer;
import com.oopmastery.polymorphism.runtime.VideoPlayer;

/**
 * Main class demonstrating all OOP concepts:
 * 1. Encapsulation
 * 2. Inheritance
 * 3. Polymorphism (both runtime and interface-based)
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void main(String[] args) {
        System.out.println("=== OOP Mastery Demonstration ===\n");
        
        while (true) {
            System.out.println("\nChoose a demonstration:");
            System.out.println("1. Encapsulation");
            System.out.println("2. Inheritance");
            System.out.println("3. Runtime Polymorphism");
            System.out.println("4. Interface Polymorphism");
            System.out.println("5. Exit");
            
            System.out.print("\nEnter your choice (1-5): ");
            int choice = getIntInput(1, 5);
            
            System.out.println();
            switch (choice) {
                case 1:
                    demonstrateEncapsulation();
                    break;
                case 2:
                    demonstrateInheritance();
                    break;
                case 3:
                    demonstrateRuntimePolymorphism();
                    break;
                case 4:
                    demonstrateInterfacePolymorphism();
                    break;
                case 5:
                    System.out.println("Thank you for using OOP Mastery Demonstration!");
                    scanner.close();
                    return;
            }
            
            System.out.println("\n" + "=".repeat(50));
        }
    }

    private static void demonstrateEncapsulation() {
        System.out.println("Demonstrating Encapsulation");
        System.out.println("-".repeat(30));

        // BankAccount demonstration
        System.out.print("Enter account holder name: ");
        String accountHolder = scanner.nextLine();
        
        System.out.print("Enter initial balance: ");
        BigDecimal initialBalance = getBigDecimalInput();

        BankAccount account = new BankAccount(accountHolder, initialBalance);
        System.out.println("\nCreated account: " + account);

        System.out.print("\nEnter deposit amount: ");
        BigDecimal depositAmount = getBigDecimalInput();
        account.deposit(depositAmount);
        System.out.println("After deposit: " + account);

        System.out.print("\nEnter withdrawal amount: ");
        BigDecimal withdrawalAmount = getBigDecimalInput();
        account.withdraw(withdrawalAmount);
        System.out.println("After withdrawal: " + account);

        // ImmutablePerson demonstration
        System.out.println("\nCreating an Immutable Person");
        System.out.print("Enter person name: ");
        String personName = scanner.nextLine();
        
        System.out.print("Enter birth date (yyyy-MM-dd): ");
        LocalDate birthDate = getDateInput();
        
        System.out.print("Enter street address: ");
        String street = scanner.nextLine();
        
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        
        System.out.print("Enter country: ");
        String country = scanner.nextLine();
        
        System.out.print("Enter postal code: ");
        String postalCode = scanner.nextLine();

        ImmutablePerson.Address address = new ImmutablePerson.Address(
            street, city, country, postalCode
        );

        List<String> qualifications = Arrays.asList("BSc", "MSc");
        
        ImmutablePerson person = new ImmutablePerson(
            personName,
            birthDate,
            qualifications,
            address
        );

        System.out.println("\nCreated person: " + person);
        System.out.println("Person's address: " + person.getAddress());
        System.out.println("Person's qualifications: " + person.getQualifications());
    }

    private static void demonstrateInheritance() {
        System.out.println("Demonstrating Inheritance");
        System.out.println("-".repeat(30));

        // Create circle
        System.out.println("\nCreating a Circle:");
        System.out.print("Enter radius: ");
        double radius = getDoubleInput();
        
        System.out.print("Enter color: ");
        String circleColor = scanner.nextLine();
        
        System.out.print("Is the circle filled? (true/false): ");
        boolean circleFilled = getBooleanInput();

        Circle circle = new Circle(radius, circleColor, circleFilled);

        // Create rectangle
        System.out.println("\nCreating a Rectangle:");
        System.out.print("Enter width: ");
        double width = getDoubleInput();
        
        System.out.print("Enter height: ");
        double height = getDoubleInput();
        
        System.out.print("Enter color: ");
        String rectColor = scanner.nextLine();
        
        System.out.print("Is the rectangle filled? (true/false): ");
        boolean rectFilled = getBooleanInput();

        Rectangle rectangle = new Rectangle(width, height, rectColor, rectFilled);

        // Demonstrate shape behavior
        System.out.println("\nCircle details:");
        System.out.println("- " + circle);
        System.out.printf("- Area: %.2f%n", circle.getArea());
        System.out.printf("- Perimeter: %.2f%n", circle.getPerimeter());
        System.out.printf("- Diameter: %.2f%n", circle.getDiameter());

        System.out.println("\nRectangle details:");
        System.out.println("- " + rectangle);
        System.out.printf("- Area: %.2f%n", rectangle.getArea());
        System.out.printf("- Perimeter: %.2f%n", rectangle.getPerimeter());
        System.out.println("- Is Square? " + rectangle.isSquare());

        // Demonstrate polymorphic behavior
        Shape[] shapes = {circle, rectangle};
        System.out.println("\nProcessing shapes polymorphically:");
        for (Shape shape : shapes) {
            System.out.printf("%s - Area: %.2f, Perimeter: %.2f%n",
                shape.getType(), shape.getArea(), shape.getPerimeter());
        }
    }

    private static void demonstrateRuntimePolymorphism() {
        System.out.println("Demonstrating Runtime Polymorphism");
        System.out.println("-".repeat(30));

        while (true) {
            System.out.println("\nChoose a media player:");
            System.out.println("1. Audio Player");
            System.out.println("2. Video Player");
            System.out.println("3. Back to main menu");
            
            System.out.print("\nEnter your choice (1-3): ");
            int choice = getIntInput(1, 3);
            
            if (choice == 3) break;
            
            MediaPlayer player = (choice == 1) ? new AudioPlayer() : new VideoPlayer();
            
            System.out.print("\nEnter media file path: ");
            String mediaPath = scanner.nextLine();
            
            System.out.print("Enter volume level (0-100): ");
            double volume = getDoubleInput(0, 100);
            
            System.out.print("Enter playback speed (0.5-2.0): ");
            double speed = getDoubleInput(0.5, 2.0);
            
            // Play media
            player.play(mediaPath);
            player.setVolume(volume);
            player.setPlaybackSpeed(speed);
            
            if (choice == 1) {
                AudioPlayer audio = (AudioPlayer) player;
                System.out.print("\nEnable equalizer? (true/false): ");
                if (getBooleanInput()) {
                    audio.toggleEqualizer();
                }
                
                System.out.print("Set bass boost level (0-100): ");
                int bassBoost = getIntInput(0, 100);
                audio.setBassBoost(bassBoost);
            } else {
                VideoPlayer video = (VideoPlayer) player;
                System.out.print("\nEnable subtitles? (true/false): ");
                if (getBooleanInput()) {
                    System.out.print("Enter subtitle language: ");
                    String language = scanner.nextLine();
                    video.setSubtitles(language);
                }
                
                System.out.print("Enable fullscreen? (true/false): ");
                if (getBooleanInput()) {
                    video.toggleFullscreen();
                }
                
                System.out.println("\nSet resolution:");
                System.out.print("Width: ");
                int width = getIntInput(0, 7680); // Up to 8K
                System.out.print("Height: ");
                int height = getIntInput(0, 4320); // Up to 8K
                video.setResolution(width, height);
            }
            
            player.stop();
        }
    }

    private static void demonstrateInterfacePolymorphism() {
        System.out.println("Demonstrating Interface Polymorphism");
        System.out.println("-".repeat(30));

        try {
            System.out.println("\nChoose payment method:");
            System.out.println("1. Credit Card");
            System.out.println("2. PayPal");
            
            System.out.print("\nEnter your choice (1-2): ");
            int choice = getIntInput(1, 2);
            
            PaymentProcessor processor = (choice == 1) 
                ? new CreditCardProcessor()
                : new PayPalProcessor(true); // Sandbox mode
            
            System.out.print("\nEnter payment amount: ");
            BigDecimal amount = getBigDecimalInput();
            
            System.out.print("Enter currency code (e.g., USD, EUR): ");
            String currency = scanner.nextLine().toUpperCase();
            
            // Process payment
            String transaction = processor.processPayment(amount, currency);
            System.out.println("Transaction ID: " + transaction);
            
            // Wait for async processing
            System.out.println("Processing payment...");
            Thread.sleep(2500);
            System.out.println("Status: " + processor.getPaymentStatus(transaction));
            
            // Process refund
            System.out.print("\nEnter refund amount: ");
            BigDecimal refundAmount = getBigDecimalInput();
            processor.refundPayment(transaction, refundAmount);
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Helper methods for input handling
    private static int getIntInput(int min, int max) {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.printf("Please enter a number between %d and %d: ", min, max);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    private static double getDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    private static double getDoubleInput(double min, double max) {
        while (true) {
            try {
                double value = Double.parseDouble(scanner.nextLine());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.printf("Please enter a number between %.1f and %.1f: ", min, max);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    private static BigDecimal getBigDecimalInput() {
        while (true) {
            try {
                return new BigDecimal(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    private static boolean getBooleanInput() {
        while (true) {
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            }
            System.out.print("Please enter true or false: ");
        }
    }

    private static LocalDate getDateInput() {
        while (true) {
            try {
                return LocalDate.parse(scanner.nextLine(), dateFormatter);
            } catch (DateTimeParseException e) {
                System.out.print("Please enter a valid date (yyyy-MM-dd): ");
            }
        }
    }
}