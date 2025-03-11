package ClassWork;

public class Math {
    public static void main(String[] args) {
    
        int smallest = theSmallestNumber(100, 10, 3);
        System.out.println("The smallest number is: " + smallest);
        
        int average = theAverage(100, 10, 3);
        System.out.println("The average is: " + average);
        
        String middleChar = theMiddleChar("Pacifique");
        System.out.println("The middle character is: " + middleChar);
        
        int numberOfVowels = theNumberOfVowels("Julien");
        System.out.println("The number of vowels is: " + numberOfVowels);
        
        int numberOfWords = theNumberOfWords("Pacifique fucks julien in the ass");
        System.out.println("The number of words is: " + numberOfWords);

       
    }
    public static int theSmallestNumber(int a, int b, int c) {
        if (a < b && a < c) {
            return a;
        } else if (b < a && b < c) {
            return b;
        } else {
            return c;
        }
    }
    public static int theAverage(int a, int b, int c) {
        return (a + b + c) / 3;
    }

    public static String theMiddleChar(String str) {
        int position;
        int length;
        if (str.length() % 2 == 0) {
            position = str.length() / 2 - 1;
            length = 2;
        } else {
            position = str.length() / 2;
            length = 1;
        }
        return str.substring(position, position + length);
       
    }
    public static int theNumberOfVowels(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                count++;
            }
        }
        return count;
    }
    public static int theNumberOfWords(String str) {
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }
        
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
        
        private static boolean isPrime(double num) {
            if (num <= 1) return false;
            for (int i = 2; i <= java.lang.Math.sqrt(num); i++) {
                if (num % i == 0) return false;
            }
            return true;
        }
    }
}