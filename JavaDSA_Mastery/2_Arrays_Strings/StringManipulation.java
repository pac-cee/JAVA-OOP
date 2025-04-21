public class StringManipulation {
    // Reverse a string
    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // Check if a string is palindrome
    public static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    // Count occurrences of a substring
    public static int countSubstring(String str, String sub) {
        int count = 0, idx = 0;
        while ((idx = str.indexOf(sub, idx)) != -1) {
            count++;
            idx += sub.length();
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "racecar";
        System.out.println("Reverse: " + reverse(s));
        System.out.println("Is palindrome: " + isPalindrome(s));
        System.out.println("Occurrences of 'car': " + countSubstring(s, "car"));
    }
}
