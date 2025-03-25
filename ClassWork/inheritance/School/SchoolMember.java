public abstract class SchoolMember implements Person {
    private String name;
    private int age;
    private String idNumber;
    private static Set<String> existingIds = new HashSet<>();
    
    public SchoolMember(String name, int age, String idNumber) {
        validateName(name);
        validateAge(age);
        validateIdNumber(idNumber);
        
        this.name = name;
        this.age = age;
        this.idNumber = idNumber;
    }
    
    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }
    
    private void validateAge(int age) {
        if (age < 5) {
            throw new IllegalArgumentException("Age must be at least 5");
        }
    }
    
    private void validateIdNumber(String idNumber) {
        if (idNumber == null || !idNumber.matches("SCH-\\d{5}")) {
            throw new IllegalArgumentException("ID must follow format SCH-XXXXX");
        }
        
        if (existingIds.contains(idNumber)) {
            throw new IllegalArgumentException("ID already exists: " + idNumber);
        }
        
        existingIds.add(idNumber);
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getIdNumber() {
        return idNumber;
    }
    
    @Override
    public String getDetails() {
        return "Name: " + name + ", Role: " + getRole() + ", ID: " + idNumber;
    }
    
    public abstract List<String> getResponsibilities();
}