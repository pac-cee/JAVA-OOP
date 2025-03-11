package com.oopmastery.encapsulation;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * BankAccount class demonstrating proper encapsulation.
 * This class shows:
 * 1. Private fields with public accessors
 * 2. Immutable fields (accountNumber)
 * 3. Validation in setters
 * 4. Defensive copying
 * 5. Thread-safe transaction handling
 */
public class BankAccount {
    // Immutable account number
    private final String accountNumber;
    
    // Private fields for data hiding
    private String accountHolder;
    private BigDecimal balance;
    private final List<Transaction> transactions;

    /**
     * Constructor initializes the account with required data.
     * @param accountHolder The name of the account holder
     * @param initialBalance The initial balance (must be non-negative)
     * @throws IllegalArgumentException if initialBalance is negative
     */
    public BankAccount(String accountHolder, BigDecimal initialBalance) {
        if (initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.accountNumber = UUID.randomUUID().toString();
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        addTransaction("Account opened", initialBalance);
    }

    /**
     * Gets the immutable account number.
     * @return The account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Gets the account holder's name.
     * @return The account holder's name
     */
    public String getAccountHolder() {
        return accountHolder;
    }

    /**
     * Updates the account holder's name.
     * @param accountHolder The new account holder's name
     * @throws IllegalArgumentException if accountHolder is null or empty
     */
    public void setAccountHolder(String accountHolder) {
        if (accountHolder == null || accountHolder.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be null or empty");
        }
        this.accountHolder = accountHolder.trim();
    }

    /**
     * Gets the current balance.
     * @return The current balance
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Deposits money into the account.
     * @param amount The amount to deposit
     * @throws IllegalArgumentException if amount is negative
     */
    public synchronized void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance = balance.add(amount);
        addTransaction("Deposit", amount);
    }

    /**
     * Withdraws money from the account.
     * @param amount The amount to withdraw
     * @throws IllegalArgumentException if amount is negative or exceeds balance
     */
    public synchronized void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount.compareTo(balance) > 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance = balance.subtract(amount);
        addTransaction("Withdrawal", amount.negate());
    }

    /**
     * Gets an unmodifiable list of all transactions.
     * @return List of transactions
     */
    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    /**
     * Adds a new transaction to the history.
     * @param description Transaction description
     * @param amount Transaction amount
     */
    private void addTransaction(String description, BigDecimal amount) {
        transactions.add(new Transaction(description, amount, LocalDateTime.now()));
    }

    /**
     * Inner class representing a bank transaction.
     * Demonstrates encapsulation within a related class.
     */
    public static class Transaction {
        private final String description;
        private final BigDecimal amount;
        private final LocalDateTime timestamp;

        private Transaction(String description, BigDecimal amount, LocalDateTime timestamp) {
            this.description = description;
            this.amount = amount;
            this.timestamp = timestamp;
        }

        public String getDescription() {
            return description;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        @Override
        public String toString() {
            return String.format("[%s] %s: %s", 
                timestamp, description, amount.toString());
        }
    }

    @Override
    public String toString() {
        return String.format("Account[number=%s, holder=%s, balance=%s]",
            accountNumber, accountHolder, balance.toString());
    }
} 