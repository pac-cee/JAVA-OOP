package bank.transaction;

public class Withdraw extends Deposit{
    public void withdrawAmount(double existAmount){
         double total=super.balance;
         super.accountName="Ivan";
         super.accountNumber="123456789";
         double remaining=total-existAmount;
         System.out.println("The withdraw amount is "+existAmount+"Remaining amount is "+remaining);

    }
}
