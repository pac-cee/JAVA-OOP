import basics.Person;
import inheritance.Animal;
import inheritance.Dog;
import inheritance.Cat;
import abstraction.Shape;
import abstraction.Circle;
import abstraction.Rectangle;
import abstraction.Drawable;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== OOP Concepts Demonstration ===\n");

        // 1. Encapsulation Demo
        System.out.println("1. Encapsulation:");
        Person person = new Person("John", 25);
        person.introduce();
        person.setAge(26);  // Using setter
        System.out.println("Updated age: " + person.getAge() + "\n");  // Using getter

        // 2. Inheritance and Polymorphism Demo
        System.out.println("2. Inheritance and Polymorphism:");
        Animal dog = new Dog("Buddy", "Golden Retriever");
        Animal cat = new Cat("Whiskers", true);
        
        // Display information about animals
        dog.displayInfo();  // Will show name, species, and breed
        cat.displayInfo();  // Will show name, species, and indoor status
        System.out.println();
        
        // Polymorphic behavior
        dog.makeSound();  // Will print "Woof! Woof!"
        cat.makeSound();  // Will print "Meow!"
        
        // Specific behavior
        Dog actualDog = (Dog) dog;
        System.out.println(actualDog.getName() + " is a " + actualDog.getBreed());
        actualDog.fetch();  // Type casting to access Dog-specific method
        
        Cat actualCat = (Cat) cat;
        System.out.println(actualCat.getName() + " is " + (actualCat.isIndoor() ? "an indoor" : "an outdoor") + " cat");
        actualCat.scratch();
        System.out.println();

        // 3. Abstraction Demo
        System.out.println("3. Abstraction:");
        Shape circle = new Circle("Red", 5.0);
        Shape rectangle = new Rectangle("Blue", 4.0, 6.0);
        
        // Using abstract method
        System.out.println("Circle area: " + circle.calculateArea());
        System.out.println("Rectangle area: " + rectangle.calculateArea());
        
        // Using interface methods
        Drawable drawableCircle = (Circle) circle;
        drawableCircle.draw();
        drawableCircle.displayInfo();
    }
}
