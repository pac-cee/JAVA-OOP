// Developer.java
public class Developer extends Employee {

    public Developer(String name, int id, double salary, String department) {
        super(name, id, salary, department);
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.10;
    }

    @Override
    public void displayEmployeeInfo() {
        System.out.println("Developer Information:");
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getId());
        System.out.println("Department: " + getDepartment());
        System.out.printf("Salary: %.2f%n", getSalary());
        System.out.printf("Bonus (10%%): %.2f%n", calculateBonus());
    }
}
