package com.oopmastery.inheritance.shape;

/**
 * Abstract base class for all shapes.
 * Shows:
 * 1. Abstract methods
 * 2. Protected fields
 * 3. Common validation
 * 4. Template methods
 */
public abstract class Shape {
    private String color;
    private boolean filled;

    /**
     * Constructor for Shape
     * @param color The color of the shape
     * @param filled Whether the shape is filled
     */
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    /**
     * Gets the color of the shape
     * @return The color
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the shape
     * @param color The new color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Checks if the shape is filled
     * @return true if filled, false otherwise
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * Sets whether the shape is filled
     * @param filled The new filled state
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Gets a description of the fill state
     * @return A string describing the fill state
     */
    public String getFillDescription() {
        return filled ? "filled" : "not filled";
    }

    /**
     * Gets the type of shape (e.g., "Circle", "Rectangle")
     * @return The shape type
     */
    public String getType() {
        return getClass().getSimpleName();
    }

    /**
     * Validates that a dimension is positive
     * @param value The dimension value to check
     * @param name The name of the dimension for error messages
     * @throws IllegalArgumentException if value is not positive
     */
    protected void validatePositiveDimension(double value, String name) {
        if (value <= 0) {
            throw new IllegalArgumentException(
                name + " must be positive, got: " + value);
        }
    }

    /**
     * Calculates the area of the shape
     * @return The area
     */
    public abstract double getArea();

    /**
     * Calculates the perimeter of the shape
     * @return The perimeter
     */
    public abstract double getPerimeter();

    @Override
    public String toString() {
        return String.format("%s[color=%s,%s]", 
            getType(), color, getFillDescription());
    }
} 