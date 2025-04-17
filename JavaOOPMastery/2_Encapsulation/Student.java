public class Student {
    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative!");
        }
    }
    public void study() {
        System.out.println(name + " is studying.");
    }
    public static void main(String[] args) {
        Student alice = new Student();
        alice.setName("Alice");
        alice.setAge(20);
        alice.study(); // Output: Alice is studying.
        alice.setAge(-5); // Output: Age cannot be negative!
    }
}
