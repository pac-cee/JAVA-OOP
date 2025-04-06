public abstract class StudentProfile {
    protected Student student;
    
    public StudentProfile(Student student) {
        this.student = student;
    }
    
   
    public abstract boolean registerStudent();
    public abstract boolean payFees(double amount);
    public abstract boolean allocateDepartment(String department);
}
