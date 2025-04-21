// PayPal payment implementation
public class PayPal implements PaymentMethod {
    private String email;
    public PayPal(String email) {
        this.email = email;
    }
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal: " + email);
    }
}
