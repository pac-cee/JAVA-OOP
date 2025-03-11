package com.oopmastery.inheritance.shape;

/**
 * Circle class demonstrating inheritance from Shape.
 * Shows:
 * 1. Extending an abstract class
 * 2. Implementing abstract methods
 * 3. Using super constructor
 * 4. Adding specific fields and methods
 */
public class Circle extends Shape {
    private double radius;

    /**
     * Constructs a Circle with specified radius, color, and fill.
     * @param radius The radius of the circle
     * @param color The color of the circle
     * @param filled Whether the circle is filled
     * @throws IllegalArgumentException if radius is not positive
     */
    public Circle(double radius, String color, boolean filled) {
        super(color, filled); // Call parent constructor
        validatePositiveDimension(radius, "Radius"); // Use inherited validation
        this.radius = radius;
    }

    /**
     * Gets the radius of the circle.
     * @return The radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the circle.
     * @param radius The new radius
     * @throws IllegalArgumentException if radius is not positive
     */
    public void setRadius(double radius) {
        validatePositiveDimension(radius, "Radius");
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getFillDescription() {
        // Demonstrate method overriding with custom behavior
        return super.getFillDescription() + " with radius " + radius;
    }

    /**
     * Circle-specific method to calculate diameter.
     * @return The diameter of the circle
     */
    public double getDiameter() {
        return 2 * radius;
    }

    @Override
    public String toString() {
        return String.format("%s[radius=%.2f]", super.toString(), radius);
    }
} 