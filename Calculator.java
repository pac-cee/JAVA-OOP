public class Calculator {
    public static void main(String[] args) {
       
        double a = 10;  
        double b = 5;  
        double c = 3;   
        double m = 2;   
        double k = 4;   
        
        
        double result = (a + b) / c * m + k * m;
        
        System.out.println("Result of (a+b)/c*m+k*m = " + result);
        System.out.println("Where:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("m = " + m);
        System.out.println("k = " + k);
    }
}
