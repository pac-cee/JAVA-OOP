// Crypto payment implementation
public class Crypto implements PaymentMethod {
    private String walletId;
    public Crypto(String walletId) {
        this.walletId = walletId;
    }
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Crypto Wallet: " + walletId);
    }
}
