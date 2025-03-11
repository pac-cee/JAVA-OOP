package com.oopmastery.polymorphism.interfaces;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Interface defining the contract for payment processors.
 * This demonstrates interface-based polymorphism where different payment processors
 * can implement the same interface with varying implementations.
 */
public interface PaymentProcessor {
    // Status constants
    String STATUS_SUCCESS = "SUCCESS";
    String STATUS_PENDING = "PENDING";
    String STATUS_FAILED = "FAILED";

    Set<String> VALID_CURRENCIES = new HashSet<>(Arrays.asList(
        "USD", "EUR", "GBP", "JPY", "CAD", "AUD"
    ));

    /**
     * Process a payment with the specified amount and currency.
     * @param amount The payment amount
     * @param currency The currency code (e.g., USD, EUR)
     * @return A unique transaction ID for the payment
     * @throws PaymentException if the payment fails or validation fails
     */
    String processPayment(BigDecimal amount, String currency) throws PaymentException;

    /**
     * Process a refund for a previous payment.
     * @param transactionId The ID of the original transaction
     * @param amount The amount to refund
     * @throws PaymentException if the refund fails or validation fails
     */
    void refundPayment(String transactionId, BigDecimal amount) throws PaymentException;

    /**
     * Get the current status of a payment.
     * @param transactionId The ID of the transaction to check
     * @return The current status of the payment (SUCCESS, PENDING, or FAILED)
     * @throws PaymentException if the transaction is not found
     */
    String getPaymentStatus(String transactionId) throws PaymentException;

    /**
     * Validate if the payment amount is valid.
     * @param amount The amount to validate
     * @return true if the amount is valid, false otherwise
     */
    default boolean validateAmount(BigDecimal amount) {
        return amount != null && amount.compareTo(BigDecimal.ZERO) > 0;
    }

    /**
     * Validate if the currency code is supported.
     * @param currency The currency code to validate
     * @return true if the currency is valid, false otherwise
     */
    default boolean validateCurrency(String currency) {
        return currency != null && VALID_CURRENCIES.contains(currency.toUpperCase());
    }
} 