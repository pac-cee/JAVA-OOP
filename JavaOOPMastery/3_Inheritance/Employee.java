// Base Employee class
public class Employee {
    protected String name;
    protected int id;
    protected double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void work() {
        System.out.println(name + " is working.");
    }

    @Override
    public String toString() {
        return "Employee: " + name + ", ID: " + id + ", Salary: " + salary;
    }
}
