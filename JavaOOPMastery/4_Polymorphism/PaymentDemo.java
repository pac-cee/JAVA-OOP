// Demo for Payment System
public class PaymentDemo {
    public static void main(String[] args) {
        PaymentMethod[] methods = {
            new CreditCard("1234-5678-9012-3456"),
            new PayPal("alice@example.com"),
            new Crypto("wallet123")
        };
        for (PaymentMethod pm : methods) {
            pm.pay(100.0);
        }
    }
}
