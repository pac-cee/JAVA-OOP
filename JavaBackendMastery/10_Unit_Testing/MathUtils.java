// Utility class for math operations
public class MathUtils {
    public static int reverse(int n) {
        int rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
