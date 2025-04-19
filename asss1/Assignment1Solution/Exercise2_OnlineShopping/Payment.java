package Assignment1Solution.Exercise2_OnlineShopping;

import java.time.LocalDateTime;

public class Payment {
    private final String paymentId;
    private final String paymentMethod;
    private final double amountPaid;
    private final LocalDateTime transactionDate;

    public Payment(String paymentId, String paymentMethod, double amountPaid, LocalDateTime transactionDate) {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.amountPaid = amountPaid;
        this.transactionDate = transactionDate;
    }

    public boolean validatePayment(double expectedAmount) {
        boolean valid = true;
        java.util.List<String> validMethods = java.util.Arrays.asList("Credit Card", "PayPal", "Debit Card", "Cash");
        if (!validMethods.contains(paymentMethod)) {
            System.out.println("Invalid payment method.");
            valid = false;
        }
        if (amountPaid != expectedAmount) {
            System.out.println("Payment amount does not match total price.");
            valid = false;
        }
        return valid;
    }
    public double getAmountPaid() { return amountPaid; }
    public String getPaymentMethod() { return paymentMethod; }
}
