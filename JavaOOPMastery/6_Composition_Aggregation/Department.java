// Department class for University System project
import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Professor> professors;
    public Department(String name) {
        this.name = name;
        this.professors = new ArrayList<>();
    }
    public void addProfessor(Professor p) {
        professors.add(p);
    }
    public void listProfessors() {
        System.out.println("Professors in " + name + ":");
        for (Professor p : professors) {
            System.out.println(p);
        }
    }
}
