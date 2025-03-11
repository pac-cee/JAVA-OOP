package OOP.vehicle;

import OOP.interfaces.Drivable;

/**
 * Car class representing a car vehicle that can be driven
 */
public class Car extends Vehicle implements Drivable {
    public Car(String make, String model, int year) {
        super(make, model, year);
    }

    @Override
    public void drive() {
        System.out.println("The " + getMake() + " " + getModel() + " is driving on the road!");
    }
} 