package bank.transaction;

public class Loan extends Withdraw{
    public void loanRequest(double loanAmount){
       double checkLoan=super.balance ;
       super.deposit(200000);
       if(loanAmount>checkLoan*3){
           System.out.println("Loan request is denied");
       }
        System.out.println("loan of "+loanAmount+" is "+"accepted");
    }
}
