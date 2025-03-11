package OOP;

import OOP.animal.Animal;
import OOP.animal.Bird;
import OOP.animal.Cat;
import OOP.animal.Dog;
import OOP.interfaces.Drivable;
import OOP.interfaces.Flyable;
import OOP.vehicle.Car;
import OOP.vehicle.Vehicle;

/**
 * Main class demonstrating polymorphism, inheritance, and interface usage.
 */
public class Main {
    public static void main(String[] args) {
        // --- Animal Hierarchy ---
        Animal dog = new Dog("Buddy", 3);
        Animal cat = new Cat("Whiskers", 2);
        Animal bird = new Bird("Tweety", 1);
        
        System.out.println(dog);
        System.out.println(cat);
        System.out.println(bird);
        
        // Polymorphic behavior: each animal makes its own sound.
        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
        
        // Check for additional behavior defined via interface
        if (bird instanceof Flyable) {
            Flyable flyable = (Flyable) bird;
            flyable.fly();
        }
        
        // --- Vehicle Hierarchy ---
        Vehicle car = new Car("Toyota", "Corolla", 2022);
        System.out.println(car);
        
        car.start();
        car.stop();
        
        // Using the Drivable interface for driving behavior.
        if (car instanceof Drivable) {
            Drivable drivable = (Drivable) car;
            drivable.drive();
        }
    }
}
