import java.util.Scanner;

public class LearnSwitchstatement {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a number: ");
            int num = scanner.nextInt();
            switch (num % 2) {
                case 0 -> System.out.println(num + " is even");
                case 1 -> System.out.println(num + " is odd");
                default -> // in case there is no case condition met
                    System.out.println("Invalid number");
            }
           
        }
    }
}
