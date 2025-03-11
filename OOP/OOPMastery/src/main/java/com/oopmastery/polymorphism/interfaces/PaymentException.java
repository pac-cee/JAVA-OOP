package com.oopmastery.polymorphism.interfaces;

/**
 * Custom exception class for payment-related errors.
 * This class extends RuntimeException to provide specific error handling
 * for payment processing operations.
 */
public class PaymentException extends RuntimeException {
    
    /**
     * Constructs a new PaymentException with the specified error message.
     * @param message The error message explaining the cause of the exception
     */
    public PaymentException(String message) {
        super(message);
    }

    /**
     * Constructs a new PaymentException with the specified error message and cause.
     * @param message The error message explaining the cause of the exception
     * @param cause The underlying cause of the exception
     */
    public PaymentException(String message, Throwable cause) {
        super(message, cause);
    }
} 