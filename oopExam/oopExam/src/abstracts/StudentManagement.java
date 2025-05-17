package abstracts;

public abstract class StudentManagement {
    public String studentId;
    public String fullName;
    public String dateOfBirth;
    public String nationality;
    public String department;
    public String combination;
    public int marks;
    public String schoolName;
    public String registrationDate;
    public double registrationFeePaid;
    public boolean isForeignStudent;

    public abstract boolean validateAge();
    public abstract boolean validateMarks();
    public abstract boolean validateCombination();
    public abstract double calculateRegistrationFee();
} 