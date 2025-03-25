public interface Transaction {
    void deposit(double amount) throws IllegalArgumentException;
    void withdraw(double amount) throws InsufficientFundsException, DailyLimitExceededException;
    void transfer(BankAccount to, double amount) throws InsufficientFundsException, DailyLimitExceededException, InvalidTransferException;
}