package ClassWork;
public class LessonFour {
    
    public static String ForLoopMethod (int marks) {
        if (marks % 2 == 0) {
            return "Marks: " + marks + " is an even number";          
        }
        else {
            return "Marks: " + marks + " is an odd number";
        }
    }
    public static int DoWhileLoopMethod (int marks) {
        do {
            if (marks % 2 == 0) {
                System.out.println("Marks: " + marks + " is an even number");          
            }
            else {
                System.out.println("Marks: " + marks + " is an odd number");
            }
            marks++;
        } while (marks <= 10);
        return marks;
    } 

    public static void main(String[] args) {

        System.out.println(ForLoopMethod(4));
        System.out.println(ForLoopMethod(7));
        DoWhileLoopMethod(1);
    }
}
