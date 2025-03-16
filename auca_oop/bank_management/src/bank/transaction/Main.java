package bank.transaction;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("enter your deposit amount :");
        Deposit deposit = new Deposit();
        try (Scanner scanner = new Scanner(System.in)) {
            double amount=scanner.nextDouble();
            deposit.deposit(amount);
            System.out.println("enter your withdraw amount :");
            double withdrawAmount=scanner.nextDouble();
            Withdraw withdraw=new Withdraw();
            withdraw.withdrawAmount(withdrawAmount);
        }
        Deposit deposit1=new Withdraw();



    }


}
