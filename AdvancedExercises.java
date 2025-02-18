import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class AdvancedExercises {

    // 1. Find the smallest number among three numbers.
    public static int findSmallest(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    // 2. Compute the average of three numbers.
    public static double computeAverage(double a, double b, double c) {
        return (a + b + c) / 3.0;
    }

    // 3. Get the middle character(s) of a string.
    // Note: If the string length is odd, return two middle characters; if even, return one.
    public static String getMiddleCharacters(String s) {
        if (s == null || s.isEmpty()) return "";
        int len = s.length();
        int mid = len / 2;
        // According to instructions: odd length → two middle characters (if possible)
        // even length → one middle character.
        if (len % 2 != 0) {
            return (len == 1) ? s : s.substring(mid, Math.min(mid + 2, len));
        } else {
            return s.substring(mid, mid + 1);
        }
    }

    // 4. Count vowels in a string.
    public static int countVowels(String s) {
        int count = 0;
        for (char ch : s.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) count++;
        }
        return count;
    }

    // 5. Count words in a string.
    public static int countWords(String s) {
        if (s == null || s.trim().isEmpty()) return 0;
        return s.trim().split("\\s+").length;
    }

    // 6. Compute the sum of digits in an integer.
    public static int sumDigits(int number) {
        int sum = 0;
        number = Math.abs(number);
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    // 7. Display the first 50 pentagonal numbers.
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

    // 8. Compute the future investment value.
    public static double computeFutureInvestmentValue(double investment, double annualRate, int years) {
        double monthlyRate = (annualRate / 100) / 12;
        return investment * Math.pow(1 + monthlyRate, years * 12);
    }

    // 9. Print characters between two characters (inclusive), printing 20 per line.
    public static void printCharsBetween(char start, char end) {
        if (start > end) {
            char temp = start;
            start = end;
            end = temp;
        }
        int count = 0;
        for (int ch = start; ch <= end; ch++) {
            System.out.print((char) ch + " ");
            count++;
            if (count % 20 == 0) System.out.println();
        }
        if (count % 20 != 0) System.out.println();
    }

    // 10. Check whether a year is a leap year.
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }

    // 11. Validate a password.
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

    // 12. Display an n-by-n matrix with sequential numbers.
    public static void displayMatrix(int n) {
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", count++);
            }
            System.out.println();
        }
    }

    // 13. Calculate the area of a triangle.
    public static double triangleArea(double base, double height) {
        return 0.5 * base * height;
    }

    // 14. Calculate the area of a regular pentagon.
    public static double pentagonArea(double side) {
        return (1.0 / 4.0) * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * side * side;
    }

    // 15. Display the current date and time.
    public static void displayCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Date and Time: " + now.format(formatter));
    }

    // 16. Find and display twin primes less than 100.
    public static void findTwinPrimes() {
        for (int i = 2; i < 100; i++) {
            if (isPrime(i) && isPrime(i + 2)) {
                System.out.println(i + " and " + (i + 2));
            }
        }
    }

    // Helper method to check if a number is prime.
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 17. Count occurrences of the digit '2' in an integer.
    public static int countDigitTwo(int number) {
        int count = 0;
        number = Math.abs(number);
        while (number > 0) {
            if (number % 10 == 2) count++;
            number /= 10;
        }
        return count;
    }

    // 18. Check if three integers are consecutive (in any order).
    public static boolean areConsecutive(int a, int b, int c) {
        int[] arr = { a, b, c };
        Arrays.sort(arr);
        return (arr[1] - arr[0] == 1) && (arr[2] - arr[1] == 1);
    }

    // 19. Check if one integer is the midpoint between the other two.
    public static boolean isMidpoint(int a, int b, int c) {
        return (2 * a == b + c) || (2 * b == a + c) || (2 * c == a + b);
    }

    // 20. Extract the first digit of an integer.
    public static int extractFirstDigit(int number) {
        number = Math.abs(number);
        while (number >= 10) {
            number /= 10;
        }
        return number;
    }

    // 21. Display the factors of the given integer that are divisible by 3.
    public static void displayFactorsOfThree(int number) {
        number = Math.abs(number);
        for (int i = 1; i <= number; i++) {
            if (number % i == 0 && i % 3 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // 22. Check if all digits in an integer are even.
    public static boolean areAllDigitsEven(int number) {
        number = Math.abs(number);
        if (number == 0) return true;
        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 != 0) return false;
            number /= 10;
        }
        return true;
    }

    // 23. Check if all characters in a string are vowels.
    public static boolean areAllCharactersVowels(String s) {
        if (s.isEmpty()) return false;
        for (char ch : s.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(ch) == -1) return false;
        }
        return true;
    }

    /**
     * Main method that displays a menu to select which exercise to run.
     * Uses a loop to allow multiple tests with user-provided inputs.
     */
    public static void main(String[] args) {
        // Use try-with-resources to automatically close the Scanner.
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;
            while (true) {
                System.out.println("==================================");
                System.out.println("Choose an exercise to run (1-23) or 0 to exit:");
                System.out.println(" 1.  Find smallest among three numbers");
                System.out.println(" 2.  Compute average of three numbers");
                System.out.println(" 3.  Find middle character(s) of a string");
                System.out.println(" 4.  Count vowels in a string");
                System.out.println(" 5.  Count words in a string");
                System.out.println(" 6.  Sum of digits in an integer");
                System.out.println(" 7.  Display first 50 pentagonal numbers");
                System.out.println(" 8.  Compute future investment value");
                System.out.println(" 9.  Print characters between two characters");
                System.out.println("10.  Check leap year");
                System.out.println("11.  Validate password");
                System.out.println("12.  Display n-by-n matrix");
                System.out.println("13.  Calculate triangle area");
                System.out.println("14.  Calculate pentagon area");
                System.out.println("15.  Display current date and time");
                System.out.println("16.  Find twin primes less than 100");
                System.out.println("17.  Count occurrences of digit '2' in an integer");
                System.out.println("18.  Check if three integers are consecutive");
                System.out.println("19.  Check if one integer is the midpoint of the other two");
                System.out.println("20.  Extract the first digit of an integer");
                System.out.println("21.  Display factors of 3 in an integer");
                System.out.println("22.  Check if all digits in an integer are even");
                System.out.println("23.  Check if all characters in a string are vowels");
                System.out.print("Enter your choice: ");
                
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                if (choice == 0) {
                    System.out.println("Exiting. Goodbye!");
                    break;
                }
                
                // Use the modern switch expression syntax (arrow labels) for clarity.
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter three integers separated by space: ");
                        int a = scanner.nextInt();
                        int b = scanner.nextInt();
                        int c = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Smallest: " + findSmallest(a, b, c));
                    }
                    case 2 -> {
                        System.out.print("Enter three numbers separated by space: ");
                        double a = scanner.nextDouble();
                        double b = scanner.nextDouble();
                        double c = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Average: " + computeAverage(a, b, c));
                    }
                    case 3 -> {
                        System.out.print("Enter a string: ");
                        String input = scanner.nextLine();
                        System.out.println("Middle character(s): " + getMiddleCharacters(input));
                    }
                    case 4 -> {
                        System.out.print("Enter a string: ");
                        String input = scanner.nextLine();
                        System.out.println("Vowel count: " + countVowels(input));
                    }
                    case 5 -> {
                        System.out.print("Enter a string: ");
                        String input = scanner.nextLine();
                        System.out.println("Word count: " + countWords(input));
                    }
                    case 6 -> {
                        System.out.print("Enter an integer: ");
                        int num = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Sum of digits: " + sumDigits(num));
                    }
                    case 7 -> {
                        System.out.println("First 50 pentagonal numbers:");
                        printPentagonalNumbers();
                    }
                    case 8 -> {
                        System.out.print("Enter investment amount: ");
                        double investment = scanner.nextDouble();
                        System.out.print("Enter annual interest rate (in %): ");
                        double annualRate = scanner.nextDouble();
                        System.out.print("Enter number of years: ");
                        int years = scanner.nextInt();
                        scanner.nextLine();
                        System.out.printf("Future investment value: %.2f%n", computeFutureInvestmentValue(investment, annualRate, years));
                    }
                    case 9 -> {
                        System.out.print("Enter start character: ");
                        char start = scanner.next().charAt(0);
                        System.out.print("Enter end character: ");
                        char end = scanner.next().charAt(0);
                        scanner.nextLine();
                        System.out.println("Characters between:");
                        printCharsBetween(start, end);
                    }
                    case 10 -> {
                        System.out.print("Enter a year: ");
                        int year = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println(year + (isLeapYear(year) ? " is a leap year." : " is not a leap year."));
                    }
                    case 11 -> {
                        System.out.print("Enter a password: ");
                        String password = scanner.nextLine();
                        System.out.println("Password valid: " + isValidPassword(password));
                    }
                    case 12 -> {
                        System.out.print("Enter n for n-by-n matrix: ");
                        int n = scanner.nextInt();
                        scanner.nextLine();
                        displayMatrix(n);
                    }
                    case 13 -> {
                        System.out.print("Enter base of triangle: ");
                        double base = scanner.nextDouble();
                        System.out.print("Enter height of triangle: ");
                        double height = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Triangle area: " + triangleArea(base, height));
                    }
                    case 14 -> {
                        System.out.print("Enter side length of pentagon: ");
                        double side = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Pentagon area: " + pentagonArea(side));
                    }
                    case 15 -> displayCurrentDateTime();
                    case 16 -> {
                        System.out.println("Twin primes less than 100:");
                        findTwinPrimes();
                    }
                    case 17 -> {
                        System.out.print("Enter an integer: ");
                        int num = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Occurrences of digit '2': " + countDigitTwo(num));
                    }
                    case 18 -> {
                        System.out.print("Enter three integers separated by space: ");
                        int a = scanner.nextInt();
                        int b = scanner.nextInt();
                        int c = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Are consecutive: " + areConsecutive(a, b, c));
                    }
                    case 19 -> {
                        System.out.print("Enter three integers separated by space: ");
                        int a = scanner.nextInt();
                        int b = scanner.nextInt();
                        int c = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("One integer is the midpoint: " + isMidpoint(a, b, c));
                    }
                    case 20 -> {
                        System.out.print("Enter an integer: ");
                        int num = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("First digit: " + extractFirstDigit(num));
                    }
                    case 21 -> {
                        System.out.print("Enter an integer: ");
                        int num = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Factors of 3 in the integer:");
                        displayFactorsOfThree(num);
                    }
                    case 22 -> {
                        System.out.print("Enter an integer: ");
                        int num = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("All digits are even: " + areAllDigitsEven(num));
                    }
                    case 23 -> {
                        System.out.print("Enter a string: ");
                        String input = scanner.nextLine();
                        System.out.println("All characters are vowels: " + areAllCharactersVowels(input));
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
                System.out.println(); // Extra spacing between iterations
            }
        }
    }
}
