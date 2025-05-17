// ContactManager class for Contact Manager Project
import java.util.*;
import java.io.*;

public class ContactManager {
    private List<Contact> contacts = new ArrayList<>();
    private static final String FILE_NAME = "contacts.ser";

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added.");
    }

    public void removeContact(String name) {
        contacts.removeIf(c -> c.getName().equalsIgnoreCase(name));
        System.out.println("Contact removed if it existed.");
    }

    public void searchContact(String name) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println(c);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void listContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    public void saveContacts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(contacts);
            System.out.println("Contacts saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    public void loadContacts() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            contacts = (List<Contact>) ois.readObject();
            System.out.println("Contacts loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No contacts loaded: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        manager.loadContacts();
        Scanner sc = new Scanner(System.in);
        String command;
        System.out.println("Contact Manager - Commands: add, remove, search, list, save, exit");
        while (true) {
            System.out.print("> ");
            command = sc.nextLine().trim().toLowerCase();
            switch (command) {
                case "add":
                      System.out.print("Name: ");
		      String name = sc.nextLine();
        	      while (name == null || name.trim().isEmpty() || !name.matches("[a-zA-Z ]+")) {
          	     System.out.print("Invalid. Enter Name (letters only): ");
            	     name = sc.nextLine();
          	}    
        	     System.out.print("Email: ");
        	     String email = sc.nextLine();
        	     while (email == null || !email.contains("@")) {
            	     System.out.print("Invalid. Enter Email: ");
            	     email = sc.nextLine();
        }
		    System.out.print("Phone: ");
        	    String phone = sc.nextLine();
        	    while (phone == null || phone.length() < 10) {
            	    System.out.print("Invalid. Enter Phone (min 10 digits): ");
            	    phone = sc.nextLine();
        }
                    manager.addContact(new Contact(name, phone, email));
                    break;
                case "remove":
                    System.out.print("Name: ");
                    name = sc.nextLine();
                    manager.removeContact(name);
                    break;
                case "search":
                    System.out.print("Name: ");
                    name = sc.nextLine();
                    manager.searchContact(name);
                    break;
                case "list":
                    manager.listContacts();
                    break;
                case "save":
                    manager.saveContacts();
                    break;
                case "exit":
                    manager.saveContacts();
                    System.out.println("Exiting Contact Manager.");
                    return;
                default:
                    System.out.println("Unknown command.");
            }
        }
    }
}
