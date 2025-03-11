package com.oopmastery.polymorphism.interfaces;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Implementation of PaymentProcessor for PayPal payments.
 * Demonstrates how a concrete class can implement the PaymentProcessor interface
 * with its own specific behavior.
 */
public class PayPalProcessor implements PaymentProcessor {
    private static final BigDecimal MAX_AMOUNT = new BigDecimal("5000.00");
    private final Map<String, Transaction> transactions;
    private final boolean sandboxMode;

    public PayPalProcessor(boolean sandboxMode) {
        this.transactions = new HashMap<>();
        this.sandboxMode = sandboxMode;
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

        // Simulate PayPal processing with sandbox mode
        String transactionId = generateTransactionId();
        transactions.put(transactionId, new Transaction(amount, currency, TransactionStatus.PENDING));
        
        System.out.println("Processing PayPal payment: " + amount + " " + currency);
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Sandbox mode: " + sandboxMode);
        
        // Simulate async processing
        simulateAsyncProcessing(transactionId);
        
        return transactionId;
    }

    @Override
    public void refundPayment(String transactionId, BigDecimal amount) throws PaymentException {
        Transaction transaction = transactions.get(transactionId);
        if (transaction == null) {
            throw new PaymentException("Transaction not found: " + transactionId);
        }

        if (transaction.status != TransactionStatus.SUCCESS) {
            throw new PaymentException("Cannot refund a transaction that is not successful");
        }

        if (amount.compareTo(transaction.amount) > 0) {
            throw new PaymentException("Refund amount cannot exceed original payment amount");
        }

        System.out.println("Processing PayPal refund: " + amount + " " + transaction.currency);
        System.out.println("Original transaction: " + transactionId);
        System.out.println("Sandbox mode: " + sandboxMode);
        
        // Remove the transaction after full refund
        if (amount.compareTo(transaction.amount) == 0) {
            transactions.remove(transactionId);
        } else {
            transaction.amount = transaction.amount.subtract(amount);
        }
    }

    @Override
    public String getPaymentStatus(String transactionId) throws PaymentException {
        Transaction transaction = transactions.get(transactionId);
        if (transaction == null) {
            throw new PaymentException("Transaction not found: " + transactionId);
        }
        return transaction.status.toString();
    }

    private String generateTransactionId() {
        return "PP-" + UUID.randomUUID().toString();
    }

    private void simulateAsyncProcessing(String transactionId) {
        // Simulate async processing by setting success after a delay
        new Thread(() -> {
            try {
                Thread.sleep(2000); // Simulate 2-second processing time
                Transaction transaction = transactions.get(transactionId);
                if (transaction != null) {
                    transaction.status = TransactionStatus.SUCCESS;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    private static class Transaction {
        private BigDecimal amount;
        private final String currency;
        private TransactionStatus status;

        Transaction(BigDecimal amount, String currency, TransactionStatus status) {
            this.amount = amount;
            this.currency = currency;
            this.status = status;
        }
    }

    private enum TransactionStatus {
        PENDING, SUCCESS, FAILED
    }
} 