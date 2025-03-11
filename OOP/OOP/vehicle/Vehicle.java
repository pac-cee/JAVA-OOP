package OOP.vehicle;

/**
 * Abstract base class for all vehicles
 */
public abstract class Vehicle {
    protected String make;
    protected String model;
    protected int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void start() {
        System.out.println("The " + make + " " + model + " is starting...");
    }

    public void stop() {
        System.out.println("The " + make + " " + model + " is stopping...");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [make=" + make + ", model=" + model + ", year=" + year + "]";
    }

    // Getters and setters
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
} 