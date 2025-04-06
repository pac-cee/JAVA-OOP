public class StudentRegistration extends StudentProfile {
    
    public StudentRegistration(Student student) {
        super(student);
    }
    
    @Override
    public boolean registerStudent() {
        try {
            
            if (student.getStudentId() <= 0) {
                System.out.println("Error: Student ID must be a positive integer");
                return false;
            }
            
            if (student.getStudentName() == null || student.getStudentName().trim().isEmpty()) {
                System.out.println("Error: Student name cannot be empty");
                return false;
            }
            
            if (student.getProgram() == null) {
                System.out.println("Error: Program must be specified");
                return false;
            }
            
            if (student.getPreviousQualification() == null || student.getPreviousQualification().trim().isEmpty()) {
                System.out.println("Error: Previous qualification cannot be empty");
                return false;
            }
            
            
            if (student.getProgram().equalsIgnoreCase("Undergraduate")) {
                if (!student.getPreviousQualification().equalsIgnoreCase("A-Level") && 
                    !student.getPreviousQualification().equalsIgnoreCase("equivalency")) {
                    System.out.println("Error: For Undergraduate program, you must have an A-Level or equivalent qualification");
                    return false;
                }
            } else if (student.getProgram().equalsIgnoreCase("Postgraduate")) {
                if (!student.getPreviousQualification().equalsIgnoreCase("Bachelor's degree in Finance") && 
                    !student.getPreviousQualification().equalsIgnoreCase("Bachelor's degree in Accounting")) {
                    System.out.println("Error: For Postgraduate program, you must hold a Bachelor's degree in Finance or Accounting");
                    return false;
                }
            }
            
            System.out.println("Student registration validated successfully!");
            System.out.println("Registration Fee to be paid: " + student.getRegistrationFees());
            return true;
            
        } catch (Exception e) {
            System.out.println("Registration Error: " + e.getMessage());
            return false;
        }
    }
    
    @Override
    public boolean payFees(double amount) {
       
        System.out.println("This method is not implemented in this class");
        return false;
    }
    
    @Override
    public boolean allocateDepartment(String department) {
        
        System.out.println("This method is not implemented in this class");
        return false;
    }
}
