package com.oopmastery.patterns.strategy;

import java.math.BigDecimal;

/**
 * Strategy pattern example demonstrating interchangeable algorithms.
 * Shows:
 * 1. Strategy interface
 * 2. Concrete strategies
 * 3. Context class
 * 4. Runtime strategy selection
 */
public interface PaymentStrategy {
    boolean pay(BigDecimal amount);
    String getPaymentMethod();
}

class CreditCardStrategy implements PaymentStrategy {
    private final String cardNumber;
    private final String cvv;
    private final String expiryDate;

    public CreditCardStrategy(String cardNumber, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean pay(BigDecimal amount) {
        System.out.printf("Paid %.2f using credit card %s%n", 
            amount, maskCardNumber());
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }

    private String maskCardNumber() {
        return "xxxx-xxxx-xxxx-" + cardNumber.substring(cardNumber.length() - 4);
    }
}

class PayPalStrategy implements PaymentStrategy {
    private final String email;
    private final String password;

    public PayPalStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean pay(BigDecimal amount) {
        System.out.printf("Paid %.2f using PayPal account: %s%n", 
            amount, email);
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "PayPal";
    }
}

class CryptoStrategy implements PaymentStrategy {
    private final String walletAddress;
    private final String currency;

    public CryptoStrategy(String walletAddress, String currency) {
        this.walletAddress = walletAddress;
        this.currency = currency;
    }

    @Override
    public boolean pay(BigDecimal amount) {
        System.out.printf("Paid %.2f %s to wallet: %s%n", 
            amount, currency, walletAddress);
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "Cryptocurrency (" + currency + ")";
    }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public boolean checkout(BigDecimal amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set");
        }
        return paymentStrategy.pay(amount);
    }

    public String getCurrentPaymentMethod() {
        return paymentStrategy != null ? 
            paymentStrategy.getPaymentMethod() : "Not set";
    }
} 