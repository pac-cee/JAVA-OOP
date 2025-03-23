package classwork;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// BankAccount class encapsulating account details and operations
class BankAccount {
    private String accountNumber;
    private String owner;
    private double balance;

    public BankAccount(String accountNumber, String owner, double initialBalance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit method with validation
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method with balance check and validation
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        }
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + " | Owner: " + owner + " | Balance: " + balance;
    }
}

public class BankSystem {
    private static ArrayList<BankAccount> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        System.out.println("Welcome to the Bank Account Management System!");
        do {
            displayMenu();
            choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositToAccount();
                    break;
                case 3:
                    withdrawFromAccount();
                    break;
                case 4:
                    viewAccount();
                    break;
                case 5:
                    System.out.println("Exiting the system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select from the menu.");
            }
        } while (choice != 5);
        scanner.close();
    }

    // Display menu options
    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. View Account Details");
        System.out.println("5. Exit");
    }

    // Create a new bank account
    private static void createAccount() {
        System.out.print("Enter account number: ");
        String accNum = scanner.nextLine();
        System.out.print("Enter account owner name: ");
        String owner = scanner.nextLine();
        double initialBalance = getDoubleInput("Enter initial balance: ");
        BankAccount account = new BankAccount(accNum, owner, initialBalance);
        accounts.add(account);
        System.out.println("Account created successfully.");
    }

    // Deposit funds into an account
    private static void depositToAccount() {
        BankAccount account = findAccount();
        if (account != null) {
            double amount = getDoubleInput("Enter amount to deposit: ");
            account.deposit(amount);
        }
    }

    // Withdraw funds from an account
    private static void withdrawFromAccount() {
        BankAccount account = findAccount();
        if (account != null) {
            double amount = getDoubleInput("Enter amount to withdraw: ");
            account.withdraw(amount);
        }
    }

    // View account details
    private static void viewAccount() {
        BankAccount account = findAccount();
        if (account != null) {
            System.out.println(account);
        }
    }

    // Find an account by account number
    private static BankAccount findAccount() {
        System.out.print("Enter account number: ");
        String accNum = scanner.nextLine();
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accNum)) {
                return acc;
            }
        }
        System.out.println("Account not found.");
        return null;
    }

    // Get integer input with error handling
    private static int getIntInput(String prompt) {
        int value = 0;
        while (true) {
            System.out.print(prompt);
            try {
                value = scanner.nextInt();
                scanner.nextLine(); // Clear newline
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer value.");
                scanner.nextLine();
            }
        }
        return value;
    }

    // Get double input with error handling
    private static double getDoubleInput(String prompt) {
        double value = 0;
        while (true) {
            System.out.print(prompt);
            try {
                value = scanner.nextDouble();
                scanner.nextLine(); // Clear newline
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid amount.");
                scanner.nextLine();
            }
        }
        return value;
    }
}
