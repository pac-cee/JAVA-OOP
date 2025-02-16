public class LearnIfstatement {
    public static void main(String[] args) {
        int c,java,oop,webtech,dbms;
        c=20; java=10; oop=20; webtech=40; dbms=15;
        double avg = (c+java+oop+webtech+dbms) / 5;

        if(avg>80){
            if (c>=80){ //nested if statement meaning an if statement inside another if statement
                avg=avg+2;
                System.out.println(avg);
            }
            System.out.println("The average is " + avg + " and the letter of grading is A");
        } else if (avg>=70 && avg<=80) {
            System.out.println("The average is " + avg + " and the letter of grading is B");
        } else if (avg>=50 && avg<=69) {
            System.out.println("The average is " + avg + " and the letter of grading is C");
        }
        else {
            System.out.println("The average is " + avg + " and the letter of grading is D");
        }
    }
}
