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
    public StudentOne(int age, int id){
        this.age = age;
        this.id = id;

    }
        
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
