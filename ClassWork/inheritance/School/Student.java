public class Student extends SchoolMember {
    private int grade;  // 1-12
    private List<String> subjects;
    private Map<String, Double> grades;
    
    public Student(String name, int age, String idNumber, int grade) {
        super(name, age, idNumber);
        validateGrade(grade);
        
        this.grade = grade;
        this.subjects = new ArrayList<>();
        this.grades = new HashMap<>();
    }
    
    private void validateGrade(int grade) {
        if (grade < 1 || grade > 12) {
            throw new IllegalArgumentException("Grade must be between 1 and 12");
        }
    }
    
    public void addSubject(String subject) {
        subjects.add(subject);
    }
    
    public void addGrade(String subject, double grade) {
        if (!subjects.contains(subject)) {
            throw new IllegalArgumentException("Student is not enrolled in " + subject);
        }
        
        if (grade < 0.0 || grade > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
        }
        
        grades.put(subject, grade);
    }
    
    public double calculateGPA() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        
        double sum = 0.0;
        for (double grade : grades.values()) {
            sum += grade;
        }
        
        return sum / grades.size();
    }
    
    @Override
    public String getRole() {
        return "Student";
    }
    
    @Override
    public List<String> getResponsibilities() {
        return Arrays.asList(
            "Complete all assignments and homework",
            "Attend classes regularly and punctually",
            "Participate in class discussions and activities"
        );
    }
    
    @Override
    public String getDetails() {
        return super.getDetails() + ", Grade: " + grade + ", GPA: " + calculateGPA();
    }
    
    public int getGrade() {
        return grade;
    }
    
    public List<String> getSubjects() {
        return new ArrayList<>(subjects);
    }
}

public class Teacher extends SchoolMember {
    private String subjectTaught;
    private double salary;
    
    public Teacher(String name, int age, String idNumber, String subjectTaught, double salary) {
        super(name, age, idNumber);
        this.subjectTaught = subjectTaught;
        validateSalary(salary);
        this.salary = salary;
    }
    
    private void validateSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be positive");
        }
    }
    
    public void teach() {
        System.out.println(getName() + " is teaching " + subjectTaught);
    }
    
    @Override
    public String getRole() {
        return "Teacher";
    }
    
    @Override
    public List<String> getResponsibilities() {
        return Arrays.asList(
            "Prepare and deliver lessons to students",
            "Assess student performance and provide feedback",
            "Manage classroom behavior and create a positive learning environment"
        );
    }
    
    @Override
    public String getDetails() {
        return super.getDetails() + ", Subject: " + subjectTaught + ", Salary: $" + salary;
    }
    
    public String getSubjectTaught() {
        return subjectTaught;
    }
    
    public double getSalary() {
        return salary;
    }
}

public class Administrator extends SchoolMember {
    private String department;
    private static final double MAX_BUDGET_WITHOUT_APPROVAL = 1000000.0;
    
    public Administrator(String name, int age, String idNumber, String department) {
        super(name, age, idNumber);
        this.department = department;
    }
    
    public boolean approveBudget(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Budget amount must be positive");
        }
        
        if (amount > MAX_BUDGET_WITHOUT_APPROVAL) {
            System.out.println("Budget of $" + amount + " requires Board approval");
            return false;
        } else {
            System.out.println("Budget of $" + amount + " approved by " + getName());
            return true;
        }
    }
    
    @Override
    public String getRole() {
        return "Administrator";
    }
    
    @Override
    public List<String> getResponsibilities() {
        return Arrays.asList(
            "Manage school operations and resources",
            "Oversee budgeting and financial planning",
            "Provide leadership and strategic direction"
        );
    }
    
    @Override
    public String getDetails() {
        return super.getDetails() + ", Department: " + department;
    }
    
    public String getDepartment() {
        return department;
    }
}