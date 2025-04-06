public class Student {
    private int studentId;
    private String studentName;
    private String program;
    private String previousQualification;
    private double registrationFees;
    private boolean paymentStatus = false;
    private String department;

    
    public Student() {}

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        if (studentId <= 0) {
            throw new IllegalArgumentException("Student ID must be a positive integer");
        }
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        if (studentName == null || studentName.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty");
        }
        this.studentName = studentName;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        if (program == null || (!program.equalsIgnoreCase("Undergraduate") && !program.equalsIgnoreCase("Postgraduate"))) {
            throw new IllegalArgumentException("Program must be either 'Undergraduate' or 'Postgraduate'");
        }
        this.program = program;
        
        this.registrationFees = program.equalsIgnoreCase("Undergraduate") ? 300000.0 : 500000.0;
    }

    public String getPreviousQualification() {
        return previousQualification;
    }

    public void setPreviousQualification(String previousQualification) {
        if (previousQualification == null || previousQualification.trim().isEmpty()) {
            throw new IllegalArgumentException("Previous qualification cannot be empty");
        }
        this.previousQualification = previousQualification;
    }

    public double getRegistrationFees() {
        return registrationFees;
    }

   
    public boolean isPaymentStatus() {
        return paymentStatus;
    }
    
    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
}
