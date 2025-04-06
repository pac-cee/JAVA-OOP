public class DepartmentAllocation extends StudentProfile {
    
    public DepartmentAllocation(Student student) {
        super(student);
    }
    
    @Override
    public boolean registerStudent() {
        // This method should be implemented in StudentRegistration class
        System.out.println("This method is not implemented in this class");
        return false;
    }
    
    @Override
    public boolean payFees(double amount) {
        // This method should be implemented in RegistrationFees class
        System.out.println("This method is not implemented in this class");
        return false;
    }
    
    @Override
    public boolean allocateDepartment(String department) {
        try {
            // Check if payment has been made
            if (!student.isPaymentStatus()) {
                System.out.println("Error: Department allocation requires full payment of registration fees");
                return false;
            }
            
            // Validate department choice based on program
            if (student.getProgram().equalsIgnoreCase("Undergraduate")) {
                if (!department.equalsIgnoreCase("Software Engineering") && 
                    !department.equalsIgnoreCase("Networking") && 
                    !department.equalsIgnoreCase("Information Management")) {
                    System.out.println("Error: Invalid department choice for Undergraduate program");
                    System.out.println("Available departments: Software Engineering, Networking, Information Management");
                    return false;
                }
            } else if (student.getProgram().equalsIgnoreCase("Postgraduate")) {
                if (!department.equalsIgnoreCase("Big Data") && 
                    !department.equalsIgnoreCase("Project Management") && 
                    !department.equalsIgnoreCase("Accounting")) {
                    System.out.println("Error: Invalid department choice for Postgraduate program");
                    System.out.println("Available departments: Big Data, Project Management, Accounting");
                    return false;
                }
            }
            
            // Assign department and display confirmation
            student.setDepartment(department);
            System.out.println("Department allocation successful!");
            System.out.println("Student: " + student.getStudentName());
            System.out.println("Program: " + student.getProgram());
            System.out.println("Department: " + student.getDepartment());
            return true;
            
        } catch (Exception e) {
            System.out.println("Department Allocation Error: " + e.getMessage());
            return false;
        }
    }
}
