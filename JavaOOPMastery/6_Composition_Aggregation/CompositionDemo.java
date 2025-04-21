// Demonstrates composition
class Engine {
    public void start() {
        System.out.println("Engine started");
    }
}

class Car {
    private Engine engine;
    public Car() { this.engine = new Engine(); }
    public void start() { engine.start(); }
}

public class CompositionDemo {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
    }
}
