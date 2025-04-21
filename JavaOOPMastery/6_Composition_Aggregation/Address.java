// Address class for University System project
public class Address {
    private String city;
    private String street;
    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }
    @Override
    public String toString() {
        return street + ", " + city;
    }
}
