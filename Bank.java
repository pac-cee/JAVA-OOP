import java.lang.Math;

public class Bank {

    private double Loan(double principal) {
        double monthlyInterestRate = 1.2 / 100.0;
        int months = 12;
        double amount = principal * Math.pow(1 + monthlyInterestRate, (double) months);
        return amount;
    }
    

    public static void main(String[] args) {
        Bank bank = new Bank();
        double principal = 100000;
        double finalAmount = bank.Loan(principal);
        System.out.printf("Amount to be paid at the end of the year: %.2f\n", finalAmount);
    }
}
