package bank.transaction;

public class Deposit extends Transaction{
   public double balance=200000;

    public void deposit(double amount_det){
        balance=balance+amount_det;
        System.out.println("The deposit amount is "+amount_det+"The balance is "+balance);
    }

}
