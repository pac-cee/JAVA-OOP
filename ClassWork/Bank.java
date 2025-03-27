package classwork;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bank {
    private String accountHolderName;
    private String accountNumber;
    private double balance;
    
    public Bank(String accountHolderName, String accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    
    public String getAccountHolderName() {
        return accountHolderName;
    }
    
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Deposit amount must be positive.");
            return false;
        }
        if (amount < 5000) {
            System.out.println("Error: Deposit amount must be at least 5000.");
            displayAccountDetails();
            return false;
        } else {
            balance += amount;
            System.out.println("Deposit successful. Amount deposited: " + amount);
            displayAccountDetails();
            return true;
        }
    }
    
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
            return false;
        }
        if (balance - amount < 10000) {
            System.out.println("Error: Withdrawal denied. Minimum balance of 10000 must be maintained.");
            displayAccountDetails();
            return false;
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Amount withdrawn: " + amount);
            displayAccountDetails();
            return true;
        }
    }
    
    public boolean requestLoan(double loanAmount) {
        if (loanAmount <= 0) {
            System.out.println("Error: Loan amount must be positive.");
            return false;
        }
        double maxLoanAmount = balance * 3;
        if (loanAmount > maxLoanAmount) {
            System.out.println("Error: Loan request denied. Maximum loan amount allowed is " + maxLoanAmount 
                              + " (3 times your current balance).");
            displayAccountDetails();
            return false;
        } else {
            System.out.println("Loan request approved for amount: " + loanAmount);
            displayAccountDetails();
            return true;
        }
    }
    
    public void displayAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
        System.out.println("----------------------\n");
    }
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Bank account = new Bank("Pacifique Bakundukize", "ACC123456", 15000);
            int choice = 0;
            
            do {
                System.out.println("----- Bank Menu -----");
                System.out.println("1. Display Account Details");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Request Loan");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                
                // Exception handling for invalid menu choice input
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a numeric value.");
                    scanner.nextLine(); // clear the invalid input
                    continue;
                }
                
                switch (choice) {
                    case 1 -> account.displayAccountDetails();
                    case 2 -> {
                        System.out.print("Enter deposit amount: ");
                        try {
                            double depositAmount = scanner.nextDouble();
                            account.deposit(depositAmount);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter a valid numeric amount for deposit.");
                            scanner.nextLine(); // clear invalid input
                        }
                    }
                    case 3 -> {
                        System.out.print("Enter withdrawal amount: ");
                        try {
                            double withdrawAmount = scanner.nextDouble();
                            account.withdraw(withdrawAmount);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter a valid numeric amount for withdrawal.");
                            scanner.nextLine(); // clear invalid input
                        }
                    }
                    case 4 -> {
                        System.out.print("Enter loan amount: ");
                        try {
                            double loanAmount = scanner.nextDouble();
                            account.requestLoan(loanAmount);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter a valid numeric amount for the loan request.");
                            scanner.nextLine(); // clear invalid input
                        }
                    }
                    case 5 -> System.out.println("Exiting program. Thank you!");
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 5);
        }
    }
}
