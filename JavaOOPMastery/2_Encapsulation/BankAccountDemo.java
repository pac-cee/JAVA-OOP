// Demo for BankAccount
public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Alice", 1000);
        account.deposit(500);
        account.withdraw(200);
        account.withdraw(2000); // Should fail
        account.printStatement();
    }
}
