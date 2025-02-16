public class Deposit2 {
    public static void main(String[] args) {
        int amount=400000;
        double interestRate=0.035;
        double interestAmount=amount*interestRate/100;

        //if statement

        if (interestAmount>15000){
            System.out.println("You can not take the amount");
        }
        else if (interestAmount<15000 || interestAmount>10000) {
            System.out.println("We need to negotiate ");
        }
        else {
            System.out.println("You can take " + amount + " loan");
        }
    }
}
