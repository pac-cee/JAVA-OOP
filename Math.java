
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
    
}