package com.oopmastery.inheritance.shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstration class showing inheritance concepts with shapes.
 * Shows:
 * 1. Polymorphism through inheritance
 * 2. Method overriding in action
 * 3. Type checking and casting
 * 4. Working with collections of parent type
 */
public class ShapeDemo {
    public static void main(String[] args) {
        demonstrateShapeHierarchy();
        demonstratePolymorphism();
        demonstrateTypeChecking();
    }

    private static void demonstrateShapeHierarchy() {
        System.out.println("Shape Hierarchy Demonstration");
        System.out.println("-".repeat(30));

        // Create different shapes
        Circle circle = new Circle(5.0, "Red", true);
        Rectangle rectangle = new Rectangle(4.0, 6.0, "Blue", false);

        // Demonstrate individual shape behavior
        System.out.println("Circle details:");
        System.out.println("- " + circle);
        System.out.println("- Area: " + circle.getArea());
        System.out.println("- Perimeter: " + circle.getPerimeter());
        System.out.println("- Diameter: " + circle.getDiameter());

        System.out.println("\nRectangle details:");
        System.out.println("- " + rectangle);
        System.out.println("- Area: " + rectangle.getArea());
        System.out.println("- Perimeter: " + rectangle.getPerimeter());
        System.out.println("- Is Square? " + rectangle.isSquare());
    }

    private static void demonstratePolymorphism() {
        System.out.println("\nPolymorphism Demonstration");
        System.out.println("-".repeat(30));

        // Create a list of shapes (polymorphism)
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(3.0, "Green", true));
        shapes.add(new Rectangle(2.0, 4.0, "Yellow", false));

        // Process all shapes uniformly
        System.out.println("Processing shapes polymorphically:");
        for (Shape shape : shapes) {
            System.out.printf("%s - Area: %.2f, Perimeter: %.2f%n",
                shape.getType(), shape.getArea(), shape.getPerimeter());
        }
    }

    private static void demonstrateTypeChecking() {
        System.out.println("\nType Checking Demonstration");
        System.out.println("-".repeat(30));

        // Create a shape reference to a Circle
        Shape shape = new Circle(4.0, "Purple", true);

        // Demonstrate instanceof and casting
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            System.out.println("Shape is a Circle with diameter: " + 
                circle.getDiameter());
        }

        // Try to modify the shape
        try {
            shape.setColor("Orange");
            System.out.println("Changed color: " + shape);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
} 