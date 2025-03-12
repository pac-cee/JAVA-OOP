    package ClassWork;
    public class StudentOne {
    private final  int id;
    private final int age;
    private String name;
    private String email;
    private String address;

    public StudentOne(int id, int age, String name, String email, String address) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
        this.address = address;
    }

     // Getters
     public int getIdStudent() { return id; }
     public int getAgeStudent() { return age; }
     public String getNameStudent() { return name; }
     public String getEmailStudent() { return email; }
     public String getAddressStudent() { return address; }

     // Removed setter for final variable id and age
     public void setName(String name) { this.name = name; }
     public void setEmail(String email) { this.email = email; }
     public void setAddress(String address) { this.address = address; }
 
        
    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
