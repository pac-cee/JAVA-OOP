package projects.rra;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TaxDeclarationApp {
    // List to store declarations for display.
    private static List<Declaration> declarations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exitApp = false;
        
        while (!exitApp) {
            displayMenu();
            int choice = 0;
            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    createVatDeclaration(scanner);
                    break;
                case 2:
                    createIncomeTaxDeclaration(scanner);
                    break;
                case 3:
                    processPayment(scanner);
                    break;
                case 4:
                    displayDeclarations();
                    break;
                case 5:
                    System.out.println("Exiting application.");
                    exitApp = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n===== Tax Declaration System =====");
        System.out.println("1. Create VAT Declaration");
        System.out.println("2. Create Income Tax Declaration");
        System.out.println("3. Process Payment");
        System.out.println("4. Display All Declarations");
        System.out.println("5. Exit");
    }

    // Helper method to create a Taxpayer after validating age and tax rate.
    private static Taxpayer createTaxpayer(Scanner scanner, String expectedTaxType, double expectedRate) {
        try {
            System.out.print("Enter Taxpayer ID (integer): ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Taxpayer Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter Turnover Amount: ");
            double turnoverAmount = scanner.nextDouble();
            scanner.nextLine();
            
            System.out.print("Enter Tax Rate (" + expectedRate*100 + "% expected): ");
            double rate = scanner.nextDouble();
            scanner.nextLine();
            
            System.out.print("Enter Tax Type (VAT/Income Tax): ");
            String taxType = scanner.nextLine().trim();
            
            System.out.print("Enter Taxpayer Age (between 20 and 60): ");
            int age = scanner.nextInt();
            scanner.nextLine();
            
            // Validation rules:
            if(age < 20 || age > 60) {
                System.out.println("Error: Only taxpayers aged between 20 and 60 are allowed.");
                return null;
            }
            if(!taxType.equalsIgnoreCase(expectedTaxType)) {
                System.out.println("Error: Expected tax type is " + expectedTaxType + ".");
                return null;
            }
            if(rate != expectedRate) {
                System.out.println("Error: Tax rate must be " + (expectedRate*100) + "%.");
                return null;
            }
            
            return new Taxpayer(id, name, turnoverAmount, rate, taxType, age);
        } catch (InputMismatchException ime) {
            System.out.println("Input error: Please ensure you enter correct data types.");
            scanner.nextLine();
            return null;
        }
    }

    private static void createVatDeclaration(Scanner scanner) {
        System.out.println("\n--- Create VAT Declaration ---");
        // Expected VAT tax type is "VAT" and rate is 18%
        Taxpayer taxpayer = createTaxpayer(scanner, "VAT", 0.18);
        if (taxpayer != null) {
            Declaration vatDec = new VatDeclaration(taxpayer);
            vatDec.displayInfo();
            declarations.add(vatDec);
        }
    }

    private static void createIncomeTaxDeclaration(Scanner scanner) {
        System.out.println("\n--- Create Income Tax Declaration ---");
        // Expected Income Tax type is "Income Tax" and rate is 30%
        Taxpayer taxpayer = createTaxpayer(scanner, "Income Tax", 0.30);
        if (taxpayer != null) {
            Declaration incomeDec = new IncomeTax(taxpayer);
            incomeDec.displayInfo();
            declarations.add(incomeDec);
        }
    }

    private static void processPayment(Scanner scanner) {
        System.out.println("\n--- Process Payment ---");
        // For payment processing, we first create the taxpayer declaration.
        System.out.print("Enter tax type for payment (VAT/Income Tax): ");
        String taxType = scanner.nextLine().trim();
        double expectedRate = taxType.equalsIgnoreCase("VAT") ? 0.18 : 0.30;
        Taxpayer taxpayer = createTaxpayer(scanner, taxType, expectedRate);
        if (taxpayer != null) {
            double calculatedTax = 0;
            if (taxType.equalsIgnoreCase("VAT")) {
                calculatedTax = taxpayer.getTurnoverAmount() * 0.18;
            } else if (taxType.equalsIgnoreCase("Income Tax")) {
                calculatedTax = taxpayer.getTurnoverAmount() * 0.30;
            }
            System.out.println("Calculated Tax Amount: " + calculatedTax);
            System.out.print("Enter Payment Amount: ");
            double paymentAmount = 0;
            try {
                paymentAmount = scanner.nextDouble();
                scanner.nextLine();
            } catch (InputMismatchException ime) {
                System.out.println("Input error: Payment amount must be numeric.");
                scanner.nextLine();
                return;
            }
            Declaration paymentDec = new Payments(taxpayer, paymentAmount);
            paymentDec.displayInfo();
            declarations.add(paymentDec);
        }
    }

    private static void displayDeclarations() {
        if (declarations.isEmpty()) {
            System.out.println("No declarations available.");
        } else {
            System.out.println("\n===== All Tax Declarations =====");
            for (Declaration dec : declarations) {
                dec.displayInfo();
                System.out.println("------------------------------");
            }
        }
    }
}
