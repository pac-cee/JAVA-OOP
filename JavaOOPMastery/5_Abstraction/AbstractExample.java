// Demonstrates abstraction with abstract classes
abstract class Vehicle {
    abstract void start();
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car starts");
    }
}

public class AbstractExample {
    public static void main(String[] args) {
        Vehicle v = new Car();
        v.start();
    }
}
