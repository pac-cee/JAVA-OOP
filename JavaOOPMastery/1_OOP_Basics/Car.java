public class Car {
    String brand;
    int year;
    void drive() {
        System.out.println(brand + " is driving!");
    }
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.brand = "Toyota";
        myCar.year = 2020;
        myCar.drive(); // Output: Toyota is driving!
    }
}
