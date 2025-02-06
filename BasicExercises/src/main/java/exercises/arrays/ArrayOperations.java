package exercises.arrays;

public class ArrayOperations {
    public static int[] generateFirstNPrimes(int n) {
        int[] primes = new int[n];
        int count = 0;
        int number = 2;
        
        while (count < n) {
            if (isPrime(number)) {
                primes[count] = number;
                count++;
            }
            number++;
        }
        
        return primes;
    }
    
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
