
public class Math {
    public static void main(String[] args) {
    
        int smallest = theSmallestNumber(5, 10, 3);
        System.out.println("The smallest number is: " + smallest);
        
        int average = theAverage(5, 10, 3);
        System.out.println("The average is: " + average);
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
    
    
}