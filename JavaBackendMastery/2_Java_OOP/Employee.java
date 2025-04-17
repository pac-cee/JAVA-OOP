// Demonstrates inheritance with Employee extending Person
public class Employee extends Person {
    private String company;
    public Employee(String name, int age, String company) {
        super(name, age);
        this.company = company;
    }
    public void work() {
        System.out.println("Working at " + company);
    }
    public static void main(String[] args) {
        Employee bob = new Employee("Bob", 30, "TechCorp");
        bob.introduce();
        bob.work();
    }
}
