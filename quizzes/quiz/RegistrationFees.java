public class RegistrationFees extends StudentProfile {
    
    public RegistrationFees(Student student) {
        super(student);
    }
    
    @Override
    public boolean registerStudent() {
        
        System.out.println("This method is not implemented in this class");
        return false;
    }
    
    @Override
    public boolean payFees(double amount) {
        try {
            
            if (student.getPreviousQualification() == null || student.getPreviousQualification().trim().isEmpty()) {
                System.out.println("Error: Previous qualification must be provided before payment");
                return false;
            }
            
            
            if (amount != student.getRegistrationFees()) {
                System.out.println("Error: Payment amount does not match the required registration fee");
                System.out.println("Required fee: " + student.getRegistrationFees() + ", Provided amount: " + amount);
                return false;
            }
            
            
            student.setPaymentStatus(true);
            System.out.println("Payment successful! Registration confirmed.");
            return true;
            
        } catch (Exception e) {
            System.out.println("Payment Error: " + e.getMessage());
            return false;
        }
    }
    
    @Override
    public boolean allocateDepartment(String department) {
        // This method should be implemented in DepartmentAllocation class
        System.out.println("This method is not implemented in this class");
        return false;
    }
}
