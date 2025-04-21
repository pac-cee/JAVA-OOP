import java.util.*;

public class ContactManager {
    static class Contact {
        String name, phone;
        Contact(String name, String phone) { this.name = name; this.phone = phone; }
        public String toString() { return name + ": " + phone; }
    }
    private Map<String, Contact> contacts = new HashMap<>();

    public void addContact(String name, String phone) {
        contacts.put(name, new Contact(name, phone));
    }
    public void removeContact(String name) {
        contacts.remove(name);
    }
    public Contact searchContact(String name) {
        return contacts.get(name);
    }
    public void listContacts() {
        for (Contact c : contacts.values()) System.out.println(c);
    }
    public static void main(String[] args) {
        ContactManager cm = new ContactManager();
        cm.addContact("Alice", "123-456");
        cm.addContact("Bob", "789-012");
        cm.listContacts();
        System.out.println("Search Bob: " + cm.searchContact("Bob"));
        cm.removeContact("Alice");
        cm.listContacts();
    }
}
