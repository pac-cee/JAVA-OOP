// Manager.java
public class Manager extends Employee {

    public Manager(String name, int id, double salary, String department) {
        super(name, id, salary, department);
    }

    @Override
    public double calculateBonus() {
        return getSalary() * 0.20;
    }

    @Override
    public void displayEmployeeInfo() {
        System.out.println("Manager Information:");
        System.out.println("Name: " + getName());
        System.out.println("ID: " + getId());
        System.out.println("Department: " + getDepartment());
        System.out.printf("Salary: %.2f%n", getSalary());
        System.out.printf("Bonus (20%%): %.2f%n", calculateBonus());
    }
}
