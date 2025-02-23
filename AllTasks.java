import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AllTasks {

    // 1. Find the smallest among three numbers
    public static int findSmallest(int a, int b, int c) {
        return Integer.min(a, Integer.min(b, c));
    }

    // 2. Compute the average of three numbers
    public static double computeAverage(double a, double b, double c) {
        return (a + b + c) / 3.0;
    }

    // 3. Get the middle character(s) of a string.
    // Note (per instructions): if length is odd, return two middle characters; if even, return one.
    public static String getMiddleCharacters(String s) {
        int len = s.length();
        if (len == 0) return "";
        int mid = len / 2;
        if (len % 2 != 0) { // odd length -> two middle characters (if possible)
            // Special case: if string has only one char, just return it.
            return (len >= 2 && mid + 1 < len) ? s.substring(mid, mid + 2) : s;
        } else { // even length -> one middle character
            return s.substring(mid, mid + 1);
        }
    }

    // 4. Count vowels in a string
    public static int countVowels(String s) {
        int count = 0;
        for (char ch : s.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(ch) >= 0) {
                count++;
            }
        }
        return count;
    }

    // 5. Count words in a string
    public static int countWords(String s) {
        if (s.trim().isEmpty()) return 0;
        // Split on one or more whitespace characters
        return s.trim().split("\\s+").length;
    }

    // 6. Sum of digits in an integer
    public static int sumDigits(int n) {
        int sum = 0;
        n = java.lang.Math.abs((int) n);
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    // 7. Display the first 50 pentagonal numbers.
    // Formula: P(n) = (3*n*n - n) / 2
    public static void printPentagonalNumbers() {
        final int total = 50;
        for (int i = 1; i <= total; i++) {
            long pentagonal = (3L * i * i - i) / 2;
            System.out.printf("%5d ", pentagonal);
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }

    // 8. Compute Future Investment Value.
    // Formula: futureValue = investmentAmount * (1 + monthlyInterestRate)^(years * 12)
    public static double computeFutureInvestment(double investment, double annualRate, int years) {
        double monthlyRate = (annualRate / 100) / 12;
        return investment * java.lang.Math.pow(1 + monthlyRate, years * 12);
    }

    // 9. Print characters between two characters (inclusive), printing 20 per line.
    public static void printCharsBetween(char start, char end) {
        if (start > end) { // swap if necessary
            char temp = start;
            start = end;
            end = temp;
        }
        int count = 0;
        for (int ch = start; ch <= end; ch++) {
            System.out.print((char) ch + " ");
            count++;
            if (count % 20 == 0) {
                System.out.println();
            }
        }
        if (count % 20 != 0) {
            System.out.println();
        }
    }

    // 10. Check if a year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }

    // 11. Validate password.
    // Rules: At least 10 characters, only letters and digits, and at least 2 digits.
    public static boolean isValidPassword(String password) {
        if (password.length() < 10) return false;
        int digitCount = 0;
        for (char ch : password.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) return false;
            if (Character.isDigit(ch)) digitCount++;
        }
        return digitCount >= 2;
    }

    // 12. Display an n-by-n matrix filled with sequential numbers.
    public static void displayMatrix(int n) {
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", count++);
            }
            System.out.println();
        }
    }

    // 13. Calculate the area of a triangle using base and height.
    public static double triangleArea(double base, double height) {
        return 0.5 * base * height;
    }

    // 14. Calculate the area of a regular pentagon given the side length.
    // Formula: area = (1/4)*sqrt(5*(5+2*sqrt(5)))*side^2
    public static double pentagonArea(double side) {
        return (1.0 / 4.0) * java.lang.Math.sqrt(5 * (5 + 2 * java.lang.Math.sqrt(5))) * side * side;
    }

    // 15. Display the current date and time.
    public static void displayCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Date and Time: " + now.format(formatter));
    }

    // Helper method: Check if a number is prime.
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 16. Find and display twin primes less than 100.
    public static void findTwinPrimes() {
        for (int i = 2; i < 100; i++) {
            if (isPrime(i) && isPrime(i + 2)) {
                System.out.println(i + " and " + (i + 2));
            }
        }
    }

    // 17. Count occurrences of the digit '2' in an integer.
    public static int countDigitTwo(int n) {
        int count = 0;
        n = java.lang.Math.abs(n);
        while (n > 0) {
            if (n % 10 == 2) {
                count++;
            }
            n /= 10;
        }
        return count;
    }

    // 18. Check if three integers are consecutive (in any order).
    public static boolean areConsecutive(int a, int b, int c) {
        int[] arr = {a, b, c};
        java.util.Arrays.sort(arr);
        return (arr[1] - arr[0] == 1) && (arr[2] - arr[1] == 1);
    }

    // 19. Check if one integer is the midpoint of the other two.
    public static boolean isMidpoint(int a, int b, int c) {
        return (2 * a == b + c) || (2 * b == a + c) || (2 * c == a + b);
    }

    // 20. Extract the first digit of an integer.
    public static int extractFirstDigit(int n) {
        n = java.lang.Math.abs(n);
        while (n >= 10) {
            n /= 10;
        }
        return n;
    }

    // 21. Display the factors of the given integer that are divisible by 3.
    public static void displayFactorsOfThree(int n) {
        int abs = java.lang.Math.abs(n);
        for (int i = 1; i <= abs; i++) {
            if (abs % i == 0 && i % 3 == 0) {
                System.out.print(i + " ");
            }
        }
    }

    // 22. Check if every digit in an integer is even.
    public static boolean areAllDigitsEven(int n) {
        n = java.lang.Math.abs(n);
        // Special case: if n is 0, consider it even.
        if (n == 0) return true;
        while (n > 0) {
            int digit = n % 10;
            if (digit % 2 != 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }

    // 23. Check if all characters in a string are vowels.
    public static boolean areAllCharactersVowels(String s) {
        if (s.isEmpty()) return false;
        for (char ch : s.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(ch) < 0) {
                return false;
            }
        }
        return true;
    }

    // Main method: prompt the user and call all methods.
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

        // Task 1
        System.out.println("Task 1: Find the smallest among three numbers.");
        System.out.print("Enter three integers separated by space: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        System.out.println("Smallest: " + findSmallest(num1, num2, num3));

        // Task 2
        System.out.println("\nTask 2: Compute average of three numbers.");
        System.out.print("Enter three numbers separated by space: ");
        double d1 = scanner.nextDouble();
        double d2 = scanner.nextDouble();
        double d3 = scanner.nextDouble();
        System.out.println("Average: " + computeAverage(d1, d2, d3));

        scanner.nextLine(); // consume newline

        // Task 3
        System.out.println("\nTask 3: Find middle character(s) of a string.");
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        System.out.println("Middle character(s): " + getMiddleCharacters(inputString));

        // Task 4
        System.out.println("\nTask 4: Count vowels in a string.");
        System.out.print("Enter a string: ");
        String vowelString = scanner.nextLine();
        System.out.println("Vowel count: " + countVowels(vowelString));

        // Task 5
        System.out.println("\nTask 5: Count words in a string.");
        System.out.print("Enter a string: ");
        String wordsString = scanner.nextLine();
        System.out.println("Word count: " + countWords(wordsString));

        // Task 6
        System.out.println("\nTask 6: Sum of digits in an integer.");
        System.out.print("Enter an integer: ");
        int sumInt = scanner.nextInt();
        System.out.println("Sum of digits: " + sumDigits(sumInt));

        // Task 7
        System.out.println("\nTask 7: Display the first 50 pentagonal numbers:");
        printPentagonalNumbers();

        // Task 8
        System.out.println("\nTask 8: Compute future investment value.");
        System.out.print("Enter investment amount: ");
        double investment = scanner.nextDouble();
        System.out.print("Enter annual interest rate (in %): ");
        double annualRate = scanner.nextDouble();
        System.out.print("Enter number of years: ");
        int years = scanner.nextInt();
        System.out.printf("Future value: %.2f%n", computeFutureInvestment(investment, annualRate, years));

        // Task 9
        System.out.println("\nTask 9: Print characters between two characters.");
        System.out.print("Enter start character: ");
        char startChar = scanner.next().charAt(0);
        System.out.print("Enter end character: ");
        char endChar = scanner.next().charAt(0);
        printCharsBetween(startChar, endChar);

        // Task 10
        System.out.println("\nTask 10: Check leap year.");
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();
        System.out.println(year + (isLeapYear(year) ? " is a leap year." : " is not a leap year."));

        scanner.nextLine(); // consume newline

        // Task 11
        System.out.println("\nTask 11: Validate password.");
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        System.out.println("Password valid: " + isValidPassword(password));

        // Task 12
        System.out.println("\nTask 12: Display an n-by-n matrix.");
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        displayMatrix(n);

        // Task 13
        System.out.println("\nTask 13: Calculate triangle area.");
        System.out.print("Enter base of triangle: ");
        double base = scanner.nextDouble();
        System.out.print("Enter height of triangle: ");
        double height = scanner.nextDouble();
        System.out.println("Triangle area: " + triangleArea(base, height));

        // Task 14
        System.out.println("\nTask 14: Calculate pentagon area.");
        System.out.print("Enter side length of a regular pentagon: ");
        double side = scanner.nextDouble();
        System.out.println("Pentagon area: " + pentagonArea(side));

        // Task 15
        System.out.println("\nTask 15: Display current date and time.");
        displayCurrentDateTime();

        // Task 16
        System.out.println("\nTask 16: Find twin primes less than 100:");
        findTwinPrimes();

        // Task 17
        System.out.println("\nTask 17: Count occurrences of digit '2' in an integer.");
        System.out.print("Enter an integer: ");
        int count2Int = scanner.nextInt();
        System.out.println("Occurrences of digit 2: " + countDigitTwo(count2Int));

        // Task 18
        System.out.println("\nTask 18: Check if three integers are consecutive.");
        System.out.print("Enter three integers separated by space: ");
        int con1 = scanner.nextInt();
        int con2 = scanner.nextInt();
        int con3 = scanner.nextInt();
        System.out.println("Are consecutive: " + areConsecutive(con1, con2, con3));

        // Task 19
        System.out.println("\nTask 19: Check if one integer is the midpoint of the other two.");
        System.out.print("Enter three integers separated by space: ");
        int mid1 = scanner.nextInt();
        int mid2 = scanner.nextInt();
        int mid3 = scanner.nextInt();
        System.out.println("One integer is the midpoint: " + isMidpoint(mid1, mid2, mid3));

        // Task 20
        System.out.println("\nTask 20: Extract the first digit of an integer.");
        System.out.print("Enter an integer: ");
        int extractInt = scanner.nextInt();
        System.out.println("First digit: " + extractFirstDigit(extractInt));

        // Task 21
        System.out.println("\nTask 21: Display factors of the integer that are divisible by 3.");
        System.out.print("Enter an integer: ");
        int factorInt = scanner.nextInt();
        System.out.print("Factors: ");
        displayFactorsOfThree(factorInt);
        System.out.println();

        // Task 22
        System.out.println("\nTask 22: Check if all digits in an integer are even.");
        System.out.print("Enter an integer: ");
        int evenCheck = scanner.nextInt();
        System.out.println("All digits are even: " + areAllDigitsEven(evenCheck));

        scanner.nextLine(); // consume newline

        // Task 23
        System.out.println("\nTask 23: Check if all characters in a string are vowels.");
        System.out.print("Enter a string: ");
        String vowelCheck = scanner.nextLine();
        System.out.println("All characters are vowels: " + areAllCharactersVowels(vowelCheck));

        
     }
    }
}
