package classwork.inheritance.bank;
public class SavingsAccount extends AbstractBankAccount {
    private static final double MINIMUM_BALANCE = 500.0;
    private static final double PENALTY_RATE = 0.02;  // 2%
    
    public SavingsAccount(String accountNumber, double initialBalance, String bankName, double interestRate) {
        super(accountNumber, initialBalance, bankName, interestRate);
        if (initialBalance < MINIMUM_BALANCE) {
            throw new IllegalArgumentException("Savings account requires minimum balance of $" + MINIMUM_BALANCE);
        }
    }
    
    @Override
    public void withdraw(double amount) throws InsufficientFundsException, DailyLimitExceededException {
        super.withdraw(amount);
        
        double newBalance = getBalance();
        if (newBalance < MINIMUM_BALANCE) {
            double penalty = amount * PENALTY_RATE;
            System.out.println("Applying penalty of $" + penalty + " for going below minimum balance");
            setBalance(newBalance - penalty);
        }
    }
}

public class FixedDepositAccount extends AbstractBankAccount {
    private LocalDate maturityDate;
    
    public FixedDepositAccount(String accountNumber, double initialBalance, String bankName, 
                              double interestRate, int durationMonths) {
        super(accountNumber, initialBalance, bankName, interestRate);
        this.maturityDate = LocalDate.now().plusMonths(durationMonths);
    }
    
    @Override
    public void withdraw(double amount) throws InsufficientFundsException, DailyLimitExceededException {
        if (LocalDate.now().isBefore(maturityDate)) {
            throw new EarlyWithdrawalPenaltyException("Cannot withdraw before maturity date: " + maturityDate);
        }
        super.withdraw(amount);
    }
    
    public LocalDate getMaturityDate() {
        return maturityDate;
    }
}