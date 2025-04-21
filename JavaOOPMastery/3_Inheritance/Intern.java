// Intern subclass
public class Intern extends Employee {
    public Intern(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    public void work() {
        System.out.println(name + " is learning and assisting.");
    }
}
