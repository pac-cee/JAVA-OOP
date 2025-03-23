package classwork.inheritance.bank;
public interface BankAccount extends Transaction {
    String[] VALID_BANKS = {"Chase", "Bank of America", "Wells Fargo", "Citibank", "Capital One"};
    
    String getAccountNumber();  // 10-digit number
    double getBalance();  // Non-negative
    String getBankName();  // From predefined list
    double getInterestRate();  // 0-10%
    
    double calculateMonthlyInterest();
}