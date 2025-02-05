public class Deposit {
    public static void main(String[] args) {
        int loanAmount; //declaration
        String customerName = "John Doe"; //initialization
        loanAmount = 1000;
        int accountNumber = 1258963;
        System.out.println(customerName + " with account number " + accountNumber + " has a loan amount of " + loanAmount);
        double interest=0.1;
        double total=loanAmount+loanAmount*interest;
        System.out.println(customerName + " must pay " + total);

        getInfo(); //calling a method = to run using main method as only jdk can understand main method.
    }
    public static void getInfo(){
        System.out.println("This helps us in calling a method inside the main method");
    }
}
