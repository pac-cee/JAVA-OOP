// Professor class for University System project
public class Professor {
    private String name;
    private Address address;
    public Professor(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    @Override
    public String toString() {
        return name + " (" + address + ")";
    }
}
