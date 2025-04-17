// Demonstrates a simple Person class with encapsulation
public class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void introduce() {
        System.out.println("Hi, my name is " + name + " and I am " + age + " years old.");
    }
    public static void main(String[] args) {
        Person alice = new Person("Alice", 22);
        alice.introduce();
    }
}
