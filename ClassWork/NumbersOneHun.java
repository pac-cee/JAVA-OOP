package classwork;
public class NumbersOneHun {
    public static void main(String[] args) {
        int number = 100;
        do {
            if (isPrime(number)) {
                System.out.println(number);
            }
            number--;
        } while (number >= 20);
    }

    
    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        
        for (int i = 2; i <= java.lang.Math.sqrt((double) num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
