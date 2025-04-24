public class Car {
    // Fields (attributes)
    private String make;
    private String model;
    private int year;
    private String color;
    private boolean isRunning;

    // Constructor
    public Car(String make, String model, int year, String color) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRunning = false;
    }

    // Default constructor
    public Car() {
        this.make = "Unknown";
        this.model = "Unknown";
        this.year = 0;
        this.color = "Unknown";
        this.isRunning = false;
    }

    // Getters and Setters
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isRunning() {
        return isRunning;
    }

    // Methods
    public void start() {
        if (!isRunning) {
            isRunning = true;
            System.out.println("The car has started.");
        } else {
            System.out.println("The car is already running.");
        }
    }

    public void stop() {
        if (isRunning) {
            isRunning = false;
            System.out.println("The car has stopped.");
        } else {
            System.out.println("The car is already stopped.");
        }
    }

    public void drive() {
        if (isRunning) {
            System.out.println("The car is driving.");
        } else {
            System.out.println("Start the car first!");
        }
    }

    public void brake() {
        if (isRunning) {
            System.out.println("The car is braking.");
        } else {
            System.out.println("The car is not running, can't brake.");
        }
    }

    @Override
    public String toString() {
        return year + " " + color + " " + make + " " + model;
    }
}
