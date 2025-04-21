// Demo for University System project
public class UniversityDemo {
    public static void main(String[] args) {
        Address addr1 = new Address("New York", "5th Ave");
        Address addr2 = new Address("Boston", "Main St");
        Professor prof1 = new Professor("Dr. Smith", addr1);
        Professor prof2 = new Professor("Dr. Jones", addr2);
        Department cs = new Department("Computer Science");
        cs.addProfessor(prof1);
        cs.addProfessor(prof2);
        cs.listProfessors();
    }
}
