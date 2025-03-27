public class BankTransactionProcessor {
    private List<BankAccount> accounts = new ArrayList<>();
    
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }
    
    public void processMonthlyInterest() {
        for (BankAccount account : accounts) {
            double interest = account.calculateMonthlyInterest();
            if (interest > 0) {
                try {
                    account.deposit(interest);
                    System.out.println("Added $" + interest + " interest to account " + account.getAccountNumber());
                } catch (IllegalArgumentException e) {
                    System.err.println("Error adding interest to account " + account.getAccountNumber() + ": " + e.getMessage());
                }
            }
        }
    }
    
    public void transferFunds(BankAccount from, BankAccount to, double amount) {
        try {
            from.transfer(to, amount);
            System.out.println("Transferred $" + amount + " from account " + from.getAccountNumber() + 
                              " to account " + to.getAccountNumber());
        } catch (Exception e) {
            System.err.println("Transfer failed: " + e.getMessage());
        }
    }
    
    public void resetDailyLimits() {
        for (BankAccount account : accounts) {
            if (account instanceof AbstractBankAccount) {
                ((AbstractBankAccount) account).resetDailyWithdrawalTotal();
            }
        }
    }
}