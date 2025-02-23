public class School<T extends StudentOne> {
    private final T student;

    public School(T student) {
        this.student = student;
    }

    public void displayStudentInfo() {
        System.out.println("Student ID: " + student.getId());
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Age: " + student.getAge());
        System.out.println("Student Email: " + student.getEmail());
        System.out.println("Student Address: " + student.getAddress());
        System.out.println();
    }

    public static void main(String[] args) {
        StudentOne studentOne = new StudentOne(
            1, 
            20, 
            "Alice",
            "zDd6l@example.com",
            "123 Main St, Anytown, USA");

        StudentOne studentTwo = new StudentOne(
            2,
            21,
            "Bob",
            "lVf2o@example.com",
            "456 Main St, Anytown, USA");

        StudentOne studentThree = new StudentOne(
            3,
            22,
            "Charlie",
            "TQoQI@example.com",
            "789 Main St, Anytown, USA");  

        School<StudentOne> school1 = new School<>(studentOne);
        School<StudentOne> school2 = new School<>(studentTwo);
        School<StudentOne> school3 = new School<>(studentThree);

        school1.displayStudentInfo();
        school2.displayStudentInfo();
        school3.displayStudentInfo();
    }
}