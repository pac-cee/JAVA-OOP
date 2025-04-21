// Demo for Employee Management System
public class EmployeeDemo {
    public static void main(String[] args) {
        Employee[] employees = {
            new Manager("Bob", 1, 90000),
            new Developer("Carol", 2, 80000),
            new Intern("Dave", 3, 30000)
        };
        for (Employee e : employees) {
            System.out.println(e);
            e.work();
        }
    }
}
