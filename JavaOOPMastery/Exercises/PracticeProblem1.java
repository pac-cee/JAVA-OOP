// Practice problem: Create a class Student with name and grade, and print details
class Student {
    String name;
    double grade;
    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
    public void printDetails() {
        System.out.println(name + ": " + grade);
    }
}

public class PracticeProblem1 {
    public static void main(String[] args) {
        Student s = new Student("John", 88.5);
        s.printDetails();
    }
}
