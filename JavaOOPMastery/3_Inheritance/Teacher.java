public class Teacher extends Person {
    void teach() {
        System.out.println(name + " is teaching.");
    }
    public static void main(String[] args) {
        Teacher t = new Teacher();
        t.name = "Mr. Smith";
        t.introduce(); // Output: Hi, my name is Mr. Smith
        t.teach();     // Output: Mr. Smith is teaching.
    }
}
