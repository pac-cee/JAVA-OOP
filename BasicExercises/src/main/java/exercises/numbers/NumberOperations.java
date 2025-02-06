package exercises.numbers;

public class NumberOperations {
    public static String checkNumber(int number) {
        String type = (number > 0) ? "positive" : (number < 0) ? "negative" : "zero";
        String parity = (number % 2 == 0) ? "even" : "odd";
        return "The number is " + type + " and " + parity;
    }

    public static boolean isPalindrome(int number) {
        int original = number;
        int reversed = 0;
        while (number > 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }
        return original == reversed;
    }

    public static String numberToWord(int digit) {
        String[] words = {"Zero", "One", "Two", "Three", "Four", 
                         "Five", "Six", "Seven", "Eight", "Nine"};
        return (digit >= 0 && digit <= 9) ? words[digit] : "Invalid digit";
    }

    public static String getGrade(double percentage) {
        if (percentage >= 90) return "A - Excellent!";
        if (percentage >= 80) return "B - Good job!";
        if (percentage >= 70) return "C - Satisfactory";
        if (percentage >= 60) return "D - Needs improvement";
        return "F - Please see the instructor";
    }
}
