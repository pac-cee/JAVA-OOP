public class Student {
    String name;
    int age;
    void study() {
        System.out.println(name + " is studying.");
    }
    public static void main(String[] args) {
        Student john = new Student();
        john.name = "John";
        john.age = 19;
        john.study(); // Output: John is studying.
    }
}
