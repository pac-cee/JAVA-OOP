package com.oopmastery.encapsulation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Demonstration class showing proper usage of encapsulated classes.
 */
public class EncapsulationDemo {
    public static void main(String[] args) {
        demonstrateBankAccount();
        System.out.println("\n" + "=".repeat(50) + "\n");
        demonstrateImmutablePerson();
    }

    private static void demonstrateBankAccount() {
        System.out.println("Bank Account Demonstration");
        System.out.println("-".repeat(30));

        // Create a new bank account
        BankAccount account = new BankAccount("John Doe", new BigDecimal("1000.00"));
        System.out.println("Created account: " + account);

        // Attempt some transactions
        try {
            account.deposit(new BigDecimal("500.50"));
            System.out.println("After deposit: " + account);

            account.withdraw(new BigDecimal("200.25"));
            System.out.println("After withdrawal: " + account);

            // Try to withdraw too much (should fail)
            account.withdraw(new BigDecimal("2000.00"));
        } catch (IllegalArgumentException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }

        // Print transaction history
        System.out.println("\nTransaction History:");
        account.getTransactions().forEach(System.out::println);

        // Demonstrate that transactions list is unmodifiable
        try {
            account.getTransactions().add(null); // Should throw UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("\nCannot modify transactions list (protected by encapsulation)");
        }
    }

    private static void demonstrateImmutablePerson() {
        System.out.println("Immutable Person Demonstration");
        System.out.println("-".repeat(30));

        // Create an address
        ImmutablePerson.Address address = new ImmutablePerson.Address(
            "123 Main St",
            "Springfield",
            "USA",
            "12345"
        );

        // Create a list of qualifications
        List<String> qualifications = Arrays.asList("BSc", "MSc", "PhD");

        // Create an immutable person
        ImmutablePerson person = new ImmutablePerson(
            "Jane Doe",
            LocalDate.of(1990, 1, 15),
            qualifications,
            address
        );

        System.out.println("Created person: " + person);

        // Demonstrate immutability
        List<String> returnedQualifications = person.getQualifications();
        try {
            returnedQualifications.add("MBA"); // Should throw UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("\nCannot modify qualifications (immutable)");
        }

        // Demonstrate that original list can be modified but doesn't affect person
        qualifications.add("MBA");
        System.out.println("\nOriginal qualifications modified but person's qualifications unchanged:");
        System.out.println("Original: " + qualifications);
        System.out.println("Person's: " + person.getQualifications());

        // Demonstrate address immutability through copying
        ImmutablePerson.Address returnedAddress = person.getAddress();
        System.out.println("\nAddress comparison:");
        System.out.println("Original address: " + address);
        System.out.println("Returned address: " + returnedAddress);
        System.out.println("Are they the same object? " + (address == returnedAddress)); // Should be false
    }
} 