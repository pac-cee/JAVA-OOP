package classwork.inheritance.bank;
public abstract class AbstractBankAccount implements BankAccount {
    private String accountNumber;
    private double balance;
    private String bankName;
    private double interestRate;
    private double dailyWithdrawalTotal;
    private static final double DAILY_WITHDRAWAL_LIMIT = 5000.0;
    
    public AbstractBankAccount(String accountNumber, double initialBalance, String bankName, double interestRate) {
        validateAccountNumber(accountNumber);
        validateBalance(initialBalance);
        validateBankName(bankName);
        validateInterestRate(interestRate);
        
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.bankName = bankName;
        this.interestRate = interestRate;
        this.dailyWithdrawalTotal = 0.0;
    }
    
    private void validateAccountNumber(String accountNumber) {
        if (accountNumber == null || !accountNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Account number must be a 10-digit number");
        }
    }
    
    private void validateBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
    }
    
    private void validateBankName(String bankName) {
        boolean validBank = false;
        for (String bank : VALID_BANKS) {
            if (bank.equals(bankName)) {
                validBank = true;
                break;
            }
        }
        if (!validBank) {
            throw new IllegalArgumentException("Bank name must be one of: " + Arrays.toString(VALID_BANKS));
        }
    }
    
    private void validateInterestRate(double interestRate) {
        if (interestRate < 0 || interestRate > 10) {
            throw new IllegalArgumentException("Interest rate must be between 0 and 10%");
        }
    }
    
    @Override
    public String getAccountNumber() {
        return accountNumber;
    }
    
    @Override
    public double getBalance() {
        return balance;
    }
    
    @Override
    public String getBankName() {
        return bankName;
    }
    
    @Override
    public double getInterestRate() {
        return interestRate;
    }
    
    @Override
    public double calculateMonthlyInterest() {
        if (balance < 100) {
            return 0;  // No interest on balances below $100
        }
        return (balance * interestRate / 100) / 12;  // Monthly interest
    }
    
    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        
        balance += amount;
        
        if (amount > 10000) {
            reportToFinancialRegulator(amount);
        }
    }
    
    private void reportToFinancialRegulator(double amount) {
        System.out.println("REGULATORY REPORT: Large deposit of $" + amount + 
                           " to account " + maskAccountNumber() + " reported to Financial Regulator");
    }
    
    private String maskAccountNumber() {
        return "XXXX" + accountNumber.substring(accountNumber.length() - 4);
    }
    
    @Override
    public void withdraw(double amount) throws InsufficientFundsException, DailyLimitExceededException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
        
        if (dailyWithdrawalTotal + amount > DAILY_WITHDRAWAL_LIMIT) {
            throw new DailyLimitExceededException("Daily withdrawal limit of $" + DAILY_WITHDRAWAL_LIMIT + " exceeded");
        }
        
        balance -= amount;
        dailyWithdrawalTotal += amount;
    }
    
    @Override
    public void transfer(BankAccount to, double amount) 
            throws InsufficientFundsException, DailyLimitExceededException, InvalidTransferException {
        if (to.getBankName().equals(this.getBankName())) {
            throw new InvalidTransferException("Cannot transfer between accounts of the same bank");
        }
        
        withdraw(amount);
        to.deposit(amount);
    }
    
    protected void setBalance(double balance) {
        validateBalance(balance);
        this.balance = balance;
    }
    
    public void resetDailyWithdrawalTotal() {
        this.dailyWithdrawalTotal = 0.0;
    }
}