public class Student {
    private int[] marks = new int[5];
    

    Student(int m1, int m2, int m3, int m4, int m5) {
        marks[0] = m1;
        marks[1] = m2;
        marks[2] = m3;
        marks[3] = m4;
        marks[4] = m5;
    }
    
    
    public int total() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum;
    }
    
    
    public double avg() {
        double average = total() / 5.0;
        System.out.println("Average marks: " + average);
        return average;
    }
    
   
    public static void main(String[] args) {
        Student s = new Student(80, 90, 75, 85, 95);
        s.avg();
    }
}
