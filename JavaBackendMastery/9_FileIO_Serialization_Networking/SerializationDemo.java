// Demonstrates object serialization in Java
import java.io.*;
class User implements Serializable {
    String name;
    int age;
    User(String name, int age) { this.name = name; this.age = age; }
}
public class SerializationDemo {
    public static void main(String[] args) throws Exception {
        User user = new User("Alice", 25);
        // Serialize
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.ser"));
        out.writeObject(user);
        out.close();
        // Deserialize
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.ser"));
        User loaded = (User) in.readObject();
        in.close();
        System.out.println("Loaded: " + loaded.name + ", " + loaded.age);
    }
}
