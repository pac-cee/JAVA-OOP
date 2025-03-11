package com.oopmastery.inheritance.shape;

/**
 * Rectangle class demonstrating inheritance from Shape.
 * Shows:
 * 1. Multiple fields in child class
 * 2. Method overriding
 * 3. Additional functionality
 */
public class Rectangle extends Shape {
    private double width;
    private double height;

    /**
     * Constructs a Rectangle with specified dimensions, color, and fill.
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     * @param color The color of the rectangle
     * @param filled Whether the rectangle is filled
     * @throws IllegalArgumentException if width or height is not positive
     */
    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        validatePositiveDimension(width, "Width");
        validatePositiveDimension(height, "Height");
        this.width = width;
        this.height = height;
    }

    /**
     * Gets the width of the rectangle.
     * @return The width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the width of the rectangle.
     * @param width The new width
     * @throws IllegalArgumentException if width is not positive
     */
    public void setWidth(double width) {
        validatePositiveDimension(width, "Width");
        this.width = width;
    }

    /**
     * Gets the height of the rectangle.
     * @return The height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the rectangle.
     * @param height The new height
     * @throws IllegalArgumentException if height is not positive
     */
    public void setHeight(double height) {
        validatePositiveDimension(height, "Height");
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    /**
     * Checks if the rectangle is a square.
     * @return true if width equals height, false otherwise
     */
    public boolean isSquare() {
        return width == height;
    }

    @Override
    public String toString() {
        return String.format("%s[width=%.2f, height=%.2f]", 
            super.toString(), width, height);
    }
} 