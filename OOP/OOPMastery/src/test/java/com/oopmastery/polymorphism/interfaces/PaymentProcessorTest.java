package com.oopmastery.polymorphism.interfaces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

/**
 * Test class for payment processors demonstrating interface-based polymorphism.
 */
public class PaymentProcessorTest {
    private PaymentProcessor creditCardProcessor;
    private PaymentProcessor paypalProcessor;

    @BeforeEach
    void setUp() {
        creditCardProcessor = new CreditCardProcessor();
        paypalProcessor = new PayPalProcessor(true); // Use sandbox mode for testing
    }

    @Test
    void testSuccessfulPayment() throws PaymentException, InterruptedException {
        String ccTransaction = creditCardProcessor.processPayment(
            new BigDecimal("100.00"), "USD");
        assertNotNull(ccTransaction);
        assertEquals(PaymentProcessor.STATUS_SUCCESS, 
            creditCardProcessor.getPaymentStatus(ccTransaction));

        String ppTransaction = paypalProcessor.processPayment(
            new BigDecimal("50.00"), "EUR");
        assertNotNull(ppTransaction);
        
        // Wait for async processing to complete
        Thread.sleep(2500);
        assertEquals(PaymentProcessor.STATUS_SUCCESS, 
            paypalProcessor.getPaymentStatus(ppTransaction));
    }

    @Test
    void testSuccessfulRefund() throws PaymentException, InterruptedException {
        // Process payment first
        String transactionId = creditCardProcessor.processPayment(
            new BigDecimal("200.00"), "USD");
        
        // Then refund it
        creditCardProcessor.refundPayment(transactionId, new BigDecimal("200.00"));
        
        // Test partial refund with PayPal
        String ppTransaction = paypalProcessor.processPayment(
            new BigDecimal("100.00"), "USD");
        Thread.sleep(2500); // Wait for processing
        paypalProcessor.refundPayment(ppTransaction, new BigDecimal("50.00"));
    }

    @Test
    void testInvalidAmount() {
        assertThrows(PaymentException.class, () -> 
            creditCardProcessor.processPayment(new BigDecimal("-50.00"), "USD"));
        assertThrows(PaymentException.class, () -> 
            creditCardProcessor.processPayment(BigDecimal.ZERO, "USD"));
    }

    @Test
    void testInvalidCurrency() {
        assertThrows(PaymentException.class, () -> 
            creditCardProcessor.processPayment(new BigDecimal("50.00"), "INVALID"));
        assertThrows(PaymentException.class, () -> 
            creditCardProcessor.processPayment(new BigDecimal("50.00"), "US"));
    }

    @Test
    void testRefundWithoutTransaction() {
        assertThrows(PaymentException.class, () -> 
            creditCardProcessor.refundPayment("INVALID-ID", new BigDecimal("50.00")));
    }

    @Test
    void testRefundExceedingOriginal() throws PaymentException {
        String transactionId = creditCardProcessor.processPayment(
            new BigDecimal("100.00"), "USD");
        
        assertThrows(PaymentException.class, () -> 
            creditCardProcessor.refundPayment(transactionId, new BigDecimal("150.00")));
    }

    @Test
    void testProcessorSpecificBehavior() {
        // Test CreditCard maximum amount
        assertThrows(PaymentException.class, () -> 
            creditCardProcessor.processPayment(new BigDecimal("20000.00"), "USD"));

        // Test PayPal maximum amount
        assertThrows(PaymentException.class, () -> 
            paypalProcessor.processPayment(new BigDecimal("10000.00"), "USD"));
    }

    @Test
    void testPayPalAsyncProcessing() throws PaymentException, InterruptedException {
        String transactionId = paypalProcessor.processPayment(
            new BigDecimal("100.00"), "USD");
        
        // Initially the payment should be pending
        assertEquals(PaymentProcessor.STATUS_PENDING, 
            paypalProcessor.getPaymentStatus(transactionId));
        
        // Wait for processing to complete
        Thread.sleep(2500);
        assertEquals(PaymentProcessor.STATUS_SUCCESS, 
            paypalProcessor.getPaymentStatus(transactionId));
    }

    @Test
    void testValidation() {
        // Test amount validation
        assertTrue(creditCardProcessor.validateAmount(new BigDecimal("100.00")));
        assertFalse(creditCardProcessor.validateAmount(new BigDecimal("-100.00")));
        assertFalse(creditCardProcessor.validateAmount(null));

        // Test currency validation
        assertTrue(creditCardProcessor.validateCurrency("USD"));
        assertTrue(creditCardProcessor.validateCurrency("EUR"));
        assertFalse(creditCardProcessor.validateCurrency("INVALID"));
        assertFalse(creditCardProcessor.validateCurrency("US"));
        assertFalse(creditCardProcessor.validateCurrency(null));
    }
} 