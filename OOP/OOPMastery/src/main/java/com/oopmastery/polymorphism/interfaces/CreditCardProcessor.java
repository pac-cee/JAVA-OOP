package com.oopmastery.polymorphism.interfaces;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Implementation of PaymentProcessor for credit card payments.
 * Demonstrates how a concrete class can implement the PaymentProcessor interface
 * with its own specific behavior.
 */
public class CreditCardProcessor implements PaymentProcessor {
    private static final BigDecimal MAX_AMOUNT = new BigDecimal("10000.00");
    private final Map<String, Transaction> transactions;

    public CreditCardProcessor() {
        this.transactions = new HashMap<>();
    }

    @Override
    public String processPayment(BigDecimal amount, String currency) throws PaymentException {
        if (!validateAmount(amount)) {
            throw new PaymentException("Invalid payment amount: " + amount);
        }
        if (!validateCurrency(currency)) {
            throw new PaymentException("Invalid currency code: " + currency);
        }
        if (amount.compareTo(MAX_AMOUNT) > 0) {
            throw new PaymentException("Amount exceeds maximum limit of " + MAX_AMOUNT);
        }

        // Simulate credit card processing
        String transactionId = generateTransactionId();
        transactions.put(transactionId, new Transaction(amount, currency));
        
        System.out.println("Processing credit card payment: " + amount + " " + currency);
        System.out.println("Transaction ID: " + transactionId);
        
        return transactionId;
    }

    @Override
    public void refundPayment(String transactionId, BigDecimal amount) throws PaymentException {
        Transaction transaction = transactions.get(transactionId);
        if (transaction == null) {
            throw new PaymentException("Transaction not found: " + transactionId);
        }

        if (amount.compareTo(transaction.amount) > 0) {
            throw new PaymentException("Refund amount cannot exceed original payment amount");
        }

        System.out.println("Processing credit card refund: " + amount + " " + transaction.currency);
        System.out.println("Original transaction: " + transactionId);
        
        // Remove the transaction after full refund
        if (amount.compareTo(transaction.amount) == 0) {
            transactions.remove(transactionId);
        } else {
            transaction.amount = transaction.amount.subtract(amount);
        }
    }

    @Override
    public String getPaymentStatus(String transactionId) throws PaymentException {
        if (!transactions.containsKey(transactionId)) {
            throw new PaymentException("Transaction not found: " + transactionId);
        }
        return STATUS_SUCCESS; // Credit card payments are immediate
    }

    private String generateTransactionId() {
        return "CC-" + UUID.randomUUID().toString();
    }

    private static class Transaction {
        private BigDecimal amount;
        private final String currency;

        Transaction(BigDecimal amount, String currency) {
            this.amount = amount;
            this.currency = currency;
        }
    }
} 