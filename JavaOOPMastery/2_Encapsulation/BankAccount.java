// BankAccount class for Encapsulation Project
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String owner;
    private double balance;
    private List<String> transactions = new ArrayList<>();

    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
        transactions.add("Account opened with balance: " + initialBalance);
    }

    public String getOwner() { return owner; }
    public double getBalance() { return balance; }
    public List<String> getTransactions() { return new ArrayList<>(transactions); }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited: " + amount);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("Withdrew: " + amount);
            return true;
        }
        transactions.add("Failed withdrawal attempt: " + amount);
        return false;
    }

    public void printStatement() {
        System.out.println("Account Statement for " + owner);
        for (String t : transactions) {
            System.out.println(t);
        }
        System.out.println("Current Balance: " + balance);
    }
}
