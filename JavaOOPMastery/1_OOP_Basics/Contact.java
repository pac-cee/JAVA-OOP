// Contact class for Contact Manager Project
import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String phone;
    private String email;
    private static int contactCount = 0;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        contactCount++;
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }

    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }

    public static int getContactCount() { return contactCount; }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}
