public class Car {
    private Engine engine;
    public Car() {
        engine = new Engine();
    }
    void startCar() {
        engine.start();
        System.out.println("Car is ready to go!");
    }
    public static void main(String[] args) {
        Car car = new Car();
        car.startCar(); // Output: Engine started\nCar is ready to go!
    }
}
