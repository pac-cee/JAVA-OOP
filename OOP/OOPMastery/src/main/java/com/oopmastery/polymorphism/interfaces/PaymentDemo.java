package com.oopmastery.polymorphism.interfaces;

import java.math.BigDecimal;

/**
 * Demonstration of polymorphism using payment processors.
 * This class shows how different payment processors can be used interchangeably
 * through the PaymentProcessor interface.
 */
public class PaymentDemo {
    public static void main(String[] args) {
        // Create instances of different payment processors
        PaymentProcessor creditCardProcessor = new CreditCardProcessor();
        PaymentProcessor paypalProcessor = new PayPalProcessor(true); // Use sandbox mode for testing

        try {
            // Process payments using different processors
            System.out.println("=== Credit Card Payment ===");
            String ccTransaction = creditCardProcessor.processPayment(
                new BigDecimal("99.99"), "USD");
            System.out.println("Credit Card Payment Status: " + 
                creditCardProcessor.getPaymentStatus(ccTransaction));

            System.out.println("\n=== PayPal Payment ===");
            String ppTransaction = paypalProcessor.processPayment(
                new BigDecimal("49.99"), "EUR");
            
            // Wait for async processing to complete
            Thread.sleep(2500);
            System.out.println("PayPal Payment Status: " + 
                paypalProcessor.getPaymentStatus(ppTransaction));

            // Process refunds
            System.out.println("\n=== Processing Refunds ===");
            creditCardProcessor.refundPayment(ccTransaction, new BigDecimal("99.99"));
            paypalProcessor.refundPayment(ppTransaction, new BigDecimal("25.00")); // Partial refund

            // Demonstrate error handling
            System.out.println("\n=== Error Handling Examples ===");
            try {
                creditCardProcessor.processPayment(new BigDecimal("-50.00"), "USD");
            } catch (PaymentException e) {
                System.out.println("Expected error - Invalid amount: " + e.getMessage());
            }

            try {
                creditCardProcessor.processPayment(new BigDecimal("100.00"), "XYZ");
            } catch (PaymentException e) {
                System.out.println("Expected error - Invalid currency: " + e.getMessage());
            }

            try {
                creditCardProcessor.refundPayment("invalid-transaction", new BigDecimal("50.00"));
            } catch (PaymentException e) {
                System.out.println("Expected error - Invalid transaction: " + e.getMessage());
            }

        } catch (PaymentException e) {
            System.err.println("Payment processing error: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted while waiting for payment processing");
            Thread.currentThread().interrupt();
        }
    }
} 